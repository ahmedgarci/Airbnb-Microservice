package com.AirbnbClone.PropertyService.Property;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface PropertyRepository extends JpaRepository<Property,Integer> {
      
    @Query("""
        SELECT p FROM Property p
        LEFT JOIN FETCH p.facilities 
        Left Join FETCH p.photos
        WHERE p.id = :id
        """)
    Optional<Property> getPropertyWithFacilitiesAndComments(@Param("id") Integer id);


}
