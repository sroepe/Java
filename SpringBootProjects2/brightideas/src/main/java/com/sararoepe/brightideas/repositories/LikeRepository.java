package com.sararoepe.brightideas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sararoepe.brightideas.models.Like;

@Repository
public interface LikeRepository extends CrudRepository<Like, Long>{
	List<Like> findAll();
	
}
