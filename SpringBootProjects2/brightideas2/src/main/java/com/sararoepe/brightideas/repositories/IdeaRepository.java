package com.sararoepe.brightideas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sararoepe.brightideas.models.Idea;
import com.sararoepe.brightideas.models.User;

@Repository
public interface IdeaRepository extends CrudRepository<Idea, Long> {
	List<Idea> findAll();
	List<Idea> findByUserIdContaining(User user);
	
	@Query(value = "select idea_id, count(user_id) from likes group by idea_id order by count(idea_id) desc", nativeQuery = true)
	long countByUserId(Long userId);
	

	
}
