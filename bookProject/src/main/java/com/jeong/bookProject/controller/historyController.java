
package com.jeong.bookProject.controller;
import java.util.List;

import java.util.Map;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jeong.bookProject.config.auth.PrincipalDetail;
import com.jeong.bookProject.dto.topDto;
import com.jeong.bookProject.model.SearchHistory;
import com.jeong.bookProject.model.User;
import com.jeong.bookProject.repository.SearchHistoryRepository;
import com.jeong.bookProject.service.SearchHistoryService;
@Controller
public class historyController {
	@Autowired
	SearchHistoryService searchHistoryService;
	
	@GetMapping("/book/searchHistory")
	public String searchHistory(@AuthenticationPrincipal PrincipalDetail principal, HttpServletRequest req, HttpServletResponse res, Model model,
			@PageableDefault(size = 10, page = 0, sort = "regdate", direction = Direction.DESC) Pageable pageable) {
		try {
			User user = principal.getUser();
			Page<SearchHistory> searchHistoryPage = searchHistoryService.findByMember(user, pageable);
			model.addAttribute("searchHistoryPage", searchHistoryPage);
			return "book/bookHistory";
		} catch (Exception e) {
			return "/";
		}

	}
	
	@GetMapping("/book/topSearch")
	public String topSearch(@AuthenticationPrincipal PrincipalDetail principal, HttpServletRequest req, HttpServletResponse res, Model model,
			@PageableDefault(size = 10, page = 0) Pageable pageable) {
		try {
			List<topDto> searchHistoryPage = searchHistoryService.selectKeywordTopList();
			model.addAttribute("resultData", searchHistoryPage);
			return "book/topBook";
		} catch (Exception e) {
			return "/";
		}
		
	}
	
}
