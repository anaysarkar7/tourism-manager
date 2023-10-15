package com.travelpackagemanager.main.controllers;

import com.travelpackagemanager.main.dtos.TravelPackageDto;
import com.travelpackagemanager.main.models.TravelPackage;
import com.travelpackagemanager.main.services.TravelPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TravelPackageController {
    @Autowired
    private TravelPackageService travelPackageService;

    public TravelPackage createTravelPackage(TravelPackageDto dto) {
        return travelPackageService.createTravelPackage(dto);
    }
}
