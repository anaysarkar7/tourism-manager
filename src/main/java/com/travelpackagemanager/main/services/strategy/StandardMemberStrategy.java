package com.travelpackagemanager.main.services.strategy;

import org.springframework.stereotype.Service;

@Service
public class StandardMemberStrategy implements MemberStrategy{
    @Override
    public Double getDiscount(Double activityCost) {
        return calculateDiscount(0, activityCost);
    }
}
