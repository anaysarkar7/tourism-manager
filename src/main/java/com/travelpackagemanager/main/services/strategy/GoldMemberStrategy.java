package com.travelpackagemanager.main.services.strategy;

import org.springframework.stereotype.Service;

@Service
public class GoldMemberStrategy implements MemberStrategy{

    @Override
    public Double getDiscount(Double activityCost) {
        return calculateDiscount(10, activityCost);
    }
}
