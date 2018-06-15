package com.sararoepe.dojooverflow.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sararoepe.dojooverflow.models.Answer;
import com.sararoepe.dojooverflow.models.Question;
import com.sararoepe.dojooverflow.models.Tag;
import com.sararoepe.dojooverflow.repositories.AnswerRepository;
import com.sararoepe.dojooverflow.repositories.QuestionRepository;
import com.sararoepe.dojooverflow.repositories.TagRepository;

@Service
public class MainService {

	private QuestionRepository questionRepository;
	private TagRepository tagRepository;
	private AnswerRepository answerRepository;
	
	public MainService(QuestionRepository questionRepository, TagRepository tagRepository, AnswerRepository answerRepository) {
		this.questionRepository = questionRepository;
		this.tagRepository = tagRepository;
		this.answerRepository = answerRepository;
	}
	
	public List<Question> allQuestions(){
		return questionRepository.findAll();
	}
	
	public List<Tag> allTags(){
		return (List<Tag>) tagRepository.findAll();
	}
	
	public List<Answer> allAnswers(){
		return answerRepository.findAll();
	}
	
	public Question findQuestionById(Long id){
		return questionRepository.findOne(id);
	}
	
	public Tag findTagById(Long id){
		return tagRepository.findOne(id);
	}
	
	public Answer findAnswerById(Long id) {
		return answerRepository.findOne(id);
	}

	public List<Tag> returnList(String tags){
		String list = tags.toLowerCase();
		List<String> tagList = Arrays.asList(list.split("\\s*,\\s*"));
		if(tagList.size() > 3) {
			return null;
		} else {
			List<Tag> qTags = new ArrayList<Tag>();
			for(int i = 0; i < tagList.size(); i++) {
				Tag search = tagRepository.findTagBySubject(tagList.get(i));
				if(search == null) {
					Tag newTag = new Tag();
					newTag.setSubject(tagList.get(i));
					tagRepository.save(newTag);
					qTags.add(newTag);
				} else {
					qTags.add(search);
				}
			}
			return qTags;
		}
		
	}	
	
	public void addQuestion(Question question) {
		questionRepository.save(question);
	}
	
	public void addTag(Tag tag) {
		tagRepository.save(tag);
	}
	
	public void addAnswer(Answer answer) {
		answerRepository.save(answer);
	}
	
	public List<Question> getQuestionsOfTag(Tag tag){
		return questionRepository.findAllByTagsContaining(tag);
	}
	public List<Question> getQuestionsNotOfTag(Tag tag){
		return questionRepository.findAllByTagsNotContaining(tag);
	}
	
	public void answerQuestion(Question question) {
		questionRepository.save(question);
	}
	

	
	
	
}
