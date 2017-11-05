package com.nrg.springbootstarter.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nrg.springbootstarter.models.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, String> {

	public List<Course> findByName(String name);
	public List<Course> findByTopicId(String topicId);
}
