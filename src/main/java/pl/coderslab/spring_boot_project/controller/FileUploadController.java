package pl.coderslab.spring_boot_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pl.coderslab.spring_boot_project.model.Image;
import pl.coderslab.spring_boot_project.model.Task;
import pl.coderslab.spring_boot_project.model.User;
import pl.coderslab.spring_boot_project.service.FileService;
import pl.coderslab.spring_boot_project.service.ImageService;


import java.io.IOException;

@Controller
public class FileUploadController {



//    private final FileService fileService;
//    private final ImageService imageService;
//
//    public FileUploadController(FileService fileService, ImageService imageService) {
//        this.fileService = fileService;
//        this.imageService = imageService;
//    }
//
//
//    @GetMapping("/upload")
//    public String getSingleUploadPage() {
//        return "upload";
//    }
//
//    @PostMapping("/upload/{id}")
//    public String uploadImage(@RequestParam("uploadFile") MultipartFile file, @PathVariable Long id, Model model) throws IOException {
//        String fileName = fileService.saveFile(file);
////       todo dodac do nazwy pliku sciezke na serwerze
//        String path = "path" + fileName;
//        Image image = new Image();
//
//        return "taskHistory";
//    }


}




