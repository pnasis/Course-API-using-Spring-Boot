package com.springjpa.courseapidata.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class CourseService { //when the applications starts it creates an instance of this service, that other classes can use.
	
	@Autowired  //dependency injection
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses(String topicId) {
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(courses::add); //for each element that i iterate i add it in the arraylist.
		return courses;
	}
	
	public Course getCourse(String id) {
		Optional<Course> optionalTopic = courseRepository.findById(id);
		return optionalTopic.get();
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
	}

	public void updateCourse(Course course) {
		Optional<Course> optionalCourse = courseRepository.findById(course.getId());
		if(optionalCourse.isPresent())
		{
			optionalCourse.get().setName(course.getName());
			optionalCourse.get().setDescription(course.getDescription());
			courseRepository.save(optionalCourse.get());
		}
		else throw new RuntimeException("Course Not Found");
	}

	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
	}
}
