package com.pmj.spring03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.pmj.spring03.Car;

@SpringBootApplication
public class Spring03Application {

	// 정적 메서드에서는 같은 클래스 내 일반 메서드를 호출할 수 없음
	// 정적 메서드는 같은 클래스 내 정적 메서드만 호출할 수 있음
	// 다른 클래스는 상관이 없음
	// 정적 메서드는 클래스 인스턴스 생성없이(new) 바로 호출 가능
	public static void main(String[] args) {
		SpringApplication.run(Spring03Application.class, args);

		// 메서드
		//printHello();
		sayHi();

		System.out.println("75는 짝수?" + isTrue(75));

		// Car클래스 인스턴스 생성
		Car mycar = new Car();
		mycar.name = "아이오닉";
		mycar.year = 2018;

		mycar.printCarName();
		mycar.printCarName("흰색");
		mycar.printCarName("테슬라","벤츠", "페라리", "포르쉐"); // 가변인자 메서드 호출

		// mycar.printYear();
		Car.printYear(); // 클래스 인스턴스 생성없이 바로 사용가능

		int term = mycar.calcYear(2025);
		System.out.println(term + "년 동안 사용");
	}

	public void printHello(){
		System.out.println("Hello. Spring");
	}

	public static void sayHi(){
		System.out.println("Hi, Spring");
	}

	public static boolean isTrue(int num){
		if(num % 2 == 0){
			return true;
		}else{
			return false;
		}
	}
}

/* 
public class Car{
	String name;
	int year;
	String company;

	public void printCarName(){
		System.out.println("차 이름은" + name);
	}

	// 메서드 오버로딩
	public void printCarName(String point){
		System.out.println("차 이름은" + name);
	}

	// 가변인자
	public void printCarName(String...name){
		for(String n : name){
			System.out.println(n);
		}
	}

	int calcYear(int currYear){
		return currYear - year;
	}
}*/