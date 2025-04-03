package com.pmj.spring02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring02Application {

	public void sayNickName(String nickName) throws Exception{
		if(nickName.equals("애슐리")){
			throw new Exception("이 별명은 불가합니다"); // 자신이 예외를 처리하지 않음. 호출한 main메서드에 예외를 던짐
		}
		System.out.println("당신의 별명은" + nickName);
	}

	public static void main(String[] args) {
		SpringApplication.run(Spring02Application.class, args);

		// 예외처리: 0으로 나눌 수 없음음
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

		// 예외처리: 배열의 크기는 넘을 수 없음
		String[] names = {"mj","hs","js"};
		//System.out.println(names[3]); // Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException

		try{
			System.out.println(names[3]);
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println(e);
		}finally{
			System.out.println("예외발생 유무와 상관없이 실행"); // DB연결종료, 파일클로즈, 네트워크연결끊기
		}

		// 예외클래스 : null값은 여러가지(함수호출 등) 처리할 수 없음
		String name = null;
		// String[] names2 = name.split(" ");
		// System.out.println(names2[0]); // NullPointerException
		try{
			String[] names2 = name.split(" ");
			System.out.println(names2[0]);
		// }catch(NullPointerException e){
		}catch(Exception e){ // 무슨 예외인지 모를때는 이렇게 적어도 됨
			System.out.println(e.getMessage()); // e보다는 e.getMessage() 추천
		}


		// 예외처리 : 호출한 메서드에서 던진 예외를 받아서 처리
		Spring02Application app = new Spring02Application();
		// app.sayNickName("쑤쑤");
		try{
			app.sayNickName(" 애슐리");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}

		System.out.println("프로그램 종료!"); // 정상적으로 프로그램 종료
	}

}
