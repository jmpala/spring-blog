package dev.jmpalazzolo.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {

    @GetMapping("/")
    String indexPage() {
        return "/index";
    }
}