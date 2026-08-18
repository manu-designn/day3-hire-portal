package com.practice.performanceservice.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.practice.performanceservice.dto.CandidateResponse;
import com.practice.performanceservice.exception.CandidateNotFoundException;
import com.practice.performanceservice.exception.RecruitmentServiceUnavailableException;

@Component
public class RecruitmentClient {

	@Value("${recruitment.service.url}")
	private String recruitmentServiceUrl;

	@Autowired
	private RestTemplate restTemplate;

	public CandidateResponse getCandidate(Long candidateId) {
		try {
			String url = recruitmentServiceUrl + "/api/candidates/" + candidateId;
			return restTemplate.getForObject(url, CandidateResponse.class);

		} catch (HttpClientErrorException.NotFound notFound) {
			throw new CandidateNotFoundException("Candidate not found with id " + candidateId);

		} catch (ResourceAccessException | HttpClientErrorException | HttpServerErrorException unreachable) {
			throw new RecruitmentServiceUnavailableException("Recruitment Service is currently unavailable");
		}
	}

}
