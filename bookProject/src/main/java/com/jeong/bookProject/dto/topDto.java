package com.jeong.bookProject.dto;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
public interface topDto {

    Integer getCNT();

    String getsearch_word();

}
