package com.sararoepe.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sararoepe.lookify.models.Song;

@Repository
public interface LookifyRepository extends CrudRepository<Song, Long> {
	
	List<Song> findByArtistContaining(String search);
	public List<Song> OrderByRatingDesc();
}
