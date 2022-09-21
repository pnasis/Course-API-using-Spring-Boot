package com.springjpa.courseapidata.lesson;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.springjpa.courseapidata.course.Course;


@RestController
public class LessonController {

	@Autowired
	private LessonService lessonService; //it will take (inject) the dependency that have already been created.
	
	@RequestMapping("/topics/{topicId}/courses/{courseId}/lessons")
	public List<Lesson> getAllLessons(@PathVariable String courseId) {
		return lessonService.getAllLessons(courseId);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{courseId}/lessons/{id}")
	public Lesson getLesson(@PathVariable String id) {
		return lessonService.getLesson(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses/{courseId}/lessons")
	public void addLesson(@RequestBody Lesson lesson, @PathVariable String topicId, @PathVariable String courseId) { //our request payload will contain the body of the post request.
		lesson.setCourse(new Course(courseId, "", "", topicId));
		lessonService.addLesson(lesson);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{courseId}/lessons/{id}")
	public void updateLesson(@RequestBody Lesson lesson, @PathVariable String topicId, @PathVariable String courseId, @PathVariable String id) { //our request payload will contain the body of the post request.
		lesson.setCourse(new Course(courseId, "", "", topicId));
		lessonService.updateLesson(lesson);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
	public void deleteLesson(@PathVariable String lessonId) {
		lessonService.deleteLesson(lessonId);
	}
}
