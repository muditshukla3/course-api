package com.nrg.springbootstarter.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nrg.springbootstarter.models.Topic;

@Repository
public interface TopicRepository extends CrudRepository<Topic, String> {
	
}
