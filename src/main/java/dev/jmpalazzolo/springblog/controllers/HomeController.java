package dev.jmpalazzolo.springblog.controllers;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dev.jmpalazzolo.springblog.models.Post;
import dev.jmpalazzolo.springblog.services.PostService;
import dev.jmpalazzolo.springblog.utils.Pager;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {

	private final PostService postService;
	
	@GetMapping("/home")
	public String home(@RequestParam(defaultValue = "0") int page,
						Model model) {
		Page<Post> posts = postService.findAllOrderedByDatePageable(page);
		Pager pager = new Pager(posts);
		model.addAttribute("pager", pager);
		return "/home";
	}
}
