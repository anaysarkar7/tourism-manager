package com.travelpackagemanager.main.services;


import com.travelpackagemanager.main.enums.PassengerType;
import com.travelpackagemanager.main.services.strategy.GoldMemberStrategy;
import com.travelpackagemanager.main.services.strategy.MemberStrategy;
import com.travelpackagemanager.main.services.strategy.PremiumMemberStrategy;
import com.travelpackagemanager.main.services.strategy.StandardMemberStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerTypeFactory {
    @Autowired
    private GoldMemberStrategy goldMemberStrategy;

    @Autowired
    private StandardMemberStrategy standardMemberStrategy;

    @Autowired
    private PremiumMemberStrategy premiumMemberStrategy;

    public MemberStrategy getMemberTypeStrategy(String passengerType) {
        if (passengerType.equals(PassengerType.GOLD.name())) {
            return goldMemberStrategy;
        }
        else if (passengerType.equals(PassengerType.STANDARD.name())) {
            return standardMemberStrategy;
        }
        else if (passengerType.equals(PassengerType.PREMIUM.name())) {
            return premiumMemberStrategy;
        }
        return null;
    }

}
