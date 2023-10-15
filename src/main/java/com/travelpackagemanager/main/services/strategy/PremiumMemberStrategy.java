package com.travelpackagemanager.main.services.strategy;

import org.springframework.stereotype.Service;

@Service
public class PremiumMemberStrategy implements MemberStrategy{
    @Override
    public Double getDiscount(Double activityCost) {
        return calculateDiscount(100, activityCost);
    }
}
