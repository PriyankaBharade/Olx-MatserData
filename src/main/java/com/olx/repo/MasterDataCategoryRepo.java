package com.olx.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.olx.entity.CategoryDocument;

public interface MasterDataCategoryRepo extends MongoRepository<CategoryDocument,Integer>{


}
