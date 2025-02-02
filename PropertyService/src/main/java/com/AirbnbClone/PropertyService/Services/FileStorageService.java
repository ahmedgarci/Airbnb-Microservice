package com.AirbnbClone.PropertyService.Services;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FileStorageService {

    private final String fileUploadPath = "./uploads";

    public List<String> SaveFiles(List<MultipartFile> files){
        List<String> savedFilePaths = new ArrayList<>();
        for (MultipartFile file : files) {
            String filePath = UploadFile(file, fileUploadPath);
            if (filePath != null) {
                savedFilePaths.add(filePath);
            }
        }
        return savedFilePaths;
    }

    private String UploadFile(MultipartFile file, String SubPath) {
        File targetFolder = new File(fileUploadPath);
        if (!targetFolder.exists()) {
            boolean folderCreated = targetFolder.mkdirs(); 
            if (!folderCreated) {
                log.warn("Failed to create folder: {}", fileUploadPath);
                return null;
            } else {
                log.info("Folder created: {}", fileUploadPath);
            }
        }
        String fileExtension = ExtractFileExtension(file.getOriginalFilename());
        String targetFilePath = fileUploadPath + File.separator + System.currentTimeMillis() + "." + fileExtension;
        Path targetPath = Paths.get(targetFilePath);
        try {
            Files.write(targetPath, file.getBytes());
            log.info("File saved: {}", targetFilePath);
            return targetFilePath;
        } catch (Exception e) {
            log.error("Error while uploading the file: {}", file.getOriginalFilename(), e);
            return null;
        }
    }
    

    private String ExtractFileExtension(String OriginalFileName) {
        if (OriginalFileName == null || OriginalFileName.isEmpty()) {
            return "";
        }
        int lastDotIndex = OriginalFileName.lastIndexOf(".");
        if (lastDotIndex == -1) {
            return "";
        }
        return OriginalFileName.substring(lastDotIndex + 1);
    }
}
