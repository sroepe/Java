package com.sararoepe.brightideas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sararoepe.brightideas.models.UserLike;

@Repository
public interface UserLikeRepository extends CrudRepository<UserLike, Long>{
	List<UserLike> findAll();
	long countByUserId(Long userId);
	

	@Query(value="SELECT distinct (user_id) from users_likes", nativeQuery=true)
	List<Long> findDistinctUsers();
	
}
