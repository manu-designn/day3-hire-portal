package com.practice.recruitmentservice.dto;

public class CandidateResponse {

	private Long id;
	private String name;
	private String stage;

	public CandidateResponse() {
	}

	public CandidateResponse(Long id, String name, String stage) {
		this.id = id;
		this.name = name;
		this.stage = stage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

}
