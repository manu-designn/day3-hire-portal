package com.practice.gatewayservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.gatewayservice.service.RoutingService;

@RestController
@RequestMapping("/api")
public class GatewayController {

	@Autowired
	private RoutingService routingService;

	@GetMapping("/candidates/{id}")
	public ResponseEntity<Object> routeToCandidates(@PathVariable Long id) {
		return ResponseEntity.ok(routingService.getCandidate(id));
	}

	@PostMapping("/reviews/submit")
	public ResponseEntity<Object> routeToReviews(@RequestBody Object body) {
		return ResponseEntity.ok(routingService.submitReview(body));
	}

}
