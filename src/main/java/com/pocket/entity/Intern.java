package com.pocket.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Intern {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String college;

	private String email;

	private String city;

	@Column(length = 11, unique = true)
	private String contact;

	private String type;

	private String remark;

	@ManyToOne
	@JoinColumn(name = "batch_id")
	private Batch batch;

	public Intern() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Intern(Long id, String name, String college, String email, String city, String contact, String type,
			String remark, Batch batch) {
		super();
		this.id = id;
		this.name = name;
		this.college = college;
		this.email = email;
		this.city = city;
		this.contact = contact;
		this.type = type;
		this.remark = remark;
		this.batch = batch;
	}

	public Intern(String name, String college, String email, String city, String contact, String type, String remark,
			Batch batch) {
		super();
		this.name = name;
		this.college = college;
		this.email = email;
		this.city = city;
		this.contact = contact;
		this.type = type;
		this.remark = remark;
		this.batch = batch;
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

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	@Override
	public String toString() {
		return "Intern [id=" + id + ", name=" + name + ", college=" + college + ", email=" + email + ", city=" + city
				+ ", contact=" + contact + ", type=" + type + ", remark=" + remark + ", batch=" + batch + "]";
	}

}
