package com.springjpa.courseapidata.topic;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TopicService { //when the applications starts it creates an instance of this service, that other classes can use.
	
	@Autowired  //dependency injection
	private TopicRepository topicRepository;
	
	public Page<Topic> getAllTopics(int offset , int pageSize) {
		return topicRepository.findAll(PageRequest.of(offset, pageSize, Sort.Direction.ASC, "name")); //for each element that i iterate i add it in the arraylist.
	}
	
	public Topic getTopic(String id) {
		Optional<Topic> optionalTopic = topicRepository.findById(id);
		return optionalTopic.get();
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
		Optional<Topic> optionalTopic = topicRepository.findById(id);
		if(optionalTopic.isPresent())
		{
			optionalTopic.get().setName(topic.getName());
			optionalTopic.get().setDescription(topic.getDescription());
			topicRepository.save(optionalTopic.get());
		}
		else throw new RuntimeException("Topic Not Found");
	}

	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
	}
}
