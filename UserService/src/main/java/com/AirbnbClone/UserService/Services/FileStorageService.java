package com.AirbnbClone.UserService.Services;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService {

    private final String uploadDirectory = "ProfilePics";

    public String SaveFile(MultipartFile file,Integer UserId){
        final String UploadPath = uploadDirectory + File.separator + UserId;
        
        return UploadFile(file,UploadPath);
    }

    private String UploadFile(MultipartFile file,String uploadPath){
        File targetFolder = new File(uploadPath);
        if(!targetFolder.exists()){
            boolean isFolderCreated = targetFolder.mkdirs();
            if(!isFolderCreated){
                System.out.println("folder was not created");
                return null;
            }
        }

        String targetFile = targetFolder+ File.separator + System.currentTimeMillis()+ "."+ extractMimeType(file.getOriginalFilename());
        Path targetPath = Paths.get(targetFile);
        try {
            Files.write(targetPath,file.getBytes());
            return targetFile;
        } catch (Exception e) {
            return null;
        }

    }

    private String extractMimeType(String fileName){
        if(fileName== null || fileName.isEmpty()){
            return "";
        }
        Integer DotIndex = fileName.lastIndexOf(".");
        if(DotIndex == -1){
            return "";
        }
        return fileName.substring(DotIndex+1).toLowerCase();
    }

    
}
