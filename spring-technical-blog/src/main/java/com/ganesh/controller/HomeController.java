package com.ganesh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ganesh.model.Post;
import com.ganesh.service.PostService;


@Controller
public class HomeController {

	@Autowired
	private PostService service;

	@RequestMapping("/")
	public String getAllPosts(Model model) {

		List<Post> posts = service.getAllPosts();

		model.addAttribute("posts", posts);

		return "index";

	}

}
