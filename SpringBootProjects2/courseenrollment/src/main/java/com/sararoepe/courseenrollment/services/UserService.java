package com.sararoepe.courseenrollment.services;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sararoepe.courseenrollment.models.Course;
import com.sararoepe.courseenrollment.models.User;
import com.sararoepe.courseenrollment.repositories.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	public List<User> allUsers(){
		return (List<User>) userRepository.findAll();
	}
	
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
   
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
	public User findUserById(Long id) {
		return userRepository.findOne(id);
	}
	
	
	public List<User> getUsersOfCourse(Course course){
		return userRepository.findAllByCoursesContaining(course);
	}
	public List<User> getUsersNotOfCourse(Course course){
		return userRepository.findAllByCoursesNotContaining(course);
	}
	
	public void updateUser(User user) {
		userRepository.save(user);
	}
	


}
