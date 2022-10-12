package com.springjpa.courseapidata.lesson;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.springjpa.courseapidata.course.Course;


@RestController
@RequestMapping("/topics/{topicId}/courses/{courseId}/lessons")
public class LessonController {

	@Autowired
	private LessonService lessonService; //it will take (inject) the dependency that have already been created.
	
	@GetMapping
	public List<Lesson> getAllLessons(@PathVariable String courseId) {
		return lessonService.getAllLessons(courseId);
	}
	
	@GetMapping("/{id}")
	public Lesson getLesson(@PathVariable String id) {
		return lessonService.getLesson(id);
	}
	
	@PostMapping
	public void addLesson(@RequestBody Lesson lesson, @PathVariable String topicId, @PathVariable String courseId) { //our request payload will contain the body of the post request.
		lesson.setCourse(new Course(courseId, "", "", topicId));
		lessonService.addLesson(lesson);
	}
	
	@PutMapping("/{id}")
	public void updateLesson(@RequestBody Lesson lesson, @PathVariable String topicId, @PathVariable String courseId, @PathVariable String id) { //our request payload will contain the body of the post request.
		lesson.setCourse(new Course(courseId, "", "", topicId));
		lessonService.updateLesson(lesson);
	}
	
	@DeleteMapping("/{lessonId}")
	public void deleteLesson(@PathVariable String lessonId) {
		lessonService.deleteLesson(lessonId);
	}
}
