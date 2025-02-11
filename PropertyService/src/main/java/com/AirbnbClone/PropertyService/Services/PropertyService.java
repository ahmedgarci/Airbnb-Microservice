package com.AirbnbClone.PropertyService.Services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.AirbnbClone.PropertyService.Exceptions.customUnauthorizedAccessException;
import com.AirbnbClone.PropertyService.Exceptions.customEntityNotFoundException;
import com.AirbnbClone.PropertyService.Facility.Facility;
import com.AirbnbClone.PropertyService.Facility.FacilityRepository;
import com.AirbnbClone.PropertyService.Photo.PhotoMapper;
import com.AirbnbClone.PropertyService.Photo.PropertyPhoto;
import com.AirbnbClone.PropertyService.Photo.PropertyPhotoRepository;
import com.AirbnbClone.PropertyService.Property.Property;
import com.AirbnbClone.PropertyService.Property.PropertyMapper;
import com.AirbnbClone.PropertyService.Property.PropertyRepository;
import com.AirbnbClone.PropertyService.Requests.CreatePropertyRequest;
import com.AirbnbClone.PropertyService.Responses.PageResponse;
import com.AirbnbClone.PropertyService.Responses.PropertyCardResponse;
import com.AirbnbClone.PropertyService.Responses.PropertyResponse;
import com.AirbnbClone.PropertyService.Responses.uploadedPhotoResponse;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PropertyService {
    private final PropertyRepository propertyRepository;
    private final PropertyMapper propertyMapper;
    private final FacilityRepository facilityRepository;
    private final FileStorageService fileStorageService;
    private final PropertyPhotoRepository photoRepository;
    private final PhotoMapper photoMapper;

    public Integer createNewProperty(CreatePropertyRequest request) {
        Property property = propertyMapper.toProperty(request);
        property.setHostId(1);
        property.setFacilities(CreateAndSaveFacilitiesIfNotExists(request.getFacilities()));
        List<PropertyPhoto> savedPhotos = photoRepository.findAllById(request.getPhotosIds());
        savedPhotos.forEach(photo -> photo.setProperty(property));
        property.setPhotos(savedPhotos);
        propertyRepository.save(property);
        return property.getId();
    }
    

    
    public List<uploadedPhotoResponse> saveUploadedPhotos(List<MultipartFile> files){
        List<String> savedFiles = fileStorageService.SaveFiles(files);
        List<PropertyPhoto> photos = savedFiles.stream().map((file)->{
                PropertyPhoto photo = PropertyPhoto.builder().url(file).build();
                photoRepository.save(photo);
                return photo;
            }).collect(Collectors.toList());
        return photoMapper.toPhotoResponse(photos);
        


    }



    public PageResponse<PropertyCardResponse> findAllProperties(Integer page, Integer size){
        Pageable pageable = PageRequest.of(page, size,Sort.by("CreationDateTime"));
        Page<Property> propertyPage = propertyRepository.findAll(pageable);
        Page<PropertyCardResponse> propertyCardResponsePage = propertyPage.map((element)->new PropertyCardResponse(element.getId(),element.getCity(),element.getCountry(),element.getPricePerNight())); 
        return new PageResponse<>(
            propertyCardResponsePage.getContent(),
            propertyCardResponsePage.getSize(),
            propertyCardResponsePage.getTotalElements(),
            propertyCardResponsePage.getNumber(),
            propertyCardResponsePage.isFirst(),
            propertyCardResponsePage.isLast()
        );
    }


    public PropertyResponse getPropertyById(@NotNull Integer propertyId){
        Property property = propertyRepository.getPropertyWithFacilitiesAndComments(propertyId).orElseThrow(()->new customEntityNotFoundException("property was not found "));
        System.out.println("irls : " +property.getPhotos());       
         return propertyMapper.toPropertyResponse(property);
    }

    public void deletePropertyByHostId(@NotNull Integer propertyId,@NotNull Integer userId){
        // CHECK USER ID
        Property property = propertyRepository.findById(propertyId).orElseThrow(()->new customEntityNotFoundException("property with Id : "+propertyId+" is not found"));
        if(!property.getHostId().equals(userId)){
            throw new customUnauthorizedAccessException("property do not belong to that user !");
        }
        propertyRepository.delete(property);
    }

    public boolean checkIfPropertyExists(Integer propertyId){
        return propertyRepository.findById(propertyId).isPresent();
    }

    
    private Set<Facility> CreateAndSaveFacilitiesIfNotExists(Set<String> FacilitiesSelectedByUser){
        Set<Facility> facilities = new HashSet<>();
        for (String facilityName : FacilitiesSelectedByUser) {
            Facility f = facilityRepository.findByName(facilityName)
                .orElseGet(() -> {
                    Facility newFacility = Facility.builder().name(facilityName).build();
                    facilityRepository.save(newFacility);
                    return newFacility;
                });
            facilities.add(f); 
        }
        return facilities;   
    }








    

}
