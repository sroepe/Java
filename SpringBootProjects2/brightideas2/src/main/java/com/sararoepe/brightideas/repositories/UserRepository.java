package com.sararoepe.brightideas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sararoepe.brightideas.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	List<User> findAll();
	User findByEmail(String email);
	User findByAlias(String alias);
	User findOne(Long id);
	
	long countById(Long id);

}
