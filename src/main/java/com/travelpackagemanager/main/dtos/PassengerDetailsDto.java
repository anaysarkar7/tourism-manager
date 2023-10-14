package com.travelpackagemanager.main.dtos;

import lombok.*;

import java.util.List;
import java.util.Map;

@Data
public class PassengerDetailsDto {
    private String passengerName;
    private Integer passengerNumber;
    private Float walletBalance;
    private Map<String, List<SignedUpActivityDetails>> destinationToSignedUpActivities;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SignedUpActivityDetails{
        private String activityName;
        private Float costPaidByPassenger;
    }
}
