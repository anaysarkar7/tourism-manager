package com.travelpackagemanager.main.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "travel_packages")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TravelPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double cost;
    private Integer capacity;
    private Date startDate;
    private Integer enrolledPassengersCount;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "travel_package_destinations",
            joinColumns = @JoinColumn(name = "travel_package_id"),
            inverseJoinColumns = @JoinColumn(name = "destination_id")
    )
    private List<Destination> itineraryList;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "travel_package_passengers",
            joinColumns = @JoinColumn(name = "travel_package_id"),
            inverseJoinColumns = @JoinColumn(name = "passenger_id")
    )
    private List<Passenger> passengerList;

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                // Include other relevant properties here
                '}';
    }
}