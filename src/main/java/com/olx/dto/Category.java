package com.olx.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Category Model")
public class Category {
	@ApiModelProperty("Unique indentifier of the Category")
	private int id;
	@ApiModelProperty("Name of the Category")
	private String category;
	@Override
	public String toString() {
		return "Category [id=" + id + ", category=" + category + "]";
	}
	
	public Category() {
		
	}
	
	public Category(int id, String category) {
		super();
		this.id = id;
		this.category = category;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}
