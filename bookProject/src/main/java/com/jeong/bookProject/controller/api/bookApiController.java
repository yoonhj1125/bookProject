package com.jeong.bookProject.controller.api;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jeong.bookProject.config.auth.PrincipalDetail;
import com.jeong.bookProject.dto.ResponseDto;
import com.jeong.bookProject.model.SearchHistory;
import com.jeong.bookProject.model.User;
import com.jeong.bookProject.service.SearchHistoryService;
import com.jeong.bookProject.service.bookService;

@RestController
public class bookApiController {

	@Autowired
	SearchHistoryService searchHistoryService;

	/**
	 * 책 검색 restAPI
	 * 
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping(value = "/book/searchBooks")
	public Map<String, Object>  searchBooks(@AuthenticationPrincipal PrincipalDetail principal, HttpServletRequest req, HttpServletResponse res,
			@RequestParam("searchWord") String searchWord,
			@RequestParam(name = "target", defaultValue = "all") String target,
			@RequestParam(name = "category", defaultValue = "") String category,
			@RequestParam(name = "page", defaultValue = "1") int page) {

		System.out.println(target);
		User user = principal.getUser();
		System.out.println(user+"USER");
		Map<String, Object> result = bookService.searchBooks(searchWord, target, category, page);
		searchHistoryService
		.save(new SearchHistory(null, searchWord, target, category, 0, Timestamp.valueOf(LocalDateTime.now()), user));
		System.out.println(result.toString());
		return result;
	}
}



