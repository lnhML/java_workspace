package com.mysite.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue; 

import java.util.List;
import java.util.Optional; 

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.answer.AnswerRepository;

@SpringBootTest
class SbbApplicationTests {

    @Autowired
    private QuestionRepository questionRepository;
    
    @Autowired
    private AnswerRepository answerRepository; // 답변 데이터 처리를 위해 답변 레포지토리 필요 =>   @Autowired로 주입 
    
    @Transactional
    @Test
    void testJpa() {  

    	//질문 객체로 부터 답변 리스트를 구하는 테스트 코드 
    	//=> 이렇게 하면 Question객체의 DB세션이 끊어짐 그 후 실행되는 q.getAnswerList()는 세션이 종료되어 오류발생(@Transactional=> 없이 실행하는 경우) 
    	//=> 실제 서버 JPA프로그램 실행 시 DB세션이 종료되지 않기때문에 테스트 코드에서만 발생하는 문제 
    	//=> 이 경우, @Transactional을 사용하면 매서드가 종료될때까지 db세션이 유지됨
//    	Optional<Question> oq = this.questionRepository.findById(2);
//        assertTrue(oq.isPresent());
//        Question q = oq.get();
//
//        List<Answer> answerList = q.getAnswerList();
//
//        assertEquals(1, answerList.size());
//        assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
    	
    	
    	//답변 조회 -> id값이 1인 답변 조회, 그 답변의 질문 id값이 2인지 확인 
//    	Optional<Answer> oa = this.answerRepository.findById(1);
//    	assertTrue(oa.isPresent());
//    	Answer a = oa.get();
//    	assertEquals(2, a.getQuestion().getId());
    	
    	
    	//답변 생성 후 저장 
    	//1. 답변 데이터 처리를 위해 답변 리포지터리를 @Autowired로 주입
    	//2. 질문데이터 필요 => id가 2인 질문 데이터 값존재여부 확인 후 가져오기  
    	//3. 답변 내용 set
    	//4. Answer엕티티의 question속성에 가져온 질문 데이터 대입=> 어떤 질문에 해당하는 잡변인지 연결할 목적으로 question속성 필요  
    	
    	//
    	// 답변 데이터 처리를 위해 id가 2인 질문 데이터를 우선적으로 가져오기 => 
//    	Optional<Question> oq =this.questionRepository.findById(2);
//    	assertTrue(oq.isPresent());
//    	Question q = oq.get();
//    	
//    	Answer a = new Answer(); 
//    	a.setContent("네 자동으로 생성됩니다.");
//    	a.setQuestion(q); //어떤 질문의 답변인지 알아야하니 question객페 필요 
//    	a.setCreateDate(LocalDateTime.now());
//    	this.answerRepository.save(a);   	
    	
    	//데이터 삭제 
//    	assertEquals(2, this.questionRepository.count());
//    	Optional<Question> oq = this.questionRepository.findById(1);
//    	assertTrue(oq.isPresent());
//    	Question q = oq.get();
//    	this.questionRepository.delete(q);
//    	assertEquals(1, this.questionRepository.count());   	
    	
    	
    	//데이터 수정 
//    	Optional<Question> oq = this.questionRepository.findById(1);
//    	assertTrue(oq.isPresent());
//    	Question q = oq.get();
//    	q.setSubject("수정된 제목");
//    	this.questionRepository.save(q);
    	
    	
    	// 제목에 특정 문자열이 포함된 경우 데이터를 조회 
//    	List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
//    	Question q = qList.get(0);
//    	assertEquals("sbb가 무엇인가요?", q.getSubject());
    	
    	//Question엔티티의 Subject값으로 데이터조회 (QuestionRepository 인터페이스에 findBySubject메서드 선언 필수)
    	//구현하지 않고 선언만 해도 잘 되는 이유:  
    	//==>JpaRepository를 상속한 QuestionRepository 객체가 생성될 때, DI에 의해 스프링이 자동으로 QuestionRepository객체를 생성함. (이때 프록시 패턴이 사용됨)
    	//리포지토리 객체의 매서드가 실행될 때 JPA가 해당 메서드명을 분석해서 쿼리를 만들고 실행하는 것 
    	
    	//즉, findBy + 엔티티의 속성명(예:findBySubject)과 같은 리포지터리 메서드를 작성하면 해당 속성의 값으로 데이터를 조회가능
   	
//    	Question q = this.questionRepository.findBySubjectAndContent("스프링부트 모델 질문입니다.", "id는 자동으로 생성되나요?");
//    	assertEquals(2,q.getId());
    	
    	
    	//Question 엔티티의 id값으로 데이터 조회 => findById: id값으로 데이터 조회하는 메서드(return type => question이 아닌 optional)
    	//optional: null을 유연하게 처리하기위해 사용하는 클래스
//    	Optional<Question> oq = this.questionRepository.findById(1);
//    	if(oq.isPresent()) { //NULL인지 확인 
//    		Question q = oq.get(); 
//    		assertEquals("sbb가 무엇인가요?", q.getSubject()); //get으로 실제 QUESTION객체의 값을 얻어야함. 
//    	}
//    	
    	
    	//Question테이블에 저장된 모든 데이터 조회 
//    	List<Question> all = this.questionRepository.findAll(); 
//    	assertEquals(2, all.size());
//    	
//    	Question q = all.get(0);
//    	assertEquals("sbb가 무엇인가요?", q.getSubject());
    	
    	//데이터 저장 
//        Question q1 = new Question();
//        q1.setSubject("sbb가 무엇인가요?");
//        q1.setContent("sbb에 대해서 알고 싶습니다.");
//        q1.setCreateDate(LocalDateTime.now());
//        this.questionRepository.save(q1);  // 첫번째 질문 저장
//
//        Question q2 = new Question();
//        q2.setSubject("스프링부트 모델 질문입니다.");
//        q2.setContent("id는 자동으로 생성되나요?");
//        q2.setCreateDate(LocalDateTime.now());
//        this.questionRepository.save(q2);  // 두번째 질문 저장
    }
}