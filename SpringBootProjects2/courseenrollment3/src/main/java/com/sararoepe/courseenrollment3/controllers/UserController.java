package com.sararoepe.courseenrollment3.controllers;

import java.util.List;

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

import com.sararoepe.courseenrollment3.models.Course;
import com.sararoepe.courseenrollment3.models.User;
import com.sararoepe.courseenrollment3.services.UserService;



@Controller
@SessionAttributes("sessionAttribute")
public class UserController {
	@ModelAttribute("sessionAttribute")
    public String getSessionAttribute(){
        return "currentUser";
    }
	
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
	@RequestMapping("/")
	public String loginReg(@ModelAttribute("user") User user, @ModelAttribute("errors") String errors) {
		return "loginReg.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, @RequestParam(value="confirmPassword") String confirmPassword, Model model, RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			return "loginReg.jsp";
		} else {
			userService.addUser(user, confirmPassword, redirectAttributes);
			return "redirect:/";
		}
	}
	
	@PostMapping("/login")
	public String login(@RequestParam(value="username") String username, @RequestParam(value="password") String password, HttpSession session, Model model, RedirectAttributes redirectAttributes) {
		Object val = userService.loginUser(username, password);
		if(val instanceof String) {
			redirectAttributes.addFlashAttribute("log", val);
			return "redirect:/";
		}
        model.addAttribute("sessionAttribute", userService.findByUsername(username));
		return "redirect:/home";
	}
	
	@RequestMapping("/home")
	public String home(@ModelAttribute("sessionAttribute") Long sessionAttribute, @ModelAttribute("course") Course course,  @ModelAttribute("semester") String semester, Model model) {
		List<String> semesters = userService.getSemesters();
		model.addAttribute("semesters", semesters);
		User user = userService.findUserById(sessionAttribute);
		List<Course> courseUsers = userService.getCoursesOfUser(user);
		model.addAttribute("courseUsers", courseUsers);
		return "home.jsp";
	}
	
	@RequestMapping("/courses")
	public String dashboard(@ModelAttribute("course") Course course, @ModelAttribute("semester") String semester, Model model) {
		List<String> semesters = userService.getSemesters();
		model.addAttribute("semesters", semesters);
		List<Course> semCourses = userService.findCoursesBySemester(semester);
		model.addAttribute("semCourses", semCourses);
		
		return "courses.jsp";
	}
	
//	@RequestMapping(value = "/courses/")
//	public String selectSemester(@RequestParam("semester") String semester, @ModelAttribute("course") Course course, Model model) {
//		List<Course> semCourses = userService.findCoursesBySemester(semester);
//		model.addAttribute("semCourses", semCourses);
//
//		return "courses.jsp";
//	}
	
	@RequestMapping("/goback")
	public String goBack() {
		return "redirect:/home";
	}
	
	@RequestMapping("/add/{id}")
	public String userAddCourse(@PathVariable("id") Long id, @ModelAttribute("sessionAttribute") Long sessionAttribute, Model model) {
		Course course = userService.findCourseById(id);
		User user = userService.findUserById(sessionAttribute);
		List<User> courseUsers = course.getUsers();
		if(!courseUsers.contains(user)) {
			courseUsers.add(user);		
			}	
			course.setUsers(courseUsers);
			userService.updateCourseUsers(courseUsers);
			model.addAttribute("user", userService.findUserById(sessionAttribute));	
			
		return "redirect:/home";
		
	}
	
	
	
}
