package com.mysite.sbb;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller //annotation을 통해 MainController가 스프링부트의 컨트롤러가 됨. 
public class MainController {
	@GetMapping("/sbb")   //요청된 URL과의 매핑을 담당=> 서버에 요청하면 스프링부트는 요청페이지와 매핑되는 메서드를 컨트롤러를 대상으로찾는다. 
	@ResponseBody// ResponseBody =>URL요청에 대한 응답으로 문자열을 리턴하라는 의미 
	public String index() { //문자열로 응답하기 위해 index 함수의 리턴 값을 string으로 변경 
		return "HI, WELCOME TO SBB"; 
	}
	
	@GetMapping("/")
	public String root() {
		return "redirect:/question/list";  ///question/list URL로 페이지를 리다이렉트 하라는 명령어
		//redirect:<URL> - URL로 리다이렉트 (리다이렉트는 완전히 새로운 URL로 요청이 된다.)
		//forward:<URL> - URL로 포워드 (포워드는 기존 요청 값들이 유지된 상태로 URL이 전환된다.)
	}

}

//MainController ->QuestionController -> questionRepository ->question_list.html 
//=> MainController ->QuestionController -> QuestionService -> questionRepository ->question_list.html

