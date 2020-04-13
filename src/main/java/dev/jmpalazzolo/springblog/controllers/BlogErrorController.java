package dev.jmpalazzolo.springblog.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogErrorController implements ErrorController{

	private static final String PATH = "/error";
	
	@RequestMapping(PATH)
	public String error() {
		return "/error";
	}
	
	@GetMapping("/403")
    public String error403() {
        return "/403";
    }

	@Override
	public String getErrorPath() {
		return PATH;
	}
	
}
