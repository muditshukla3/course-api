package com.ms.springbootstarter.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ms.springbootstarter.models.Course;
import com.ms.springbootstarter.models.Topic;
import com.ms.springbootstarter.service.CourseService;

import io.swagger.annotations.Api;

@RestController
@Api(value="Course", description="Operations pertaining to courses of topics")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@GetMapping("/topics/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable String topicId){
		return courseService.getAllCourses(topicId);
	}
	
	@GetMapping("/topics/{topicId}/courses/{courseId}")
	public Course getCourse(@PathVariable String topicId,@PathVariable String courseId){
		return courseService.findCourseById(courseId);
	}
	
	@PostMapping(value="/topics/{topicId}/courses")
	public void addCourse(@PathVariable String topicId,@RequestBody Course course){
		course.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(course);
	}
	
	@PutMapping(value="/topics/{topicId}/courses/{courseId}")
	public void updateTopic(@RequestBody Course course,@PathVariable String topicId,@PathVariable String courseId){
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(course);
	}
	
	@DeleteMapping(value="/topics/{topicId}/courses/{courseId}")
	public void deleteCourse(@PathVariable String courseId){
		courseService.deleteCourse(courseId);
	}
}
