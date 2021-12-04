package com.olx.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olx.dto.Category;
import com.olx.dto.Status;
import com.olx.entity.CategoryDocument;
import com.olx.entity.StatusDocument;
import com.olx.exception.InvalidStockIdException;
import com.olx.repo.MasterDataCategoryRepo;
import com.olx.repo.MasterDataStatusRepo;




@Service(value = "MONGO_SERVICE")
public class MasterDataMongoServiceImpl implements MasterDataService{

	@Autowired
	MasterDataCategoryRepo masterdatamongoepo;
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	MasterDataStatusRepo mongoDataStatus;
	
	@Override
	public List<Category> getAdvertiseCategory() {
		List<CategoryDocument> categoryList = this.masterdatamongoepo.findAll();
		return convertCateDocToDto(categoryList);
	}
	
	public Category createCategory(Category category) {
		CategoryDocument categoryDcument = this.modelMapper.map(category, CategoryDocument.class);
		categoryDcument = this.masterdatamongoepo.save(categoryDcument);
		Category categoryData = this.modelMapper.map(categoryDcument, Category.class);
		return categoryData;
	}

	@Override
	public List<Status> getStatus() {
		List<StatusDocument> listStatusDoc = this.mongoDataStatus.findAll();
		return convertStatusDocToDto(listStatusDoc);
	}

	@Override
	public Status createStatus(Status status) {
		StatusDocument statusDocument = this.modelMapper.map(status, StatusDocument.class);
		statusDocument = this.mongoDataStatus.save(statusDocument);
		Status statusData = this.modelMapper.map(statusDocument, Status.class);
		return statusData;
	}
	
	public List<Status> convertStatusDocToDto(List<StatusDocument> listStatusDoc) {
		List<Status> statusDtoList = new ArrayList<Status>();
		for(StatusDocument statusDocument: listStatusDoc) {
			Status statusDto = this.modelMapper.map(statusDocument, Status.class);
			statusDtoList.add(statusDto);
		}
		return statusDtoList;
	}
	
	public List<Category> convertCateDocToDto(List<CategoryDocument> listCateDoc) {
		List<Category> cateDtoList = new ArrayList<Category>();
		for(CategoryDocument categoryDocument: listCateDoc) {
			Category cateDto = this.modelMapper.map(categoryDocument, Category.class);
			cateDtoList.add(cateDto);
		}
		return cateDtoList;
	}

	@Override
	public boolean deleteCategoryById(int categoryId) {
		masterdatamongoepo.deleteById(categoryId);
		return true;
	}

	@Override
	public Category updateCategory(int categoryId, Category category) {
		Optional<CategoryDocument> opCatgeoryDocument = masterdatamongoepo.findById(categoryId);
		if(opCatgeoryDocument.isPresent()) { //Correct stockId
			CategoryDocument categoryckDocument = opCatgeoryDocument.get();
			category.setId(categoryId);
			categoryckDocument = this.modelMapper.map(category, CategoryDocument.class);
			categoryckDocument = masterdatamongoepo.save(categoryckDocument);
			Category cateDto = this.modelMapper.map(categoryckDocument, Category.class);
			return cateDto;
		}
		return null;
	}

	@Override
	public Category getCategoryById(int categoryId) {
		Optional<CategoryDocument> opCategoryDocument = masterdatamongoepo.findById(categoryId);
		if(opCategoryDocument.isPresent()) { //Correct stockId
			CategoryDocument categoryDocument = opCategoryDocument.get();
			Category cateDto = this.modelMapper.map(categoryDocument, Category.class);
			return cateDto;
		}
		throw new InvalidStockIdException(""+categoryId);
	}

	@Override
	public boolean deleteStatusById(int statusId) {
		mongoDataStatus.deleteById(statusId);
		return true;
	}

	@Override
	public Status updateStatus(int statusId, Status status) {
		Optional<StatusDocument> opStatusDocument = mongoDataStatus.findById(statusId);
		if(opStatusDocument.isPresent()) { //Correct stockId
			StatusDocument satusDocument = opStatusDocument.get();
			status.setId(statusId);
			satusDocument = this.modelMapper.map(status, StatusDocument.class);
			satusDocument = mongoDataStatus.save(satusDocument);
			Status statusDto = this.modelMapper.map(satusDocument, Status.class);
			return statusDto;
		}
		return null;
	}

	@Override
	public Status getStatusById(int statusId) {
		Optional<StatusDocument> opStausDocument = mongoDataStatus.findById(statusId);
		if(opStausDocument.isPresent()) { //Correct stockId
			StatusDocument statusDocument = opStausDocument.get();
			Status statusDto = this.modelMapper.map(statusDocument, Status.class);
			return statusDto;
		}
		return null;
	}

//	@Override
//	public Status getStatusById(int statusId) {
//		Optional<StatusDocument> opStausDocument = mongoDataStatus.findById(statusId);
//		if(opStausDocument.isPresent()) { //Correct stockId
//			StatusDocument statusDocument = opStausDocument.get();
//			Status statusDto = this.modelMapper.map(statusDocument, Status.class);
//			return statusDto;
//		}
//		throw new InvalidStockIdException(""+statusId);
//	}

}
