package com.sararoepe.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sararoepe.lookify.models.Song;
import com.sararoepe.lookify.services.LookifyService;

@Controller
public class LookifyController {
	
	private final LookifyService lookifyService;
	public LookifyController(LookifyService lookifyService) {
		this.lookifyService = lookifyService;
	}
	
	
	@RequestMapping("/")
	public String landing() {
		return "landing.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String songs(Model model, @ModelAttribute("song") Song song) {
		List<Song> songs = lookifyService.allSongs();
		model.addAttribute("songs", songs);
		return "dashboard.jsp";
	}
	
	@RequestMapping("/songs/new")
	public String addNew(Model model, @ModelAttribute("song") Song song) {
		return "newSong.jsp";
	}
	
	@PostMapping("/addSong")
	public String createSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if(result.hasErrors()) {
			return "newSong.jsp";
		}else {
			lookifyService.addSong(song);
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping("/songs/{id}")
	public String findSongById(Model model, @PathVariable("id") Long id) {
		model.addAttribute("song", lookifyService.findSongById(id));
		return "showOne.jsp";
	}
	
	@RequestMapping("/delete/{id}")
	public String destroy(@PathVariable("id") Long id) {
		lookifyService.delete(id);
		return "redirect:/dashboard";
	}
	
	@RequestMapping(value="/search/")
	public String search(Model model, @ModelAttribute("artist") String artist, @RequestParam("artist") String search) {
		List<Song> songs = lookifyService.searchByString(artist);
		model.addAttribute("artist", artist);
		model.addAttribute("songs", songs);
		return "results.jsp";
	}
	
	@RequestMapping(value="/search/topTen")
	public String getTopTen(Model model) {
		List<Song> songs = lookifyService.topTen();
		model.addAttribute("songs", songs);
		return "topten.jsp";
	}
}
