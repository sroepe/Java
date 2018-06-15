package com.sararoepe.brightideas.services;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sararoepe.brightideas.models.Idea;
import com.sararoepe.brightideas.models.Like;
import com.sararoepe.brightideas.models.User;
import com.sararoepe.brightideas.models.UserLike;
import com.sararoepe.brightideas.repositories.IdeaRepository;
import com.sararoepe.brightideas.repositories.LikeRepository;
import com.sararoepe.brightideas.repositories.UserLikeRepository;
import com.sararoepe.brightideas.repositories.UserRepository;

@Service
public class MainService {
	private UserRepository userRepository;
	private IdeaRepository ideaRepository;
	private LikeRepository likeRepository;
	private UserLikeRepository userLikeRepository;
	
	public MainService(UserRepository userRepository, IdeaRepository ideaRepository, LikeRepository likeRepository, UserLikeRepository userLikeRepository) {
		this.userRepository = userRepository;
		this.ideaRepository = ideaRepository;
		this.likeRepository = likeRepository;
		this.userLikeRepository = userLikeRepository;
	}
	public Object addUser(User user, String confirmPassword, RedirectAttributes redirectAttributes) {
		boolean userExists = false;
		if(userRepository.findByEmail(user.getEmail()) instanceof User) {
			userExists = true;
			redirectAttributes.addFlashAttribute("reg", "Email already exists.");
		}
		if(confirmPassword.equals(user.getPassword()) && !userExists) {
			user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(10)));
			redirectAttributes.addFlashAttribute("reg", "Thank you for registering.  Please login.");
			return userRepository.save(user);
		}else {
			redirectAttributes.addFlashAttribute("reg", "Password and Confirmation do not match.");
			return "errors";
		}
	}
	
	public Object loginUser(String email, String password) {
		User user = userRepository.findByEmail(email);
		if(user == null) {
			return "Email does not exist";
			
		} else {
			if (BCrypt.checkpw(password, user.getPassword())) {
				return user;
			}else {
				return "Incorrect password. Please try again.";
			}
					
		}
		
	}	
	
	public User findUserById(Long id) {
		return userRepository.findOne(id);
	}
	
//	public List<User> findUsersById(List<Long> userId){
//		return userRepository.findAllById(userId);
//	}
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public User findByAlias(String alias) {
		return userRepository.findByAlias(alias);
	}
	
	public List<User> allUsers(){
		return userRepository.findAll();
	}
	
	public List<Idea> allIdeas(){
		return ideaRepository.findAll();
	}
	
	public List<Like> allLikes(){
		return likeRepository.findAll();
	}
	
	public List<UserLike> allUsersLikes(){
		return userLikeRepository.findAll();
	}
	
	public void addIdea(Idea idea) {
		ideaRepository.save(idea);
	}
	
	public void addLike(Like like) {
		likeRepository.save(like);
	}
	
	public int incrementCount(int count) {
		count++;
		return count;
	}
	
	public void updateUser(User user) {
		userRepository.save(user);
	}
	
	public Like findLikeById(Long id) {
		return likeRepository.findOne(id);
	}
	
	public void updateLike(Like like) {
		likeRepository.save(like);
	}
	
	public void updateIdea(Idea idea) {
		ideaRepository.save(idea);
	}
	
	public Idea findIdeaById(Long id) {
		return ideaRepository.findOne(id);
	}
	
	public Long countIdeas(Long userId){
		return ideaRepository.countByUserId(userId);
	}
	
	public void deleteIdea(Long id) {
		ideaRepository.delete(id);
	}
	
	public void addUserLike(UserLike userLike) {
		userLikeRepository.save(userLike);
	}
	
	public Long countLikes(Long userId){
		return userLikeRepository.countByUserId(userId);
	}
	
	public List<Long> findUniqueUsers() {
		return userLikeRepository.findDistinctUsers();
		
	}

}
