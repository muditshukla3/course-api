package com.ms.springbootstarter.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ms.springbootstarter.models.Topic;

@Repository
public interface TopicRepository extends CrudRepository<Topic, String> {
	
}
