package com.AirbnbClone.PropertyService.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.AirbnbClone.PropertyService.Requests.CreateCommentRequest;
import com.AirbnbClone.PropertyService.Services.CommentsService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequiredArgsConstructor
@RequestMapping("/comments/")
public class CommentController {
    
    private final CommentsService commentsService;

    @PostMapping("create/{propertyId}/{userId}")
    public ResponseEntity<Integer> postPropertyComment(@PathVariable Integer propertyId,@PathVariable Integer userId, @RequestBody @Valid CreateCommentRequest request ) {
        return ResponseEntity.ok(commentsService.createPropertyComment(propertyId, request, userId));      
    }
    


}
