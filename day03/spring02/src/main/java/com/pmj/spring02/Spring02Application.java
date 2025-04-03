package com.pmj.spring02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring02Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring02Application.class, args);

		// 예외처리
		// int result = 17/0;
		// System.out.println(result); // Exception in thread "main" java.lang.ArithmeticException: / by zero at com.pmj.spring02.Spring02Application.main(Spring02Application.java:13)

		int result = 0;
		try{
			result = 17 / 0;
			//int result = 17 / 0; // result는 try 문 안에 들어있는 지역변수라서 아래에서 사용불가
		} catch(ArithmeticException e){
			System.out.println(e);
		}
		System.out.println(result);

		String[] names = {"mj","hs","js"};
		//System.out.println(names[3]); // Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException

		try{
			System.out.println(names[3]);
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println(e);
		}

		System.out.println("프로그램 종료!");
	}

}
