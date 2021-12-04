package com.olx.service;

import java.util.List;

import com.olx.dto.Category;
import com.olx.dto.Status;

public interface MasterDataService {
	public List<Category> getAdvertiseCategory();
	public boolean deleteCategoryById(int categoryId);
	public Category updateCategory(int categoryId, Category category);
	public Category getCategoryById(int categoryId);
	public Category createCategory(Category category);
	
	public Status createStatus(Status status);
	public List<Status> getStatus();
	public boolean deleteStatusById(int statusId);
	public Status updateStatus(int statusId, Status status);
	public Status getStatusById(int statusId);

}
