package com.jeong.bookProject.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jeong.bookProject.dto.topDto;
import com.jeong.bookProject.model.SearchHistory;
import com.jeong.bookProject.model.User;
import com.jeong.bookProject.repository.SearchHistoryRepository;
@Service
public class SearchHistoryService {
	@Autowired
	SearchHistoryRepository seaerchHistoryRepository;

	@Transactional
	public void save(SearchHistory entity) {
		seaerchHistoryRepository.save(entity);
	}
	@Transactional
	public Page<SearchHistory> findByMember(User user, Pageable pageable) {
		return seaerchHistoryRepository.findByMember(user, pageable);
	}
	
//	@Transactional
//	public ReturnData selectKeywordTopList(User user, Pageable pageable) {
//		 List<Map<String,Object>> searchHistoryList = seaerchHistoryRepository.selectKeywordTopList();
//         return new ReturnData(searchHistoryList);
//	}
	@Transactional
	public List<topDto> selectKeywordTopList() {
		return seaerchHistoryRepository.selectKeywordTopList();
	}
	
	
	
}
