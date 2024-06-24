package com.pocket.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Batch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long batchID;

	private String title;
	private String createdOn;
	private String duration;
	private String description;

	@OneToMany(mappedBy = "batch", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Intern> interns;

	public Batch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Batch(Long batchID, String title, String createdOn, String duration, String description,
			List<Intern> interns) {
		super();
		this.batchID = batchID;
		this.title = title;
		this.createdOn = createdOn;
		this.duration = duration;
		this.description = description;
		this.interns = interns;
	}

	public Batch(String title, String createdOn, String duration, String description, List<Intern> interns) {
		super();
		this.title = title;
		this.createdOn = createdOn;
		this.duration = duration;
		this.description = description;
		this.interns = interns;
	}

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

	public List<Intern> getInterns() {
		return interns;
	}

	public void setInterns(List<Intern> interns) {
		this.interns = interns;
	}

	@Override
	public String toString() {
		return "Batch [batchID=" + batchID + ", title=" + title + ", createdOn=" + createdOn + ", duration=" + duration
				+ ", description=" + description + ", interns=" + interns + "]";
	}

}
