package com.sararoepe.brightideas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sararoepe.brightideas.models.Idea;
import com.sararoepe.brightideas.models.User;

@Repository
public interface IdeaRepository extends CrudRepository<Idea, Long> {
	List<Idea> findAll();
	List<Idea> findByUserIdContaining(User user);
	long countByUserId(Long userId);

}
