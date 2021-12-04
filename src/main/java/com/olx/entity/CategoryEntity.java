package com.olx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="category")
public class CategoryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int id;
	@Column(name = "category_name")
	private String category;
	@Override
	public String toString() {
		return "Category [id=" + id + ", category=" + category + "]";
	}
	
	public CategoryEntity() {
	}
	
	public CategoryEntity(int id, String category) {
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
