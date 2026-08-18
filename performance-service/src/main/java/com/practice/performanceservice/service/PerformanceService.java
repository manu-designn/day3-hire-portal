package com.practice.performanceservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.performanceservice.client.RecruitmentClient;
import com.practice.performanceservice.model.CandidateResponse;
import com.practice.performanceservice.model.ReviewRequest;
import com.practice.performanceservice.model.ReviewResponse;

@Service
public class PerformanceService {

	@Autowired
	private RecruitmentClient recruitmentClient;

	public ReviewResponse submitReview(ReviewRequest request) {
		CandidateResponse candidate = recruitmentClient.getCandidate(request.getCandidateId());

		if (!"HIRED".equals(candidate.getStage())) {
			return new ReviewResponse("REJECTED", candidate.getName() + " is not a confirmed hire yet");
		}

		return new ReviewResponse("SUCCESS", "Review recorded for " + candidate.getName() + " with rating " + request.getRating());
	}

}
