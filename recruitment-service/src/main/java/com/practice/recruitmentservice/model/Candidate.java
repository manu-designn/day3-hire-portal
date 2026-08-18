package com.practice.recruitmentservice.model;

public class Candidate {

	private Long id;
	private String name;
	private String stage;
	private String recruiterNotes;

	public Candidate(Long id, String name, String stage, String recruiterNotes) {
		this.id = id;
		this.name = name;
		this.stage = stage;
		this.recruiterNotes = recruiterNotes;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getStage() {
		return stage;
	}

	public String getRecruiterNotes() {
		return recruiterNotes;
	}

}
