package com.mysite.sbb.question;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
 

// 리포지터리의 메서드명은 데이터를 조회하는 쿼리문의 where 조건을 결정하는 역할
public interface QuestionRepository extends JpaRepository<Question, Integer>{
	Question findBySubject(String subject);	
	Question findBySubjectAndContent(String subject, String content);
	List<Question> findBySubjectLike(String subject); 
	

}
