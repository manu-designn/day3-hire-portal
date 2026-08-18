package com.practice.recruitmentservice.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.practice.recruitmentservice.domain.Candidate;

@Repository
public class CandidateRepository {

	private final Map<Long, Candidate> candidates = new HashMap<>();

	public CandidateRepository() {
		candidates.put(4001L, new Candidate(4001L, "Karthik Rao", "HIRED", "Strong technical round"));
		candidates.put(4002L, new Candidate(4002L, "Divya Menon", "INTERVIEWING", "Awaiting HR round"));
		candidates.put(4003L, new Candidate(4003L, "Sameer Khan", "REJECTED", "Did not meet bar in round 2"));
	}

	public Candidate findById(Long id) {
		return candidates.get(id);
	}

}
