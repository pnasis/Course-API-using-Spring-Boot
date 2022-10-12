package com.springjpa.courseapidata.lesson;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LessonRepository extends JpaRepository<Lesson, String>{  //first we write the type of the entities and the type of the key.
	
	//we implement our own method
	public List<Lesson> findByCourseId(String courseId);
}
