package com.mysite.sbb;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //컨트롤러 어노테이션의 의미: HelloController 클래스가 컨트롤러의 기능을 수행한다
public class HelloController {
	//@GetMapping("/hello"): http://localhost:8080/hello URL 요청이 발생하면 hello 메서드가 실행됨(/hello URL과 hello 메서드를 매핑하는 역할)
	//Get 방식의 URL 요청은 GetMapping을 사용하고 Post 방식의 URL 요청은 PostMapping을 사용
	@GetMapping("/hello") 
    @ResponseBody// hello 메서드의 응답 결과가 문자열 그 자체임을 나타낸다
    public String hello() {
        return "Hello SBB";
    }
}
