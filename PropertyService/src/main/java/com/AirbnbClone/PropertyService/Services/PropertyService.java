package com.AirbnbClone.PropertyService.Services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.AirbnbClone.PropertyService.Property.Property;
import com.AirbnbClone.PropertyService.Property.PropertyMapper;
import com.AirbnbClone.PropertyService.Property.PropertyRepository;
import com.AirbnbClone.PropertyService.Property.PropertyState;
import com.AirbnbClone.PropertyService.Requests.CreatePropertyRequest;
import com.AirbnbClone.PropertyService.Responses.PageResponse;
import com.AirbnbClone.PropertyService.Responses.PropertyResponse;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PropertyService {
    private final PropertyRepository propertyRepository;
    private final PropertyMapper propertyMapper;

    public Integer createNewProperty(CreatePropertyRequest request){
        // to check user Id
        Property property = propertyMapper.toProperty(request);
        property.setHostId(1);
        property.setPropertyState(PropertyState.AVAILABLE);
        propertyRepository.save(property);
        return property.getId();
    }


    public PageResponse<PropertyResponse> findAllProperties(Integer page, Integer size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Property> propertyPage = propertyRepository.findAll(pageable);
        Page<PropertyResponse> propertyResponsePage = propertyPage.map((element)->(propertyMapper.toPropertyResponse(element))); 
        return new PageResponse<>(
            propertyResponsePage.getContent(),
            propertyResponsePage.getSize(),
            propertyResponsePage.getTotalElements(),
            propertyResponsePage.getNumber(),
            propertyResponsePage.isFirst(),
            propertyResponsePage.isLast()
        );
    }



    

}
