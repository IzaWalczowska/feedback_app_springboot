package pl.coderslab.spring_boot_project.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;

@Component

public class FileService {

//    public String saveFile(MultipartFile file) throws IOException {
//        String fileName = LocalDateTime.now() + "&" + file.getOriginalFilename();
//        file.transferTo(new File(fileName));
//        return fileName;
//    }

}
