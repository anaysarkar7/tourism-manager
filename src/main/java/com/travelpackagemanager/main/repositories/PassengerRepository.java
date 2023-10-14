package com.travelpackagemanager.main.repositories;

import com.travelpackagemanager.main.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    Optional<Passenger> findById(Long passengerId);
}
