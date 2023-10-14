package com.travelpackagemanager.main.repositories;

import com.travelpackagemanager.main.models.TravelPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TravelPackageRepository extends JpaRepository<TravelPackage, Long > {
    Optional<TravelPackage> findById(Long packageId);
}
