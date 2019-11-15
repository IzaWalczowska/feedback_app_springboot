package pl.coderslab.spring_boot_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.spring_boot_project.model.Image;
import pl.coderslab.spring_boot_project.model.Request;

import java.util.ArrayList;
import java.util.List;


@Controller
public class ReviewController {

    @GetMapping("/review")
    public String createReview(Model model) {

        return "review";
    }

    @PostMapping("/review")
    public String createReview(@RequestParam List<String> request) {
        List<String>  list = request;
        return "redirect:/review";
    }
}
