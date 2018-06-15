package com.sararoepe.loginreg.controllers;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sararoepe.loginreg.models.User;
import com.sararoepe.loginreg.services.UserService;
import com.sararoepe.loginreg.validator.UserValidator;


@Controller
public class UserController {
	
	private UserValidator userValidator;
	
	private final UserService userService;
	
	public UserController(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
	}
	

	@RequestMapping("/login")
    public String login(@Valid @ModelAttribute("user") User user, @RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
        if(error != null) {
            model.addAttribute("error", error);
            return "redirect:/login" + error;
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        } 
        return "loginReg.jsp";
	}
    
    @PostMapping("/registration")
    public String registration(RedirectAttributes redirectAttributes, @ModelAttribute("message") String message, @Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
        userValidator.validate(user, result);
    	if (result.hasErrors()) {
            return "redirect:/login";
        }
        userService.saveUser(user);
        model.addAttribute("message", message);
        redirectAttributes.addFlashAttribute("message", "You successfully registered.  Please login.");
        return "redirect:/login";
    }
    

    
    @RequestMapping(value = {"/", "/dashboard"})
    public String home(Principal principal, Model model) {
        
        String email = principal.getName();
        model.addAttribute("currentUser", userService.findByEmail(email));
        return "dashboard.jsp";
    }
}
