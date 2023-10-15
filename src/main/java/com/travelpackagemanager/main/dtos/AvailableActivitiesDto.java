package com.travelpackagemanager.main.dtos;

import com.travelpackagemanager.main.models.Activity;
import lombok.*;

import java.util.List;

@Data
public class AvailableActivitiesDto {
    private List<AvailableActivity> availableActivityList;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AvailableActivity {
        Activity activity;
        Integer noOfSpacesAvailable;
    }
}
