package com.sararoepe.brightideas.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sararoepe.brightideas.models.Idea;
import com.sararoepe.brightideas.models.User;
import com.sararoepe.brightideas.services.MainService;

@Controller
@SessionAttributes("sessionAttribute")
public class MainController {
	@ModelAttribute("sessionAttribute")
    public String getSessionAttribute(){
        return "currentUser";
    }
	
	private final MainService mainService;
	
	public MainController(MainService mainService) {
		this.mainService = mainService;
	}
	
	@RequestMapping("/")
	public String redirectMain() {
		return "redirect:/main";
	}
	
	@RequestMapping("/main")
	public String loginReg(@ModelAttribute("user") User user, @ModelAttribute("errors") String errors) {
		return "loginReg.jsp";
	}
		
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, @RequestParam(value="confirmPassword") String confirmPassword, Model model, RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			return "loginReg.jsp";
		} else {
			mainService.addUser(user, confirmPassword, redirectAttributes);
			return "redirect:/main";
		}
	}
	
	@PostMapping("/login")
	public String login(@RequestParam(value="email") String email, @RequestParam(value="password") String password, HttpSession session, Model model, RedirectAttributes redirectAttributes) {
		Object val = mainService.loginUser(email, password);
		if(val instanceof String) {
			redirectAttributes.addFlashAttribute("log", val);
			return "redirect:/";
		}
        model.addAttribute("sessionAttribute", mainService.findByEmail(email));
		return "redirect:/bright_ideas";
	}
	
	@RequestMapping("/home")
	public String home(@ModelAttribute("sessionAttribute") String sessionAttribute, Model model) {
		return "home.jsp";
	}
	
	@RequestMapping("/bright_ideas")
	public String dashboard(@ModelAttribute("sessionAttribute") String sessionAttribute, Model model, @ModelAttribute("idea") Idea idea, @ModelAttribute("sessionAttribute.name") String sessionName) {
		List<Idea> ideas = mainService.allIdeas();
		model.addAttribute("ideas", ideas);
		model.addAttribute("users", mainService.allUsers());
		getSessionAttribute();

		return "brightIdeas.jsp";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();

		return "redirect:/main";
	}
	
	@PostMapping("/addIdea/{sessionAttribute.id}")
	public String newIdea(@PathVariable("sessionAttribute.id") Long userId, @Valid @ModelAttribute("idea") Idea idea, BindingResult result, @ModelAttribute("sessionAttribute") String sessionAttribute, Model model) {
		if(result.hasErrors()) {
			return "redirect:/bright_ideas";
		} else {
			User user = mainService.findUserById(userId);
			idea.setUser(user);
			mainService.addIdea(idea);
			idea.getId();

			return "redirect:/bright_ideas";
		}
	}
	
	@RequestMapping("/users/{idea.user.id}")
	public String userProfile(@PathVariable("idea.user.id") Long userId, @ModelAttribute("idea") Idea idea, Model model) {
		User user = mainService.findUserById(userId);
		Long userPosts = mainService.countIdeas(userId);
		int likes = user.getIdeasLiked().size();		
		model.addAttribute("userPosts", userPosts);
		model.addAttribute("likes", likes);
		model.addAttribute("user", user);
		return "profile.jsp";
	}
	
	@RequestMapping("/addLike/{idea.id}")
	public String addLike(@PathVariable("idea.id") Long ideaId, @ModelAttribute("sessionAttribute") Long sessionAttribute, HttpSession session, Model model, RedirectAttributes redirectAttributes) {
		Idea idea = mainService.findIdeaById(ideaId);
		User user = mainService.findUserById(sessionAttribute);
		List<User> likes = idea.getLikes();
		if(!likes.contains(user)) {
			likes.add(user);
		}else {
			redirectAttributes.addFlashAttribute("log", "You can only like an idea once:)");
			return "redirect:/bright_ideas";
		}
		idea.setLikes(likes);
		mainService.updateLikes(likes);
		return "redirect:/bright_ideas";
	}
	
	@RequestMapping("/bright_ideas/{idea.id}")
	public String showIdeaLikes(@PathVariable("idea.id") Long ideaId, @ModelAttribute("user") User user, Model model) {
		model.addAttribute("idea", mainService.findIdeaById(ideaId));
		return "ideaLikes.jsp";
	}
	
	@RequestMapping("/delete/{idea.id}")
	public String deleteIdea(@PathVariable("idea.id") Long id) {
		mainService.deleteIdea(id);
		return "redirect:/bright_ideas";
	}
	
	
}

