package com.sararoepe.courseenrollment.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sararoepe.courseenrollment.models.Course;
import com.sararoepe.courseenrollment.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
	List<User> findAll();
	List<User> findAllByCoursesContaining(Course course);
	List<User> findAllByCoursesNotContaining(Course course);

}
