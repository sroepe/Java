package com.sararoepe.courseenrollment3.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sararoepe.courseenrollment3.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findAll();
	User findByUsername(String username);
	User findById(Long id);
//	List<Course> findAllByUserContaining(User user);
}
