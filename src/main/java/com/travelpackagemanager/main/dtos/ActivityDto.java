package com.travelpackagemanager.main.dtos;

import com.travelpackagemanager.main.models.Destination;
import com.travelpackagemanager.main.models.Passenger;
import lombok.Data;

import java.util.List;

@Data
public class ActivityDto {
    private Destination destination;
    private String name;
    private String description;
    private Double cost;
    private Integer capacity;
    private Integer enrolledPassengersCount;
    private List<Passenger> enrolledPassengersList;
}
