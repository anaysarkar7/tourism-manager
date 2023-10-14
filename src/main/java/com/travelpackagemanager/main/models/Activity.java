package com.travelpackagemanager.main.models;

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
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long activityId;
    @OneToOne
    private Destination destination;
    private String name;
    private String description;
    private Float cost;
    private Integer capacity;
    private Integer enrolledPassengersCount;
    @ManyToMany
    private List<Passenger> enrolledPassengersList;
}
