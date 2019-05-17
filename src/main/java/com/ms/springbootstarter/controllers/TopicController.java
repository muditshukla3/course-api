package com.ms.springbootstarter.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ms.springbootstarter.models.Topic;
import com.ms.springbootstarter.service.TopicService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/topics")
@Api(value="Topic", description="Operations pertaining to Topics")
public class TopicController {

	@Autowired
	private TopicService topicService;
	
	@GetMapping
	@ApiOperation(value = "View a list of available topics",response = List.class)
	public List<Topic> getAllTopics(){
		return topicService.getAllTopics();
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "View topics based on Id ",response = Topic.class)
	public Topic getTopic(@PathVariable String id){
		return topicService.findTopicById(id);
	}
	
	@PostMapping
	public void addTopic(@RequestBody Topic topic){
		topicService.addTopic(topic);
	}
	
	@PutMapping(value="/{id}")
	public void updateTopic(@RequestBody Topic topic,@PathVariable String id){
		topicService.updateTopic(topic,id);
	}
	
	@DeleteMapping(value="/{id}")
	public void deleteTopic(@PathVariable String id){
		topicService.deleteTopic(id);
	}
}
