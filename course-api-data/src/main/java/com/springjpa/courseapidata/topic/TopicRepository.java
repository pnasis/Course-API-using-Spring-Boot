package com.springjpa.courseapidata.topic;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, String>{  //first we write the type of the entities and the type of the key.
	
}
