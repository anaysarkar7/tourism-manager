package com.travelpackagemanager.main.controllers;

import com.travelpackagemanager.main.dtos.AvailableActivitiesDto;
import com.travelpackagemanager.main.dtos.ItineraryDetailsDto;
import com.travelpackagemanager.main.dtos.PackageDetailsDto;
import com.travelpackagemanager.main.dtos.PassengerDetailsDto;
import com.travelpackagemanager.main.services.TravelAgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TravelAgencyController {

    @Autowired
    private TravelAgencyService travelAgencyService;

    public ItineraryDetailsDto getItinerary(Long packageId) {
        return travelAgencyService.getItinerary(packageId);
    }
    public PackageDetailsDto getPassengerList(Long packageId) {
        return travelAgencyService.getPackageDetails(packageId);
    }
    public PassengerDetailsDto getPassengerDetails(Long passengerId) {
        return travelAgencyService.getPassengerDetails(passengerId);
    }
    public AvailableActivitiesDto getAvailableActivities(Long packageId) {
        return travelAgencyService.getAvailableActivities(packageId);
    }
}
