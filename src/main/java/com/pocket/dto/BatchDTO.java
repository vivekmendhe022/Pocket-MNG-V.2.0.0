package com.pocket.dto;

public class BatchDTO {

	private Long batchID;
	private String title;
	private String createdOn;
	private String duration;
	private String description;

	public Long getBatchID() {
		return batchID;
	}

	public void setBatchID(Long batchID) {
		this.batchID = batchID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
