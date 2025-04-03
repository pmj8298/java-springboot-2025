package com.pmj.spring05;
// import java.lang.Object;

// 부모클래스 동물
public class Animal {       // public 어디서든지 불러서 사용가능
    // String name;         // default
    // public String name;  // public
    private String name; // private
    // protected String name; // 같은 패키지 내 또는 자식 내에서 사용 가능
    private int age;                // 동물의 나이 ,같은 패키지 내에서는 default나 private나 별 차이 없음
    
    public int getAge() {
        return age;
    }

    // 정확한 캡슐화를 위해서 필터링
    public void setAge(int age) {
        // 음수나 너무 큰 수가 들어가지 않도록 막아줌
        if (age < 0) { // 음수 막기
            this.age = 1;
        }else if (age > 20) { // 너무 큰 수 막기
            this.age = 20;
        }else{
            this.age = age;
        }
    }

    void setName(String name){
        this.name = name;
    }

    String getName(){
        return this.name;
    }

    void cry(){
        System.out.println(this.name + "가(이) 웁니다.");
    }
}
