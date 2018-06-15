package com.sararoepe.dojooverflow.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sararoepe.dojooverflow.models.Answer;
import com.sararoepe.dojooverflow.models.Question;
import com.sararoepe.dojooverflow.models.Tag;
import com.sararoepe.dojooverflow.services.MainService;

@Controller
public class MainController {
	
	private final MainService mainService;
	public MainController(MainService mainService) {
		this.mainService = mainService;
	}
	
	@RequestMapping("/")
	public String redirectDash() {
		return "redirect:/questions";
	}
	
	@RequestMapping("/questions")
	public String dashboard(Model model) {
		List<Question> questions = mainService.allQuestions();
		model.addAttribute("questions", questions);
		return "dashboard.jsp";
	}
	
	@RequestMapping("/questions/new")
	public String newQuestion(@ModelAttribute("question") Question question) {	
		return "newQuestion.jsp";
	}
	
	@PostMapping("/questions/new")
	public String addQuestion(RedirectAttributes redirectAttributes, Model model, @ModelAttribute("error") String error, @RequestParam("tagStr") String tags, @Valid @ModelAttribute("questionInfo") Question question, BindingResult result) {
		if(result.hasErrors()) {
			model.addAttribute("error", error);
			return "redirect:/questions/new";
		} else {
			List<Tag> qTags = mainService.returnList(tags);
			if(qTags == null) {
				redirectAttributes.addFlashAttribute("error", "You can only add up to 3 tags!");
				return "redirect:/questions/new";
			} else {
				question.setTags(qTags);
				mainService.addQuestion(question);	
				Long id = question.getId();
				return "redirect:/questions/" + id;
			}
		}
	}
	
	@GetMapping("/questions/{id}")
	public String showOne(@ModelAttribute("answer") Answer answer, @PathVariable("id") Long id, Model model) {
		Question question = mainService.findQuestionById(id);
		model.addAttribute("question", question);
		model.addAttribute("questions", mainService.allQuestions());
		model.addAttribute("answers", mainService.allAnswers());
		return "showOne.jsp";
	}
	
	@RequestMapping("/{question_id}/addAnswer")
	public String answerQuestion(@Valid @ModelAttribute("answer") Answer answer, @PathVariable("question_id") Long id, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "redirect:/questions";
		} else {
			Question question = mainService.findQuestionById(id);
			answer.setQuestion(question);
			mainService.addAnswer(answer);
			
			return "redirect:/questions/" + id;	
		}
	}
	
	
}