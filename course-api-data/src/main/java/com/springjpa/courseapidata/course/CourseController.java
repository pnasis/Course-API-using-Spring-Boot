package com.springjpa.courseapidata.course;

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

import com.springjpa.courseapidata.topic.Topic;

@RestController
@RequestMapping("/topics/{topicId}/courses")
public class CourseController {

	@Autowired
	private CourseService courseService; //it will take (inject) the dependency that have already been created.
	
	@GetMapping
	public List<Course> getAllCourses(@PathVariable String topicId) {
		return courseService.getAllCourses(topicId);
	}
	
	@GetMapping("/{id}")
	public Course getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	@PostMapping
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) { //our request payload will contain the body of the post request.
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
	}
	
	@PutMapping("/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id) { //our request payload will contain the body of the post request.
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCourse(@PathVariable String id) {
		courseService.deleteCourse(id);
	}
}
