package com.practice.performanceservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.performanceservice.model.ReviewRequest;
import com.practice.performanceservice.model.ReviewResponse;
import com.practice.performanceservice.service.PerformanceService;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

	@Autowired
	private PerformanceService performanceService;

	@PostMapping("/submit")
	public ResponseEntity<ReviewResponse> submit(@RequestBody ReviewRequest request) {
		return ResponseEntity.ok(performanceService.submitReview(request));
	}

}
