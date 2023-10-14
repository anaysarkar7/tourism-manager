package com.travelpackagemanager.main.dtos;

import com.travelpackagemanager.main.models.Activity;
import lombok.Data;

import java.util.List;

@Data
public class AvailableActivitiesDto {
    private List<AvailableActivity> availableActivityList;

    @Data
    public static class AvailableActivity {
        Activity activity;
        Integer noOfSpacesAvailable;
    }
}
