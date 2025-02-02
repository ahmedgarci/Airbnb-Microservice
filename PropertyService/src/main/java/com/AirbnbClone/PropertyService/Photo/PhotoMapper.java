package com.AirbnbClone.PropertyService.Photo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.AirbnbClone.PropertyService.Responses.uploadedPhotoResponse;

@Component
public class PhotoMapper {

    public List<uploadedPhotoResponse> toPhotoResponse(List<PropertyPhoto> savedPhotos){
        return savedPhotos.stream().map(savedFile->new uploadedPhotoResponse(savedFile.getId(),savedFile.getUrl())).collect(Collectors.toList());        

    }

}
