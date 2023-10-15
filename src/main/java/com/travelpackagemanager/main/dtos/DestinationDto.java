package com.travelpackagemanager.main.dtos;

import com.travelpackagemanager.main.models.Activity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class DestinationDto {
    private String name;
    private List<Activity> activityList;
}
