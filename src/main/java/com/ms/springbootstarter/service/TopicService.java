package com.ms.springbootstarter.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.springbootstarter.models.Topic;
import com.ms.springbootstarter.repo.TopicRepository;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getAllTopics(){
		List<Topic> topicList = new ArrayList<>();
		topicRepository.findAll().
		      forEach(topicList :: add);
		return topicList;
	}
	
	public Topic findTopicById(String id){

		Optional<Topic> topic = topicRepository.findById(id);
		return topic.orElse(new Topic());
	}
	
	public void addTopic(Topic topic){
		topicRepository.save(topic);
	}

	public void updateTopic(Topic topic, String id) {
		
		Optional<Topic> topicDB =topicRepository.findById(id);
		
		if(topicDB.isPresent()){
			topicRepository.save(topic);
		}
		
	}

	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
	}
}
