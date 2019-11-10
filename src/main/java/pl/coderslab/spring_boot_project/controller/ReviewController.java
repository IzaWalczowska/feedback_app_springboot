package pl.coderslab.spring_boot_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ReviewController {

    @GetMapping("/review")
    public String createReview() {

        return "review";
    }
}
