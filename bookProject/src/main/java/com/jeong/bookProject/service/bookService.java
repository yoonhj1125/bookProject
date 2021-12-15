package com.jeong.bookProject.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jeong.bookProject.model.User;
import com.jeong.bookProject.utils.MyUtils;
@Service
public class bookService {
		private static final String API_REST_API_KEY = "65300290cbc0f393502528027e912c84";
		private static final String API_BOOK_URL = "https://dapi.kakao.com/v3/search/book";

		public static Map<String, Object> searchBooks(String searchWord, String target, String category, int page) {
			//
			final String URL = API_BOOK_URL + "?target=" + target + "&target=" + target + "&category=" + category + "&page="
					+ page;
			Map<String, String> headers = new HashMap<>();
			headers.put("Authorization", "KakaoAK " + API_REST_API_KEY);
			Map<String, String> params = new HashMap<>();
			params.put("query", searchWord);
			String jsonString = null;
			Map<String, Object> resultData = null;
			try {
				jsonString = MyUtils.getHttpPOST2String(URL, headers, params, false);
				ObjectMapper mapper = new ObjectMapper();
				resultData = mapper.readValue(jsonString, new TypeReference<Map<String, Object>>() {
				});

				// resultData = JsonUtils.readJsonToStringObjectUnparse(jsonString);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return resultData;
	}
	
}
