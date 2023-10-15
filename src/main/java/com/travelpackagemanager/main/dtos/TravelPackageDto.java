package com.travelpackagemanager.main.dtos;

import com.travelpackagemanager.main.models.Destination;
import com.travelpackagemanager.main.models.Passenger;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TravelPackageDto {
    private String name;
    private Double cost;
    private Integer capacity;
    private Date startDate;
    private Integer enrolledPassengersCount;
    private List<Destination> itineraryList;
    private List<Passenger> passengerList;
}
