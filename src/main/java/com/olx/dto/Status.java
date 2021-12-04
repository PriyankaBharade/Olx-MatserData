package com.olx.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Status Model")
public class Status {
@ApiModelProperty("Unique indentifier of the Status")
private int id;
@ApiModelProperty("Unique indentifier of the Status")
private String status;

public Status() {
	super();
}
@Override
public String toString() {
	return "Status [id=" + id + ", status=" + status + "]";
}
public Status(int id, String status) {
	super();
	this.id = id;
	this.status = status;
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
