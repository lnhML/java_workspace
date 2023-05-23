package com.mysite.sbb;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

// 속성에 final을 적용하고 @RequiredArgsConstructor어노테이션을 적용하면 해당 속성을 필요로하는 생성자가 롬북에 의해 자동으로 생성됨 
@RequiredArgsConstructor

@Getter
public class HelloLombok {
	//final이 없는 속성은 생성자에 포함되지 않음 => final적용시 @setter는 의미가 없으며 setter메서드도 사용불가 
	//final은 한번 설정한 값을 변경할 수 없게 하는 키워드 
	
    private final String hello; 
    private final int lombok;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok("헬로", 5);
        
        System.out.println(helloLombok.getHello());
        System.out.println(helloLombok.getLombok());
    }
}