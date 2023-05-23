package com.mysite.sbb.answer;
import java.time.LocalDateTime;

import com.mysite.sbb.question.Question;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne; 

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 

@Entity 
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	@Column(columnDefinition = "TEXT")
	private String content;

	private LocalDateTime createDate;
	
	// 답변 엔티티에서 질문 엔티티를 참조하기 위해 question속성을 추가 
	// e.g. 답변객체를 통해 질문 객체의 제목을 알고 싶은 경우 answer.getQuestion().getSubject()처럼 접근 가능 
	//단, 속성 추가와 더불어 질문엔티티와 연결된 속성이라는 걸 명시적으로 표시해야함 => @ManyToOne
	
	@ManyToOne
	private Question question; 
	// 답변 => 하나의 질문에 여러개 달릴 수 있는 구조(답변: Many, 질문: One) => 즉, @ManyToOne은 N:1 관계
	// @ManyToOne 애너테이션을 설정 => DB에 ForeignKey 관계가 생성됨 
	
	//참고 
	//질문과 답변은 1:N의 관계 => @OneToMany
	// Question 하나에 Answer는 여러개이므로 Question 엔티티에 추가할 답변의 속성은 List 형태로 구성
	//=> Question.java에 구현 
}
