package com.pmj.spring01;

// interface는 implements 키워드를 사용해야함, 내가 받아서 구현해야될 약속들이 들어있음
public class Dog implements Animal{
    private String name;
    private int age;

    // 생성자
    Dog(String name, int age){
        this.name = name;
        this.age = age;

    }

    @Override // 이제부터 오버라이딩 할거야 - 부모 클래스의 메서드를 자식 클래스가 재정의하는 것
    public void cry() {
        // throw new UnsupportedOperationException("Unimplemented method 'cry'");
        System.out.println(this.age + "살" + this.name + "이(가) 웁니다. 멍멍!");
    }

    public void introduce(){
        System.out.println("저는 강아지에요");
    }

}
