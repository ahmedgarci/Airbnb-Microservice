package com.AirbnbClone.PropertyService.Comment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<PropertyComment,Integer> {
    
}
