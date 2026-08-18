package com.practice.gatewayservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GatewayController {

	@Value("${recruitment.service.url}")
	private String recruitmentServiceUrl;

	@Value("${performance.service.url}")
	private String performanceServiceUrl;

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/api/candidates/{id}")
	public ResponseEntity<Object> routeToCandidates(@PathVariable Long id) {
		String url = recruitmentServiceUrl + "/api/candidates/" + id;
		return restTemplate.exchange(url, HttpMethod.GET, null, Object.class);
	}

	@RequestMapping(value = "/api/reviews/submit", method = org.springframework.web.bind.annotation.RequestMethod.POST)
	public ResponseEntity<Object> routeToReviews(@RequestBody Object body) {
		String url = performanceServiceUrl + "/api/reviews/submit";
		return restTemplate.postForEntity(url, body, Object.class);
	}

}
