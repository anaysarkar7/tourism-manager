package com.travelpackagemanager.main.services;

import com.travelpackagemanager.main.dtos.AvailableActivitiesDto;
import com.travelpackagemanager.main.dtos.ItineraryDetailsDto;
import com.travelpackagemanager.main.dtos.PackageDetailsDto;
import com.travelpackagemanager.main.dtos.PassengerDetailsDto;
import com.travelpackagemanager.main.exceptions.RecordNotFoundException;
import com.travelpackagemanager.main.models.Activity;
import com.travelpackagemanager.main.models.Destination;
import com.travelpackagemanager.main.models.Passenger;
import com.travelpackagemanager.main.models.TravelPackage;
import com.travelpackagemanager.main.repositories.PassengerRepository;
import com.travelpackagemanager.main.repositories.TravelPackageRepository;
import com.travelpackagemanager.main.services.strategy.MemberStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TravelAgencyService {

    @Autowired
    private TravelPackageRepository travelPackageRepository;
    @Autowired
    private PassengerTypeFactory passengerTypeFactory;
    @Autowired
    private PassengerRepository passengerRepository;

    public ItineraryDetailsDto getItinerary(Long packageId) throws RecordNotFoundException {
        TravelPackage travelPackage = travelPackageRepository
                .findById(packageId)
                .orElseThrow(RecordNotFoundException::new);
        ItineraryDetailsDto itineraryDetailsDto = new ItineraryDetailsDto();
        itineraryDetailsDto.setTravelPackageName(travelPackage.getName());
        List<Destination> itineraryList = travelPackage.getItineraryList();
        Map<String, List<Activity>> destinationToActivityMap = new HashMap<>();
        for (Destination destination : itineraryList)
            destinationToActivityMap.put(destination.getName(), destination.getActivityList());
        itineraryDetailsDto.setDestinationToActivitiesMap(destinationToActivityMap);
        return itineraryDetailsDto;
    }

    public PackageDetailsDto getPackageDetails(Long packageId) throws RecordNotFoundException {
        TravelPackage travelPackage = travelPackageRepository
                .findById(packageId)
                .orElseThrow(RecordNotFoundException::new);
        PackageDetailsDto packageDetailsDto = new PackageDetailsDto();
        packageDetailsDto.setPackageName(travelPackage.getName());
        packageDetailsDto.setPassengerCapacity(travelPackage.getCapacity());
        packageDetailsDto.setPassengersCurrentlyEnrolled(travelPackage.getEnrolledPassengersCount());
        packageDetailsDto.setPassengerList(travelPackage.getPassengerList());
        return packageDetailsDto;
    }

    public PassengerDetailsDto getPassengerDetails(Long passengerId) throws RecordNotFoundException {
        Passenger passenger = passengerRepository
                .findById(passengerId)
                .orElseThrow(RecordNotFoundException::new);
        PassengerDetailsDto passengerDetailsDto = new PassengerDetailsDto();
        passengerDetailsDto.setPassengerName(passenger.getName());
        passengerDetailsDto.setPassengerNumber(passenger.getPassengerNumber());
        passengerDetailsDto.setWalletBalance(passenger.getWalletBalance());
        Map<Long, List<PassengerDetailsDto.SignedUpActivityDetails>> destinationToActivityDetailsMap = new HashMap<>();
        MemberStrategy memberStrategy = passengerTypeFactory.getMemberTypeStrategy(passenger.getPassengerType());
        for (Activity activity : passenger.getActivityList()) {
            List<PassengerDetailsDto.SignedUpActivityDetails> signedUpActivityDetailsList;
            if(destinationToActivityDetailsMap.containsKey(activity.getDestination().getId())) {
                signedUpActivityDetailsList = destinationToActivityDetailsMap.get(activity.getDestination().getId());
            }
            else signedUpActivityDetailsList = new ArrayList<>();
            PassengerDetailsDto.SignedUpActivityDetails signedUpActivityDetails = new PassengerDetailsDto.SignedUpActivityDetails();
            signedUpActivityDetails.setActivityName(activity.getName());
            Double costPaid = memberStrategy.getDiscount(activity.getCost());
            signedUpActivityDetails.setCostPaidByPassenger(costPaid);
            signedUpActivityDetailsList.add(signedUpActivityDetails);
            destinationToActivityDetailsMap.put(activity.getDestination().getId(), signedUpActivityDetailsList);
        }

        passengerDetailsDto.setDestinationToSignedUpActivities(destinationToActivityDetailsMap);
        return passengerDetailsDto;
    }

    public AvailableActivitiesDto getAvailableActivities(Long packageId) throws RecordNotFoundException {
        TravelPackage travelPackage = travelPackageRepository
                .findById(packageId)
                .orElseThrow(RecordNotFoundException::new);
        AvailableActivitiesDto availableActivitiesDto = new AvailableActivitiesDto();
        List<AvailableActivitiesDto.AvailableActivity> availableActivityList = new ArrayList<>();
        for (Destination destination : travelPackage.getItineraryList()) {
            List<Activity> activityList = destination.getActivityList();
            for (Activity activity : activityList) {
                if (activity.getCapacity() > activity.getEnrolledPassengersCount()) {
                    AvailableActivitiesDto.AvailableActivity availableActivity = new AvailableActivitiesDto.AvailableActivity();
                    availableActivity.setActivity(activity);
                    availableActivity.setNoOfSpacesAvailable(activity.getEnrolledPassengersCount() - activity.getCapacity());
                    availableActivityList.add(availableActivity);
                }
            }
        }
        availableActivitiesDto.setAvailableActivityList(availableActivityList);
        return availableActivitiesDto;
    }

}
