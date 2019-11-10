package pl.coderslab.spring_boot_project.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Value;

import pl.coderslab.spring_boot_project.exeptions.FileStorageException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;

@Service
public class StorageService {

    @Value("${upload.path}")
    private String path;

    public String uploadFile(MultipartFile file) {

        try {
            Path copyLocation = Paths
                    .get(path + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
            Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
            String path = "/resources/images/" + StringUtils.cleanPath(file.getOriginalFilename());
            return path;
        } catch (Exception e) {
            e.printStackTrace();
            throw new FileStorageException("Could not store file " + file.getOriginalFilename() + ". Please try again!");
        }

    }
}


