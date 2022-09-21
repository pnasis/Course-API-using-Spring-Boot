package com.springjpa.courseapidata.lesson;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService { //when the applications starts it creates an instance of this service, that other classes can use.
	
	@Autowired  //dependency injection
	private LessonRepository lessonRepository;
	
	public List<Lesson> getAllLessons(String courseId) {
		List<Lesson> lessons = new ArrayList<>();
		lessonRepository.findByCourseId(courseId).forEach(lessons::add); //for each element that i iterate i add it in the arraylist.
		return lessons;
	}
	
	public Lesson getLesson(String id) {
		Optional<Lesson> optionalLesson = lessonRepository.findById(id);
		return optionalLesson.get();
	}

	public void addLesson(Lesson lesson) {
		lessonRepository.save(lesson);
	}

	public void updateLesson(Lesson lesson) {
		lessonRepository.save(lesson);
	}

	public void deleteLesson(String id) {
		lessonRepository.deleteById(id);
	}
}
