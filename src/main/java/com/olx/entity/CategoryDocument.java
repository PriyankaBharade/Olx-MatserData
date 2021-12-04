package com.olx.entity;



import org.springframework.data.mongodb.core.mapping.Document;

import nonapi.io.github.classgraph.json.Id;

@Document(value = "category")
public class CategoryDocument {
	@Id
	private int id;
	private String category;
	
	public CategoryDocument() {
		
	}
	
	public CategoryDocument(int id, String category) {
		super();
		this.id = id;
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "CategoryDocument [id=" + id + ", category=" + category + "]";
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
