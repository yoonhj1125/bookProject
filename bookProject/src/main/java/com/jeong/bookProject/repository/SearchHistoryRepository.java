package com.jeong.bookProject.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jeong.bookProject.dto.topDto;
import com.jeong.bookProject.model.SearchHistory;
import com.jeong.bookProject.model.User;
@Repository
public interface SearchHistoryRepository extends JpaRepository<SearchHistory, Long> {
	
	@Query("SELECT s FROM SearchHistory s WHERE s.user=?1")
	Page<SearchHistory> findByMember(User user, Pageable pageable);
	
	@Query(value = "SELECT ROWNUM AS RANK, A.* FROM" +
	            "(SELECT COUNT(search_word) AS CNT, search_word\n" +
	            "FROM search_history\n" +
	            "GROUP BY search_word\n" +
	            "ORDER BY CNT DESC , search_word ASC LIMIT 10) AS A",
	            nativeQuery=true)
	List<topDto> selectKeywordTopList();
	

	
}
