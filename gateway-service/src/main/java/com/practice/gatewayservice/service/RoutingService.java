package com.practice.gatewayservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.practice.gatewayservice.exception.DownstreamNotFoundException;
import com.practice.gatewayservice.exception.DownstreamServiceUnavailableException;

@Service
public class RoutingService {

	@Value("${recruitment.service.url}")
	private String recruitmentServiceUrl;

	@Value("${performance.service.url}")
	private String performanceServiceUrl;

	@Autowired
	private RestTemplate restTemplate;

	public Object getCandidate(Long id) {
		String url = recruitmentServiceUrl + "/api/candidates/" + id;

		try {
			return restTemplate.getForObject(url, Object.class);

		} catch (HttpClientErrorException.NotFound notFound) {
			throw new DownstreamNotFoundException("Candidate not found with id " + id);

		} catch (ResourceAccessException | HttpClientErrorException | HttpServerErrorException unreachable) {
			throw new DownstreamServiceUnavailableException("Recruitment Service is currently unavailable");
		}
	}

	public Object submitReview(Object body) {
		String url = performanceServiceUrl + "/api/reviews/submit";

		try {
			return restTemplate.postForObject(url, body, Object.class);

		} catch (ResourceAccessException | HttpClientErrorException | HttpServerErrorException unreachable) {
			throw new DownstreamServiceUnavailableException("Performance Service is currently unavailable");
		}
	}

}
