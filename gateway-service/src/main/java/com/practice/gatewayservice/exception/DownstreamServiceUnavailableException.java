package com.practice.gatewayservice.exception;

public class DownstreamServiceUnavailableException extends RuntimeException {

	public DownstreamServiceUnavailableException(String message) {
		super(message);
	}

}
