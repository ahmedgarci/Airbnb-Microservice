package com.AirbnbClone.PropertyService.Facility;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface FacilityRepository extends JpaRepository<Facility,Integer> {
    Optional<Facility> findByName(String name);

    @Query("""
            SELECT f.name FROM Facility f 
            """)
    Set<String> getAllFacilityNames();
}
