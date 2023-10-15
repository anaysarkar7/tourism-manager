package com.travelpackagemanager.main.models;

import com.travelpackagemanager.main.enums.PassengerType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "passengers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Passenger {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String name;
   private Integer passengerNumber;
   private String passengerType;
   private Double walletBalance;
   @ManyToMany(fetch = FetchType.EAGER)
   @JoinTable(
           name = "passenger_activities",
           joinColumns = @JoinColumn(name = "passenger_id"),
           inverseJoinColumns = @JoinColumn(name = "activity_id")
   )
   private List<Activity> activityList;

   @Override
   public String toString() {
      return "id=" + id +
              ", name='" + name + '\'' +
              // Include other relevant properties here
              '}';
   }
}