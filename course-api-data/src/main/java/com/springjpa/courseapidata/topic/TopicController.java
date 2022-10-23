package com.springjpa.courseapidata.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topics")
public class TopicController {

	@Autowired
	private TopicService topicService; //it will take (inject) the dependency that have already been created.
	
	@GetMapping("/{offset}/{pageSize}")
	public Page<Topic> getAllTopics(@PathVariable int offset, @PathVariable int pageSize) {
		return topicService.getAllTopics(offset, pageSize);
	}
	
	@GetMapping("/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	@PostMapping
	public void addTopic(@RequestBody Topic topic) { //our request payload will contain the body of the post request.
		topicService.addTopic(topic);
	}
	
	@PutMapping("/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) { //our request payload will contain the body of the post request.
		topicService.updateTopic(id, topic);
	}
	
	@DeleteMapping("/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}
}
