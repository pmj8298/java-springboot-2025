package com.pmj.spring05;

// Animal 부모클래스를 상속한 Dog 클래스
public class Dog extends Animal{
    
    // 부모 메서드 오버라이딩
    void cry(){
        // System.out.println(super.name + "가(이) 웁니다. 멍멍");
        System.out.println(super.getName() + "가(이) 웁니다. 멍멍"); // private String name;
    }
}
