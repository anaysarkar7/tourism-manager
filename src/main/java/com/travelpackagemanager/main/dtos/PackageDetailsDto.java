package com.travelpackagemanager.main.dtos;

import com.travelpackagemanager.main.models.Passenger;
import lombok.Data;

import java.util.List;

@Data
public class PackageDetailsDto {
    private String packageName;
    private int passengerCapacity;
    private int passengersCurrentlyEnrolled;
    private List<Passenger> passengerList;
}
