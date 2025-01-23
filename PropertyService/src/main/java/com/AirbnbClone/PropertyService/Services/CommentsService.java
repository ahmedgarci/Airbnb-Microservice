package com.AirbnbClone.PropertyService.Services;

import org.springframework.stereotype.Service;

import com.AirbnbClone.PropertyService.Comment.CommentRepository;
import com.AirbnbClone.PropertyService.Comment.PropertyComment;
import com.AirbnbClone.PropertyService.Property.Property;
import com.AirbnbClone.PropertyService.Property.PropertyRepository;
import com.AirbnbClone.PropertyService.Requests.CreateCommentRequest;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentsService {

    private final CommentRepository commentRepository;
    private final PropertyRepository propertyRepository;

    public Integer createPropertyComment(@NotNull Integer propertyId,CreateCommentRequest request ,@NotNull Integer userId){
        // CHECKn!  IF USER EXISTS

       Property property =  propertyRepository.findById(propertyId).orElseThrow(()->new EntityNotFoundException("entity was not found"));
       PropertyComment comment = PropertyComment.builder().commentatorId(userId).comment(request.getComment()).property(property).build();
       commentRepository.save(comment);
       property.getComments().add(comment);
        propertyRepository.save(property);
        return comment.getId();    
    }


}
