package com.AirbnbClone.PropertyService.Requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CreateCommentRequest {
    @NotBlank()
    private String comment;
}
