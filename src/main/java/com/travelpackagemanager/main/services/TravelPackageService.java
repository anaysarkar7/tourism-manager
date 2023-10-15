package com.travelpackagemanager.main.services;

import com.travelpackagemanager.main.dtos.TravelPackageDto;
import com.travelpackagemanager.main.models.TravelPackage;
import com.travelpackagemanager.main.repositories.TravelPackageRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TravelPackageService {
    @Autowired
    private TravelPackageRepository travelPackageRepository;

    @Transactional
    public TravelPackage createTravelPackage(TravelPackageDto travelPackageDto) {
        TravelPackage travelPackage = new TravelPackage();

        travelPackage.setCapacity(travelPackageDto.getCapacity());
        travelPackage.setCost(travelPackage.getCost());
        travelPackage.setPassengerList(travelPackageDto.getPassengerList());
        travelPackage.setItineraryList(travelPackageDto.getItineraryList());
        travelPackage.setName(travelPackageDto.getName());
        travelPackage.setStartDate(travelPackageDto.getStartDate());
        travelPackage.setEnrolledPassengersCount(travelPackageDto.getEnrolledPassengersCount());

        travelPackageRepository.save(travelPackage);
        return travelPackage;
    }
}
