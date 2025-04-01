package com.pmj.spring02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner; // 콘솔 입력받을 클래스 선언

@SpringBootApplication
public class Spring02Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring02Application.class, args);

		Scanner scan = new Scanner(System.in);

		System.out.println(">> 아이디 입력: ");
		String userid = scan.next();
		System.out.println(">> 패스워드 입력: ");
		String passpw = scan.next();

		System.out.println("입력받은 아이디 --> " + userid);
		System.out.println("입력받은 패스워드 --> " + passpw);

		if(userid.equals("jju") && passpw.equals("12345")){
			System.out.println("로그인 성공!");
		} else{
			System.out.println("로그인 실패! 아이디 또는 비밀번호 오류");
		}

		switch (passpw) {
			case "12345":
				System.out.println("패스워드 변경요망");
				break;
			case "12":
				System.out.println("패스워드 오류!");
				break;
			case "34":
				System.out.println("패스워드 오류2!");
				break;
			default:
				System.out.println("전체 오류!!");
				break;
		}

		// 3항 연산 연습
		String result = (passpw.equals("12345")) ? "메인화면진입" : "로그인화면으로";
		System.out.println("다음화면 >> " + result);
	}

}
