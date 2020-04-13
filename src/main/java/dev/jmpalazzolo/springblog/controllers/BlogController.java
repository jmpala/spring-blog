package dev.jmpalazzolo.springblog.controllers;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dev.jmpalazzolo.springblog.models.Post;
import dev.jmpalazzolo.springblog.models.User;
import dev.jmpalazzolo.springblog.services.PostService;
import dev.jmpalazzolo.springblog.services.UserService;
import dev.jmpalazzolo.springblog.utils.Pager;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BlogController {
	
	private final UserService userService;
	
	private final PostService postService;
	
	@RequestMapping(value = "blog/{username}", method = RequestMethod.GET)
	public String blogForUsername(@PathVariable String username,
									@RequestParam(defaultValue = "0") int page,
									Model model) {
		
		Optional<User> optionalUser = userService.findByUsername(username);
		
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			Page<Post> posts = postService.findByUserOrderedByDatePageable(user, page);
			Pager pager = new Pager(posts);
			model.addAttribute("pager", pager);
			model.addAttribute("user", user);
			return "/posts";
		} else {
			return "/error";
		}
	}
}
