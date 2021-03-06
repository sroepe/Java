package com.sararoepe.courseenrollment2.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sararoepe.courseenrollment2.models.Course;
import com.sararoepe.courseenrollment2.models.User;
import com.sararoepe.courseenrollment2.repositories.CourseRepository;

@Service
public class CourseService {
	private CourseRepository courseRepository;
	public CourseService(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}
	
	public List<Course> allCourses(){
		return (List<Course>) courseRepository.findAll();
	}
	
	public List<Course> getCoursesOfUser(User user){
		return courseRepository.findAllByUsersContaining(user);
	}
	public List<Course> getCoursesNotOfUser(User user){
		return courseRepository.findAllByUsersNotContaining(user);
	}
	
	public Course findCourseById(Long id){
		return courseRepository.findOne(id);
	}
	
	public void updateCourse(Course course) {
		course.getCapacity();
		course.setCapacity(+1);
		courseRepository.save(course);
	}

}
