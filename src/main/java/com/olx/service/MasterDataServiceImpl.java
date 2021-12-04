package com.olx.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.olx.dto.Category;
import com.olx.dto.Status;

@Service
public class MasterDataServiceImpl implements MasterDataService{

	@Override
	public List<Category> getAdvertiseCategory() {
		// TODO Auto-generated method stub
		List<Category> categories = new ArrayList<Category>();
		categories.add(new Category(1,"Furniture"));
		categories.add(new Category(2,"Real State"));
		return categories;
	}

	@Override
	public List<Status> getStatus() {
		List<Status> status = new ArrayList<Status>();
		status.add(new Status(1,"Open"));
		status.add(new Status(2,"Closed"));
		return status;
	}

	@Override
	public Category createCategory(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status createStatus(Status category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteCategoryById(int categoryId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Category updateCategory(int categoryId, Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category getCategoryById(int categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteStatusById(int statusId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Status updateStatus(int statusId, Status status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status getStatusById(int statusId) {
		// TODO Auto-generated method stub
		return null;
	}

}
