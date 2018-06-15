package com.sararoepe.courseenrollment3.services;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sararoepe.courseenrollment3.models.Course;
import com.sararoepe.courseenrollment3.models.User;
import com.sararoepe.courseenrollment3.repositories.CourseRepository;
import com.sararoepe.courseenrollment3.repositories.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;
	private CourseRepository courseRepository;
	
	public UserService(UserRepository userRepository, CourseRepository courseRepository) {
		this.userRepository = userRepository;
		this.courseRepository = courseRepository;
	}
	
	public Object addUser(User user, String confirmPassword, RedirectAttributes redirectAttributes) {
		boolean userExists = false;
		if(userRepository.findByUsername(user.getUsername()) instanceof User) {
			userExists = true;
			redirectAttributes.addFlashAttribute("reg", "Username already exists.");
		}
		if(confirmPassword.equals(user.getPassword()) && !userExists) {
			user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(10)));
			redirectAttributes.addFlashAttribute("reg", "Thank you for registering.  Please login.");
			return userRepository.save(user);
		}else {
			redirectAttributes.addFlashAttribute("reg", "Password and Confirmation do not match.");
			return "errors";
		}
	}
	
	public Object loginUser(String username, String password) {
		User user = userRepository.findByUsername(username);
		if(user == null) {
			return "Username does not exist";
			
		} else {
			if (BCrypt.checkpw(password, user.getPassword())) {
				return user;
			}else {
				return "Incorrect password. Please try again.";
			}	
		}
	}	
	
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public User findUserById(Long id) {
		return userRepository.findOne(id);
	}
	
	public List<Course> allCourses(){
		return (List<Course>) courseRepository.findAll();
	}
	
	public List<Course> getCoursesOfUser(User user){
		return courseRepository.findAllByUsersContaining(user);
	}
//	public List<Course> getCoursesNotOfUser(User user){
//		return courseRepository.findAllByUsersNotContaining(user);
//	}
	
	public Course findCourseById(Long id){
		return courseRepository.findOne(id);
	}
	
	public void updateCourseUsers(List<User> courseUsers) {
		userRepository.save(courseUsers);
	}
	
	public List<String> getSemesters(){
		return (List<String>) courseRepository.findSemesters();
	}
	
	public List<Course> findCoursesBySemester(String semester){
		return courseRepository.findBySemesterContaining(semester);
	}
	

}
