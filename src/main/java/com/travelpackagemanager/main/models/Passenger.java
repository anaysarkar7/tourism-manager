package com.travelpackagemanager.main.models;

import com.travelpackagemanager.main.enums.PassengerType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Passenger {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long passengerId;
   private String name;
   private Integer passengerNumber;
   @Enumerated
   private PassengerType passengerType;
   private Float walletBalance;
   @ManyToMany
   private List<Activity> activityList;
}
