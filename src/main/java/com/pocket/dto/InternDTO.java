package com.pocket.dto;

public class InternDTO {

	private Long id;
	private String name;
	private String college;
	private String email;
	private String city;
	private String contact;
	private String type;
	private String remark;
	private Long batchID;

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

	public Long getBatchID() {
		return batchID;
	}

	public void setBatchID(Long batchID) {
		this.batchID = batchID;
	}

	@Override
	public String toString() {
		return "InternDTO [id=" + id + ", name=" + name + ", college=" + college + ", email=" + email + ", city=" + city
				+ ", contact=" + contact + ", type=" + type + ", remark=" + remark + ", batchID=" + batchID + "]";
	}

}
