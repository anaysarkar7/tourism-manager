package com.travelpackagemanager.main.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public enum PassengerType {
    STANDARD(0), GOLD(10), PREMIUM(100);
    double discount;

    PassengerType(double discount) {
        this.discount = discount;
    }
}
