package com.travelpackagemanager.main.dtos;

import com.travelpackagemanager.main.models.Activity;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ItineraryDetailsDto {
    private String travelPackageName;
    private Map<String, List<Activity>> destinationToActivitiesMap;
}
