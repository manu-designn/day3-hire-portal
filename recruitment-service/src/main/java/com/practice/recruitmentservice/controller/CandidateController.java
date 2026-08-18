package com.practice.recruitmentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.recruitmentservice.dto.CandidateResponse;
import com.practice.recruitmentservice.service.CandidateService;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

	@Autowired
	private CandidateService candidateService;

	@GetMapping("/{id}")
	public ResponseEntity<CandidateResponse> getCandidate(@PathVariable Long id) {
		return ResponseEntity.ok(candidateService.getCandidate(id));
	}

}
