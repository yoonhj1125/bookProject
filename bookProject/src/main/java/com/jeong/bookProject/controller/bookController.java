package com.jeong.bookProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class bookController {
	
	//@Autowired
	//private bookService bookService;
	

	// USER 권한이 필요
	@GetMapping("/book/searchForm")
	public String saveForm() {
		return "book/searchForm";
	}
}
