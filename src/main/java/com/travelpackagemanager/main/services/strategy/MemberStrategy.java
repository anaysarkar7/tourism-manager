package com.travelpackagemanager.main.services.strategy;

public interface MemberStrategy {
    default Double calculateDiscount(int discountPercentage, Double activityCost) {
        return activityCost - ((discountPercentage / 100.0) * activityCost);
    }
    Double getDiscount(Double activityCost);
}
