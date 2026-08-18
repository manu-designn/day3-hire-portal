package com.practice.recruitmentservice.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.recruitmentservice.model.Candidate;
import com.practice.recruitmentservice.model.CandidateResponse;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

	private final Map<Long, Candidate> candidates = new HashMap<>();

	public CandidateController() {
		candidates.put(4001L, new Candidate(4001L, "Karthik Rao", "HIRED", "Strong technical round"));
		candidates.put(4002L, new Candidate(4002L, "Divya Menon", "INTERVIEWING", "Awaiting HR round"));
		candidates.put(4003L, new Candidate(4003L, "Sameer Khan", "REJECTED", "Did not meet bar in round 2"));
	}

	@GetMapping("/{id}")
	public ResponseEntity<CandidateResponse> getCandidate(@PathVariable Long id) {
		Candidate candidate = candidates.get(id);

		if (candidate == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		CandidateResponse response = new CandidateResponse(candidate.getId(), candidate.getName(), candidate.getStage());
		return ResponseEntity.ok(response);
	}

}
