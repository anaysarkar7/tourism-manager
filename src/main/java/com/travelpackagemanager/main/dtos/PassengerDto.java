package com.travelpackagemanager.main.dtos;


import com.travelpackagemanager.main.enums.PassengerType;
import com.travelpackagemanager.main.models.Activity;
import lombok.Data;

import java.util.List;

@Data
public class PassengerDto {
    private String name;
    private Integer passengerNumber;
    private PassengerType passengerType;
    private Double walletBalance;
    private List<Activity> activityList;
}
