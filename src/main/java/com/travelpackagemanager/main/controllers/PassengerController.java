package com.travelpackagemanager.main.controllers;

import com.travelpackagemanager.main.dtos.PassengerDto;
import com.travelpackagemanager.main.exceptions.RecordNotFoundException;
import com.travelpackagemanager.main.models.Activity;
import com.travelpackagemanager.main.models.Destination;
import com.travelpackagemanager.main.models.Passenger;
import com.travelpackagemanager.main.models.TravelPackage;
import com.travelpackagemanager.main.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PassengerController {
    private final PassengerService passengerService;

    @Autowired
    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    public Passenger createPassenger(PassengerDto passengerReqDto) {
        return passengerService.createPassenger(passengerReqDto);
    }

    public Passenger updateActivityList(Long passengerId, List<Activity> activityList) {
        return passengerService.updateActivityByPassenger(passengerId, activityList);
    }
}