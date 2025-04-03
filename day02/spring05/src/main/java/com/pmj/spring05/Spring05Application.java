package com.pmj.spring05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring05Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring05Application.class, args);

		// 상속
		Dog ppoppy = new Dog();
		ppoppy.setName("뽀삐");
		ppoppy.cry();
		//ppoppy.age = -19;
		ppoppy.setAge(450);
		System.out.println("뽀삐의 나이는" + ppoppy.getAge() + "살");
		
		Cat Kitty = new Cat();
		Kitty.setName("키티");
		Kitty.cry();
		//Kitty.age = 3;
		Kitty.setAge(12);
		System.out.println("키티의 나이는" + Kitty.getAge() + "살");

		Dog choonsam = new Dog();
		choonsam.setName("춘삼");
		choonsam.cry();
		System.out.println(choonsam.getClass().getSimpleName()); // class com.pmj.spring05.Dog // Dog // Object 클래스 메서드를 사용가능


	}

}
