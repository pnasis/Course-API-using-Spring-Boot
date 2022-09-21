package com.springjpa.courseapidata.topic;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String>{  //first we write the type of the entities and the type of the key.
	
}
