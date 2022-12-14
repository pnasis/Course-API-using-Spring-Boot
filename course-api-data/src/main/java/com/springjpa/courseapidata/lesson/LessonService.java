package com.springjpa.courseapidata.lesson;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class LessonService { //when the applications starts it creates an instance of this service, that other classes can use.
	
	@Autowired  //dependency injection
	private LessonRepository lessonRepository;
	
	public List<Lesson> getAllLessons(String courseId) {		
		return lessonRepository.findByCourseId(courseId); //for each element that i iterate i add it in the arraylist.;
	}
	
	public Lesson getLesson(String id) {
		Optional<Lesson> optionalLesson = lessonRepository.findById(id);
		return optionalLesson.get();
	}

	public void addLesson(Lesson lesson) {
		lessonRepository.save(lesson);
	}

	public void updateLesson(Lesson lesson) {
		Optional<Lesson> optionalLesson = lessonRepository.findById(lesson.getId());
		if(optionalLesson.isPresent())
		{
			optionalLesson.get().setName(lesson.getName());
			optionalLesson.get().setDescription(lesson.getDescription());
			lessonRepository.save(optionalLesson.get());
		}
		else throw new RuntimeException("Lesson Not Found");
	}

	public void deleteLesson(String id) {
		lessonRepository.deleteById(id);
	}
}
