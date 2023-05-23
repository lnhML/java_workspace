package com.mysite.sbb.answer;

import com.mysite.sbb.question.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@RequiredArgsConstructor 
@Service

public class AnswerService {
	private final AnswerRepository answerRepository; 
	
	// 답변 생성을 위한 create메서드 => 입력으로 받은 question, content룰 answer객체에 저장 
	public void create(Question question, String content) {
		Answer answer = new Answer(); 
		answer.setContent(content);
		answer.setCreateDate(LocalDateTime. now()); 
		answer.setQuestion(question);
		this.answerRepository.save(answer);
	}
	

}
