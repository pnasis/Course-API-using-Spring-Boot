package com.springjpa.courseapidata.course;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseRepository extends JpaRepository<Course, String>{  //first we write the type of the entities and the type of the key.
	
	//we implement our own method
	public List<Course> findByTopicId(String topicId);
}
