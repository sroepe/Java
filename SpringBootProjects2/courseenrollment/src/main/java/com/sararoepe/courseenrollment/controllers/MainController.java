package com.sararoepe.courseenrollment.controllers;

import java.security.Principal;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sararoepe.courseenrollment.models.Course;
import com.sararoepe.courseenrollment.models.User;
import com.sararoepe.courseenrollment.services.CourseService;
import com.sararoepe.courseenrollment.services.UserService;
import com.sararoepe.courseenrollment.validator.UserValidator;

@Controller
public class MainController {
	private final UserService userService;
	private final CourseService courseService;
	private UserValidator userValidator;
	
	public MainController(UserService userService, CourseService courseService, UserValidator userValidator) {
		this.userService = userService;
		this.courseService = courseService;
		this.userValidator = userValidator;
	}

	
	@RequestMapping("/login")
    public String logReg(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model, @ModelAttribute("user") User user) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");

        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }

		return "loginReg.jsp";
    }
	
	@PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
    	userValidator.validate(user, result);
    	if (result.hasErrors()) {
            return "loginReg.jsp";
        }   
        userService.saveUser(user);
        return "redirect:/";
    }
	

	@RequestMapping(value = {"/", "/home"})
    public String home(Principal principal, Model model, @ModelAttribute("course") Course course) {
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));

        return "homePage.jsp";
    }
	
	@RequestMapping("/courses")
	public String allCourses(@ModelAttribute("course") Course course, Model model) {
		List<Course> courses = courseService.allCourses();
		model.addAttribute("courses", courses);
		return "courses.jsp";
	}
	
	@RequestMapping("/goback")
	public String goBack() {
		return "redirect:/home";
	}
	

	@RequestMapping(value="/addUserCourse/{id}", method=RequestMethod.GET)
	public String addUserToCourse(@PathVariable("id") Long id, @ModelAttribute("user") User user, Model model) {
		Course course = courseService.findCourseById(id);
		model.addAttribute("course", course);

		model.addAttribute("users", userService.allUsers());
		model.addAttribute("course", courseService.findCourseById(id));
		model.addAttribute("courseUsers", userService.getUsersOfCourse(course));
		model.addAttribute("notCourseUsers", userService.getUsersNotOfCourse(course));
		return "showClass.jsp";
	}
	
	@RequestMapping(value="/addUserToCourse/{id}", method=RequestMethod.POST)
	public String updateCourse(@PathVariable("id") Long id, @RequestParam(value="username") Long userId, Model model) {
		Course course = courseService.findCourseById(id);
		User user = userService.findUserById(userId);
		List<Course> courses = user.getCourses();
		if(!courses.contains(course)) {
			course.getUsers().add(user);
			
			courseService.updateCourse(course);
			}	
			model.addAttribute("user", userService.findUserById(userId));
			model.addAttribute("courses", courseService.allCourses());
			return "redirect:/courses";
		
//		return "redirect:/courses/" + id;
	}
//	@PostMapping("/products/{id}")
//	public String updateProduct(@PathVariable("id") Long id, @RequestParam(value = "name") Long categoryId, Model model) {
//		Product product = productService.findProductById(id);
//		Category category = categoryService.findCategoryById(categoryId);
//		List<Category> categories = product.getCategories();
//		if(!categories.contains(category)) {
//			categories.add(category);
//			product.setCategories(categories);
//			productService.updateProduct(product);
//		}
//		
//		return "redirect:/products/" + id;
//	}
	
	

}
