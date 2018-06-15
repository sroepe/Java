package com.sararoepe.courseenrollment3.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sararoepe.courseenrollment3.models.Course;
import com.sararoepe.courseenrollment3.models.User;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
	List<Course> findAll();
	List<Course> findAllByUsersContaining(User user);
//	List<Course> findAllByUsersNotContaining(User user);
	
	@Query(value = "select distinct (semester) from courseenrollment3.courses", nativeQuery = true)
	List<String> findSemesters();
	
	List<Course> findBySemesterContaining(String semester);
}
