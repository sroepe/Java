package com.sararoepe.lookify.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sararoepe.lookify.models.Song;
import com.sararoepe.lookify.repositories.LookifyRepository;

@Service
public class LookifyService {
	private LookifyRepository lookifyRepository;
	public LookifyService(LookifyRepository lookifyRepository) {
		this.lookifyRepository = lookifyRepository;
	}
	List<Song> songs = new ArrayList<Song>(Arrays.asList());
	
	public List<Song> allSongs(){
		return (List<Song>)lookifyRepository.findAll();
	}
	
	public void addSong(Song song) {
		lookifyRepository.save(song);
	}
	
	public Song findSongById(Long id) {
		return lookifyRepository.findOne(id);
	}
	
	public void delete(Long id) {
		lookifyRepository.delete(id);
	}
	public List<Song> searchByString(String search) {
		List<Song> songs = lookifyRepository.findByArtistContaining(search);
		return songs;
	}
	
	public List<Song> topTen(){
		List<Song> songs = lookifyRepository.OrderByRatingDesc();
		for(int i = 0; i < songs.size(); i ++) {
			if (i > 10) {
				songs.remove(i);
			}
		}
		return songs;
	}

}
