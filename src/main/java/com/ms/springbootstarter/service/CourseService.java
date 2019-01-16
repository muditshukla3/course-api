package com.ms.springbootstarter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.springbootstarter.models.Course;
import com.ms.springbootstarter.repo.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses(String topicId){
		List<Course> courses = new ArrayList<Course>();
		courseRepository.findByTopicId(topicId)
		   .forEach(courses :: add);
		return courses;
	}
	
	public Course findCourseById(String id){
		return courseRepository.findOne(id);
	}
	
	public void addCourse(Course course){
		courseRepository.save(course);
	}

	public void updateCourse(Course course) {
		addCourse(course);;
	}

	public void deleteCourse(String id) {
		courseRepository.delete(id);
	}
}
