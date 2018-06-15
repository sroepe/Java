package com.sararoepe.courseenrollment2.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sararoepe.courseenrollment2.models.Course;
import com.sararoepe.courseenrollment2.models.User;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
	List<Course> findAll();
	List<Course> findAllByUsersContaining(User user);
	List<Course> findAllByUsersNotContaining(User user);

}
