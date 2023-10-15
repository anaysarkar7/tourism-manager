package com.travelpackagemanager.main.services;

import com.travelpackagemanager.main.dtos.PassengerDto;
import com.travelpackagemanager.main.exceptions.RecordNotFoundException;
import com.travelpackagemanager.main.models.Activity;
import com.travelpackagemanager.main.models.Destination;
import com.travelpackagemanager.main.models.Passenger;
import com.travelpackagemanager.main.models.TravelPackage;
import com.travelpackagemanager.main.repositories.ActivityRepository;
import com.travelpackagemanager.main.repositories.PassengerRepository;
import com.travelpackagemanager.main.services.strategy.MemberStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PassengerService {
    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private PassengerTypeFactory passengerFactory;

    @Autowired
    private ActivityRepository activityRepository;

    public Passenger createPassenger(PassengerDto passengerReqDto) {
        return passengerRepository.save(getPassengerFromDto(passengerReqDto));
    }

    public Passenger updateActivityByPassenger(Long passengerId, List<Activity> activityList) {
        // Retrieve the passenger from the database
        Passenger passenger = passengerRepository.findById(passengerId)
                .orElseThrow(() -> new RuntimeException("Passenger not found with ID: " + passengerId));

        passenger.setActivityList(activityList);
        MemberStrategy memberStrategy = passengerFactory.getMemberTypeStrategy(passenger.getPassengerType());
        for (Activity activity: activityList) {
            Double discountValue = memberStrategy.getDiscount(activity.getCost());
            passenger.setWalletBalance(passenger.getWalletBalance()-discountValue);
            List<Passenger> updatedPassengerList = activity.getPassengers();
            if(updatedPassengerList == null) updatedPassengerList = new ArrayList<>();
            updatedPassengerList.add(passenger);
            activity.setPassengers(updatedPassengerList);
            activity.setEnrolledPassengersCount(updatedPassengerList.size());
        }
        activityRepository.saveAll(activityList);
        return passengerRepository.save(passenger);
    }

    private Passenger getPassengerFromDto(PassengerDto passengerDto) {
        Passenger passenger = new Passenger();
        passenger.setPassengerType(passengerDto.getPassengerType().toString());
        passenger.setPassengerNumber(passengerDto.getPassengerNumber());
        passenger.setName(passengerDto.getName());
        passenger.setActivityList(passengerDto.getActivityList());
        passenger.setWalletBalance(passengerDto.getWalletBalance());
        return passenger;
    }
}
