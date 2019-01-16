package com.ms.springbootstarter.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ms.springbootstarter.models.Course;
import com.ms.springbootstarter.models.Topic;
import com.ms.springbootstarter.service.CourseService;

import io.swagger.annotations.Api;

@RestController
@Api(value="Course", description="Operations pertaining to courses of topics")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable String topicId){
		return courseService.getAllCourses(topicId);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{courseId}")
	public Course getCourse(@PathVariable String topicId,@PathVariable String courseId){
		return courseService.findCourseById(courseId);
	}
	
	@RequestMapping(value="/topics/{topicId}/courses",method=RequestMethod.POST)
	public void addCourse(@PathVariable String topicId,@RequestBody Course course){
		course.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(course);
	}
	
	@RequestMapping(value="/topics/{topicId}/courses/{courseId}",method=RequestMethod.PUT)
	public void updateTopic(@RequestBody Course course,@PathVariable String topicId,@PathVariable String courseId){
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(value="/topics/{topicId}/courses/{courseId}",method=RequestMethod.DELETE)
	public void deleteCourse(@PathVariable String courseId){
		courseService.deleteCourse(courseId);
	}
}
