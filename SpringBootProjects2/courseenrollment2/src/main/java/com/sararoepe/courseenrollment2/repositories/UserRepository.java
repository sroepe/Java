package com.sararoepe.courseenrollment2.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sararoepe.courseenrollment2.models.Course;
import com.sararoepe.courseenrollment2.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findAll();
	User findByUsername(String username);
	List<User> findAllByCoursesContaining(Course course);
	List<User> findAllByCoursesNotContaining(Course course);
}
