package com.pmj.spring04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring04Application {


	public static void main(String[] args) {
		SpringApplication.run(Spring04Application.class, args);

		// 람다식
		// 1. 일반방식
		Spring04Application app = new Spring04Application();
		System.out.println(app.helloJava());

		// 2. 람다방식
		myFuncInterFace fi = () -> {System.out.println("Hello, Java! 람다호출");};
		fi.printHello();

		myCalc calc = (x ,y) -> {return x + y;};
		int result = calc.add(100, 55);
		System.out.println(result);

		// Stream API
		// 1. 기존방식
		List<String> avengers = Arrays.asList("Ironman", "Captin America", "SpiderMan", "Hulk", "AntMan");

		// 정렬
		Collections.sort(avengers);
		System.out.println(avengers);

		for(String hero : avengers){
			System.out.println(hero);
		}
		// 단점은 출력 시 반복문을 써야하고, 정렬 후 원본 순서가 사라짐
		
		// 2. Stream API 사용방식
		System.out.println("스트림API");
		avengers = Arrays.asList("Ironman", "Captin America", "SpiderMan", "Hulk", "AntMan");

		Stream<String> avengersStream = avengers.stream(); //
		avengersStream.sorted().forEach(System.out::println);
		System.out.println(avengers);

		// Stream API 실습
		List<String> originList = Arrays.asList("a1","c2","b3","c1","a1","b1");

		// c로 시작하는 요소만 뽑아서 대문자로 변경하고 정렬해서 갯수를 출력하시오
		List<String> copyList = new ArrayList<>(originList);

		System.out.println(originList);
		System.out.println(copyList);
		// c로 시작하는 요소만 뽑아서, 대문자로 변경하고, 정렬해서, 갯수를 출력하시오

		// 기존 방식으로 처리
		// 1. 각 요소에서 c로 시작하는 것만 추출
		List<String> lastList = new ArrayList<>();
		for(String elmt : copyList){
			if(elmt.startsWith("c")){
				lastList.add(elmt);
			}
		}
		// 2. 대문자변경
		for(int i = 0; i < lastList.size(); i++){
			lastList.set(i, lastList.get(i).toUpperCase());
		}
		// 3. 정렬
		Collections.sort(lastList);
		System.out.println(lastList.size());

		// StreamApi를 사용하면
		System.out.println(originList.stream().filter(s -> s.startsWith("c")).map(String::toUpperCase).sorted().toList().size());


	}

	// 일반 메서드 호출
	public String helloJava(){
		return "Hello, Java! 일반호출";
	}

	@FunctionalInterface // 함수형 인터페이스로 지칭
	public interface myFuncInterFace {
		void printHello();
	}

	public interface myCalc {
		int add(int x, int y);
		//int sub(int x, int y); // 두개는 안됨
		
	}
}
