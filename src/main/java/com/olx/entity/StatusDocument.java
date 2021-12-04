package com.olx.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "status")
public class StatusDocument {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String status;
	
	public StatusDocument() {
		super();
	}
	public StatusDocument(int id, String status) {
		super();
		this.id = id;
		this.status = status;
	}
	@Override
	public String toString() {
		return "StatusDocument [id=" + id + ", status=" + status + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
