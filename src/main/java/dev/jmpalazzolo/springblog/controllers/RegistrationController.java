package dev.jmpalazzolo.springblog.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dev.jmpalazzolo.springblog.models.User;
import dev.jmpalazzolo.springblog.services.UserService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RegistrationController {

	private final UserService userService;
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("user", new User());
		return "/registration";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String createNewUser(@Valid User user,
								BindingResult bindingResult,
								Model model) {
		
		if(userService.findByEmail(user.getEmail()).isPresent()) {
			bindingResult.rejectValue("email", "error.user", "User with same email already registered");
		}
		if(userService.findByEmail(user.getUsername()).isPresent()) {
			bindingResult.rejectValue("usernname", "error.user", "User with same name already registered");
		}
		if(!bindingResult.hasErrors()) {
			userService.save(user);
			model.addAttribute("successMessage", "User has been registered successfully");
			model.addAttribute("user", new User());
		}
		
		return "/registration";
	}
}
