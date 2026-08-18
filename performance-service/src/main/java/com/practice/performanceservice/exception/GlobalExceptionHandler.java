package com.practice.performanceservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.practice.performanceservice.dto.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CandidateNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleCandidateNotFound(CandidateNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(ex.getMessage()));
	}

	@ExceptionHandler(RecruitmentServiceUnavailableException.class)
	public ResponseEntity<ErrorResponse> handleRecruitmentUnavailable(RecruitmentServiceUnavailableException ex) {
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(new ErrorResponse(ex.getMessage()));
	}

}
