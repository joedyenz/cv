package com.cv.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.cv.model.CVModel;

@Repository
public interface CVRepository extends MongoRepository<CVModel, String> {

	List<CVModel> findAll();
	@Query("{ 'id' : ?0 }")
	List<CVModel> findStoriesBy_id(String id);
}
