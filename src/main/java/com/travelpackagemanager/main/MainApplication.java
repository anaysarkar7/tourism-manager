package com.travelpackagemanager.main;

import com.travelpackagemanager.main.controllers.*;
import com.travelpackagemanager.main.dtos.*;
import com.travelpackagemanager.main.enums.PassengerType;
import com.travelpackagemanager.main.models.Activity;
import com.travelpackagemanager.main.models.Destination;
import com.travelpackagemanager.main.models.Passenger;
import com.travelpackagemanager.main.models.TravelPackage;
import com.travelpackagemanager.main.repositories.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
// CLIENT CODE
    @Autowired
    private TravelPackageController travelPackageController;
    @Autowired
    private TravelAgencyController travelAgencyController;
    @Autowired
    private DestinationController destinationController;
    @Autowired
    private DestinationRepository destinationRepository;
    @Autowired
    private ActivityController activityController;
    @Autowired
    private PassengerController passengerController;

    public void initialize() {
        DestinationDto destinationDto1 = new DestinationDto();
        destinationDto1.setName("Bangalore");
        destinationDto1.setActivityList(new ArrayList<>());
        Destination destination1 = destinationController.createDestination(destinationDto1);

        DestinationDto destinationDto2 = new DestinationDto();
        destinationDto2.setName("Kashmir");
        destinationDto2.setActivityList(new ArrayList<>());
        Destination destination2 = destinationController.createDestination(destinationDto2);

        //Create Activities
        ActivityDto activityDto1 = new ActivityDto();
        activityDto1.setName("Hiking Adventure");
        activityDto1.setDescription("Explore the beautiful trails in the national park.");
        activityDto1.setCost(100.0);
        activityDto1.setCapacity(20);
        activityDto1.setEnrolledPassengersCount(0);
        activityDto1.setDestination(destination1);
        Activity activity1 = activityController.createActivity(activityDto1);

        ActivityDto activityDto2 = new ActivityDto();
        activityDto2.setName("City Tour");
        activityDto2.setDescription("Guided tour of the city's historic landmarks.");
        activityDto2.setCost(200.0);
        activityDto2.setCapacity(15);
        activityDto2.setEnrolledPassengersCount(0);
        activityDto2.setDestination(destination1);
        Activity activity2 = activityController.createActivity(activityDto2);

        ActivityDto activityDto3 = new ActivityDto();
        activityDto3.setName("Nature Photography");
        activityDto3.setDescription("Capture the scenic beauty of the national park.");
        activityDto3.setCost(200.0);
        activityDto3.setCapacity(15);
        activityDto3.setEnrolledPassengersCount(0);
        activityDto3.setDestination(destination1);
        Activity activity3 = activityController.createActivity(activityDto3);

        ActivityDto activityDto4 = new ActivityDto();
        activityDto4.setName("Museum Visit");
        activityDto4.setDescription("Explore the city's famous museums and art galleries.");
        activityDto4.setCost(100.0);
        activityDto4.setCapacity(25);
        activityDto4.setEnrolledPassengersCount(0);
        activityDto4.setDestination(destination2);
        Activity activity4 = activityController.createActivity(activityDto4);

        ActivityDto activityDto5 = new ActivityDto();
        activityDto5.setName("Cruise Excursion");
        activityDto5.setDescription("Enjoy a relaxing cruise along the coast.");
        activityDto5.setCost(200.0);
        activityDto5.setCapacity(30);
        activityDto5.setEnrolledPassengersCount(0);
        activityDto5.setDestination(destination2);
        Activity activity5 = activityController.createActivity(activityDto5);

        //Update Activity in Destination
        destinationController.updateActivitiesInDestination(destination1.getId(), new ArrayList<>(List.of(activity1,activity2,activity3)));
        destinationController.updateActivitiesInDestination(destination2.getId(), new ArrayList<>(List.of(activity4,activity5)));

        // Creating Some DUMMY Passengers
        PassengerDto passenger1 = new PassengerDto();
        passenger1.setName("Anay");
        passenger1.setPassengerNumber(1);
        passenger1.setPassengerType(PassengerType.GOLD);
        passenger1.setWalletBalance(10000.0);
        passenger1.setActivityList(new ArrayList<>());

        PassengerDto passenger2 = new PassengerDto();
        passenger2.setName("Bhaskar");
        passenger2.setPassengerNumber(2);
        passenger2.setPassengerType(PassengerType.PREMIUM);
        passenger2.setWalletBalance(4000.0);
        passenger2.setActivityList(new ArrayList<>());

        PassengerDto passenger3 = new PassengerDto();
        passenger3.setName("Somen");
        passenger3.setPassengerNumber(3);
        passenger3.setPassengerType(PassengerType.STANDARD);
        passenger3.setWalletBalance(5000.0);
        passenger3.setActivityList(new ArrayList<>());

        PassengerDto passenger4 = new PassengerDto();
        passenger4.setName("Piyush");
        passenger4.setPassengerNumber(4);
        passenger4.setPassengerType(PassengerType.PREMIUM);
        passenger4.setWalletBalance(10000.0);
        passenger4.setActivityList(new ArrayList<>());

        passengerController.createPassenger(passenger1);
        passengerController.createPassenger(passenger2);
        passengerController.createPassenger(passenger3);
        passengerController.createPassenger(passenger4);

        TravelPackageDto travelPackageDto = new TravelPackageDto();
        travelPackageDto.setName("Bangalore Vacation Package");
        travelPackageDto.setCost(1999.0);
        travelPackageDto.setCapacity(50);
        travelPackageDto.setStartDate(new Date());
        travelPackageDto.setEnrolledPassengersCount(0);
        travelPackageDto.setPassengerList(new ArrayList<>());
        List<Destination> destinationList = new ArrayList<>();
        destinationList.add(destination1);
        travelPackageDto.setItineraryList(destinationList);
        TravelPackage travelPackage = travelPackageController.createTravelPackage(travelPackageDto);

        passengerController.updateActivityList(4L, new ArrayList<>(List.of(activity1,activity2,activity3)));
        passengerController.updateActivityList(1L, new ArrayList<>(List.of(activity1,activity2,activity3)));
        passengerController.updateActivityList(3L, new ArrayList<>(List.of(activity2)));
        passengerController.updateActivityList(2L, new ArrayList<>(List.of(activity1,activity3)));

        System.out.println("__________________________________________________________________");
        /**
         *
         * 1. Print itinerary of the travel package including:
         *     1. travel package name,
         *     2. destinations and details of the activities available at each destination, like name, cost, capacity and description.
         * */
        ItineraryDetailsDto itineraryDetailsDto = travelAgencyController.getItinerary(travelPackage.getId());
        System.out.println(itineraryDetailsDto.getTravelPackageName());
        System.out.println("Destinations: ");
        for(String destination:itineraryDetailsDto.getDestinationToActivitiesMap().keySet()) {
            System.out.println(destination +" , Activity-> ");
            for(Activity activity: itineraryDetailsDto.getDestinationToActivitiesMap().get(destination)) {
                System.out.println(activity+" ,");
            }
        }
        System.out.println("__________________________________________________________________");
        /**
         *
         * 2. Print the passenger list of the travel package including:
         *     1. package name,
         *     2. passenger capacity,
         *     3. number of passengers currently enrolled and
         *     4. name and number of each passenger
         * */
        PackageDetailsDto packageDetailsDto = travelAgencyController.getPassengerList(travelPackage.getId());
        System.out.println("Package Name: "+ packageDetailsDto.getPackageName());
        System.out.println("Passenger capacity: "+ packageDetailsDto.getPassengerCapacity());
        System.out.println("Number of passengers currently enrolled : "+ packageDetailsDto.getPassengersCurrentlyEnrolled());
        System.out.println("Passenger's List :");
        for(Passenger passenger: packageDetailsDto.getPassengerList()) {
            System.out.println("Name: "+passenger.getName());
            System.out.println("Passenger Number: "+passenger.getPassengerNumber());
        }
        System.out.println("__________________________________________________________________");
        /**
         * 3. Print the details of an individual passenger including their
         *     1. name,
         *     2. passenger number,
         *     3. balance (if applicable),
         *     4. list of each activity they have signed up for, including the destination the at which the activity is taking place and the price the passenger paid for the activity.
         */

        PassengerDetailsDto passengerDetailsDto = travelAgencyController.getPassengerDetails(4L);
        System.out.println("Name: "+passengerDetailsDto.getPassengerName());
        System.out.println("Passenger Number: "+ passengerDetailsDto.getPassengerNumber());
        System.out.println("Balance: Rs "+ passengerDetailsDto.getWalletBalance());
        System.out.println("list of each activity : ");
        for(Long destinationId:passengerDetailsDto.getDestinationToSignedUpActivities().keySet()) {
            List<PassengerDetailsDto.SignedUpActivityDetails> signedUpActivityDetailsList=passengerDetailsDto.getDestinationToSignedUpActivities().get(destinationId);
            System.out.println("Destination: " + destinationRepository.findById(destinationId).orElseThrow().getName());
            for(PassengerDetailsDto.SignedUpActivityDetails signedUpActivityDetail: signedUpActivityDetailsList) {
                System.out.println("Activity: "+signedUpActivityDetail.getActivityName());
                System.out.println("Cost Paid: "+signedUpActivityDetail.getCostPaidByPassenger());
            }
        }
        System.out.println("__________________________________________________________________");
        /**
         * Print the details of all the availableActivitiesDto that still have spaces available, including how many spaces are available
         * */
        AvailableActivitiesDto availableActivitiesDto = travelAgencyController.getAvailableActivities(travelPackage.getId());
        System.out.println("Print Available Activities: ");
        for(AvailableActivitiesDto.AvailableActivity availableActivity:availableActivitiesDto.getAvailableActivityList()) {
            System.out.println("Activity Name: "+ availableActivity.getActivity().getName());
            System.out.println("Space Available: "+ availableActivity.getNoOfSpacesAvailable());
        }
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
            initialize();
        };
    }
}
