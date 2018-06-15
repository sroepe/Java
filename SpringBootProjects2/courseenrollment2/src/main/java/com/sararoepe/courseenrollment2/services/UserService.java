package com.sararoepe.courseenrollment2.services;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sararoepe.courseenrollment2.models.Course;
import com.sararoepe.courseenrollment2.models.User;
import com.sararoepe.courseenrollment2.repositories.RoleRepository;
import com.sararoepe.courseenrollment2.repositories.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder)     {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    public void saveWithUserRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_USER"));
        userRepository.save(user);
    }

    public void saveUserWithAdminRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
        userRepository.save(user);
    }    
    
    public List<User> allUsers(){
    	return (List<User>) userRepository.findAll();
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
