package com.travelpackagemanager.main.controllers;

import com.travelpackagemanager.main.dtos.DestinationDto;
import com.travelpackagemanager.main.exceptions.RecordNotFoundException;
import com.travelpackagemanager.main.models.Activity;
import com.travelpackagemanager.main.models.Destination;
import com.travelpackagemanager.main.services.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class DestinationController {
    @Autowired
    private DestinationService destinationService;

    public Destination updateActivitiesInDestination(Long destinationId, List<Activity> activityList) throws RecordNotFoundException {
        return destinationService.updateActivitiesInDestination(destinationId, activityList);
    }

    public Destination createDestination(DestinationDto dto) {
        return destinationService.createDestination(dto);
    }
}
