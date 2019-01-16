package com.ms.springbootstarter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.springbootstarter.models.Topic;
import com.ms.springbootstarter.repo.TopicRepository;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getAllTopics(){
		List<Topic> topicList = new ArrayList<Topic>();
		topicRepository.findAll().
		      forEach(topicList :: add);
		return topicList;
	}
	
	public Topic findTopicById(String id){
		return topicRepository.findOne(id);
	}
	
	public void addTopic(Topic topic){
		topicRepository.save(topic);
	}

	public void updateTopic(Topic topic, String id) {
		
		Topic topicDB =topicRepository.findOne(id);
		
		if(topicDB!=null){
			topicRepository.save(topic);
		}
		
	}

	public void deleteTopic(String id) {
		topicRepository.delete(id);
	}
}
