package com.travelpackagemanager.main.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TravelPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long packageId;
    private String name;
    private Float cost;
    private Integer capacity;
    private Date startDate;
    private Integer enrolledPassengersCount;
    @OneToMany
    private List<Destination> itineraryList;
    @OneToMany
    private List<Passenger> passengerList;
}
