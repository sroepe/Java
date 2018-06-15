package com.sararoepe.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sararoepe.dojooverflow.models.Question;
import com.sararoepe.dojooverflow.models.Tag;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long>{
	List<Question> findAll();
	List<Question> findAllByTagsContaining(Tag tag);
	List<Question> findAllByTagsNotContaining(Tag tag);
}
