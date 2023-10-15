package com.travelpackagemanager.main.dtos;

import lombok.*;

import java.util.List;
import java.util.Map;

@Data
public class PassengerDetailsDto {
    private String passengerName;
    private Integer passengerNumber;
    private Double walletBalance;
    private Map<Long, List<SignedUpActivityDetails>> destinationToSignedUpActivities;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SignedUpActivityDetails{
        private String activityName;
        private Double costPaidByPassenger;
    }
}
