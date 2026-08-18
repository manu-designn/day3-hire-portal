package com.practice.gatewayservice.exception;

public class DownstreamNotFoundException extends RuntimeException {

	public DownstreamNotFoundException(String message) {
		super(message);
	}

}
