package com.practice.performanceservice.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.practice.performanceservice.model.CandidateResponse;

@Component
public class RecruitmentClient {

	@Value("${recruitment.service.url}")
	private String recruitmentServiceUrl;

	@Autowired
	private RestTemplate restTemplate;

	public CandidateResponse getCandidate(Long candidateId) {
		String url = recruitmentServiceUrl + "/api/candidates/" + candidateId;
		return restTemplate.getForObject(url, CandidateResponse.class);
	}

}
