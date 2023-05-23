package com.mysite.sbb.question;

import java.util.List; 

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequestMapping("/question") 
@RequiredArgsConstructor // questionRepository 속성 => 롬복이 제공하는 어노테이션으로 final 이 붙은 속성을 포함하는 생성자를 자동 생성
@Controller 
public class QuestionController {
	
	private final QuestionService questionService;
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Question> questionList = this.questionService.getList(); 
		model.addAttribute("questionList", questionList);  //model 객체 => 자바 클래스와 템플릿 간의 연결고리 역할(Model에 값을 담아두면 템플릿에서 그 값을 사용가능)
		return "question_list"; 
	}
	
	
	@GetMapping(value= "/detail/{id}")  // 숫자 2처럼 변하는 id 값을 얻을 때에는 @PathVariable 애너테이션을 사용
	public String detatil(Model model, @PathVariable("id") Integer id) {
		Question question = this.questionService.getQuestion(id);
		model.addAttribute("question", question);
		
		
		return "question_detail";
	}
	

}
