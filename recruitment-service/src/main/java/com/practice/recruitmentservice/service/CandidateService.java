package com.practice.recruitmentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.recruitmentservice.domain.Candidate;
import com.practice.recruitmentservice.dto.CandidateResponse;
import com.practice.recruitmentservice.exception.CandidateNotFoundException;
import com.practice.recruitmentservice.repository.CandidateRepository;

@Service
public class CandidateService {

	@Autowired
	private CandidateRepository candidateRepository;

	public CandidateResponse getCandidate(Long id) {
		Candidate candidate = candidateRepository.findById(id);

		if (candidate == null) {
			throw new CandidateNotFoundException("Candidate not found with id " + id);
		}

		return new CandidateResponse(candidate.getId(), candidate.getName(), candidate.getStage());
	}

}
