package com.travelpackagemanager.main.services;

import com.travelpackagemanager.main.dtos.DestinationDto;
import com.travelpackagemanager.main.models.Activity;
import com.travelpackagemanager.main.models.Destination;
import com.travelpackagemanager.main.repositories.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationService {
    @Autowired
    private DestinationRepository destinationRepository;

    public Destination createDestination(DestinationDto destinationDto) {
        return this.destinationRepository.save(this.getDestinationFrom(destinationDto));
    }

    public List<Destination> createDestinations(List<DestinationDto>  destinationDtoList) {
        List<Destination> destinationList = destinationDtoList.stream().map(this::getDestinationFrom).toList();
        return this.destinationRepository.saveAll(this.destinationRepository.saveAll(destinationList));
    }

    public Destination updateActivitiesInDestination(Long destinationId, List<Activity> activityList) {
        Destination destination = destinationRepository.findById(destinationId).orElseThrow();
        destination.setActivityList(activityList);
        return destinationRepository.save(destination);
    }

    private Destination getDestinationFrom(DestinationDto destinationDto) {
        Destination destination = new Destination();
        destination.setName(destinationDto.getName());
        destination.setActivityList(destinationDto.getActivityList());
        return destination;
    }
}
