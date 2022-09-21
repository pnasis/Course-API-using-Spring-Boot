package com.springjpa.courseapidata.lesson;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface LessonRepository extends CrudRepository<Lesson, String>{  //first we write the type of the entities and the type of the key.
	
	//we implement our own method
	public List<Lesson> findByCourseId(String courseId);
}
