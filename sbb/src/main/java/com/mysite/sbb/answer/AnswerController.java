package com.mysite.sbb.answer;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionService; 
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("/answer") 
@RequiredArgsConstructor
@Controller
public class AnswerController {
	private final QuestionService questionService;
	private final AnswerService answerService;
	
	//증록하는 거니까 get이 아니고 post 
	//아래 url을 post 가 아닌 get방식으로 요청하면 오류 발생 
	//@PostMapping(value= "/create/{id}")이렇게 해도 되고 @PostMapping("/create/{id}")이렇게 해도 됨
	// 입력한 content를 얻기 위해@RequestParam String content항목을 매개변수에 추가
	// question_detail.html 의 답변내용에 해당하는 속성명(name) content 
	@PostMapping(value= "/create/{id}")  // 숫자 2처럼 변하는 id 값을 얻을 때에는 @PathVariable 애너테이션을 사용
	public String createAnswer(Model model, @PathVariable("id") Integer id, @RequestParam String content) { 
		Question question = this.questionService.getQuestion(id);
	
		//답변 저장 
		this.answerService.create(question, content);
		return String.format("redirext:/question/detail/%s", id);
	}
	
}
