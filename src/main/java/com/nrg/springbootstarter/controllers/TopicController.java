package com.nrg.springbootstarter.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nrg.springbootstarter.models.Topic;
import com.nrg.springbootstarter.service.TopicService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/topics")
@Api(value="Topic", produces="Operations pertaining to Topics")
public class TopicController {

	@Autowired
	private TopicService topicService;
	
	@RequestMapping(method=RequestMethod.GET)
	@ApiOperation(value = "View a list of available topics",response = List.class)
	public List<Topic> getAllTopics(){
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/{id}")
	@ApiOperation(value = "View topics based on Id ",response = Topic.class)
	public Topic getTopic(@PathVariable String id){
		return topicService.findTopicById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void addTopic(@RequestBody Topic topic){
		topicService.addTopic(topic);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public void updateTopic(@RequestBody Topic topic,@PathVariable String id){
		topicService.updateTopic(topic,id);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public void deleteTopic(@PathVariable String id){
		topicService.deleteTopic(id);
	}
}
