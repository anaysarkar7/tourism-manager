package com.travelpackagemanager.main.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "destinations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "destination", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Activity> activityList;

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                // Include other relevant properties here
                '}';
    }
}