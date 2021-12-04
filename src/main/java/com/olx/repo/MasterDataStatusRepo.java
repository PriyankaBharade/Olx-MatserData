package com.olx.repo;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.olx.entity.StatusDocument;

public interface MasterDataStatusRepo extends MongoRepository<StatusDocument,Integer>{


}
