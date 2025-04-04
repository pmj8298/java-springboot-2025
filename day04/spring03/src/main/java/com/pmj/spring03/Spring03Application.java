package com.pmj.spring03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring03Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring03Application.class, args);

		// 컬렉션 프레임워크
		// List
		// ArrayList 는 순서가 있는 리스트, 중복을 허용함
		ArrayList<String> lst1 = new ArrayList<>();
		
		lst1.add("One");
		lst1.add("Two");
		lst1.add("Three");
		lst1.add("Four");

		System.out.println(lst1); // [One, Two, Three, Four]

		List<String> lst2 = new ArrayList<>();
		lst2.add("Five");
		lst2.add("Six");

		lst1.addAll(lst2); // 다른 리스트 추가
		lst1.set(0, "Zero");

		System.out.println(lst1); // [Zero, Two, Three, Four, Five, Six]
		System.out.println(lst1.get(5)); // Six 

		// 연결리스트
		List<Integer> lst3 = new LinkedList<>();
		lst3.add(10);
		lst3.add(20);
		lst3.add(30);
		System.out.println(lst3); // [10,20,30]

		// 정렬
		Collections.sort(lst1);
		System.out.println(lst1); // [Five, Four, Six, Three, Two, Zero]

		Collections.sort(lst1,Collections.reverseOrder());
		System.out.println(lst1); // [Zero, Two, Three, Six, Four, Five]
		// lst1.sort(); // 이 정렬 메서드 사용해도 무방

		System.out.println(lst1.contains("Three")); // true // lst1 리스트에 "Three"라는 문자열이 존재하는지 여부
		System.out.println(lst1.isEmpty()); // false // 리스트가 비어있는지 판별
		System.out.println(lst1.size()); // 6 // 배열 .length()와 동일
		lst1.remove(5);
		lst1.add("Four");
		System.out.println(lst1); // [Zero, Two, Three, Six, Four, Four]
		// ! 중요한 메서드
		// lst1.clear(); // 로직 중간에 함부로 쓰지 말 것! 프로그램 종료 시 리스트를 비우는 것!

		System.out.println("===========Vector=============");
		// Vector
		Vector<String> vec1 = new Vector<>(10); // 용량을 지정할 수 있음
		vec1.add("One");
		vec1.add("Three");
		System.out.println("백터의 크기 -> " + vec1.size()); // 2
		System.out.println("백터의 용량 -> " + vec1.capacity()); // 10

		// Set
		// Set은 순서가 없고 중복을 허용하지 않음
		System.out.println("===========set=============");
		Set<String> set1 = new HashSet<>();
		set1.add("One");
		set1.add("Two");
		set1.add("Three");
		set1.add("Four");
		set1.add("Two");
		
		System.out.println(set1); // [One, Four, Two, Three]
		
		System.out.println(set1.contains("Three")); // true
		System.out.println(set1.isEmpty());           // false
		System.out.println(set1.size()); 			  // 4
		set1.remove("Four"); // set은 순서가 없기 때문에 지울 요솟값을 입력해야 함함
		set1.add("Five");
		System.out.println(set1); // [Five, One, Two, Three]
		
		// Map
		// Map은 key-value 쌍을 저장하는 구조. put()으로 추가.
		System.out.println("===========Map=============");
		Map<String, String> phones = new HashMap<>();
		phones.put("010-4115-8522", "Galaxy S10");
		phones.put("010-1236-7415", "IPhone 14");
		phones.put("010-7536-9633", "Galaxy S24");
		phones.put("010-9516-7489", "Galaxy S23");

		System.out.println(phones); // {010-4115-8522=Galaxy S10, 010-1236-7415=IPhone 14, 010-7536-9633=Galaxy S24, 010-9516-7489=Galaxy S23}

		System.out.println(phones.get("010-9516-7489")); // Galaxy S23
		System.out.println(phones.values()); // [Galaxy S10, IPhone 14, Galaxy S24, Galaxy S23]
		System.out.println(phones.keySet()); // [010-4115-8522, 010-1236-7415, 010-7536-9633, 010-9516-7489]
		System.out.println(phones.containsKey("010-4115-8522")); // true
		System.out.println(phones.containsValue("Galaxy S24")); // true

		// 샘플 - 학생 네명의 국어, 영어, 수학, 미술, 체육 점수 합산 / 평균
		List<Integer> std1 = Arrays.asList(96,100,55,80,70);
		List<Integer> std2 = Arrays.asList(100,100,99,95,96);
		List<Integer> std3 = Arrays.asList(50,50,40,100,90);
		List<Integer> std4 = Arrays.asList(85,85,84,86,80);

		Map<String, List<Integer>> students = new HashMap<>();
		students.put("김가나", std1);
		students.put("김나나", std2);
		students.put("김다나", std3);
		students.put("김라나", std4);

		Scanner scan = new Scanner(System.in);
		System.out.print("# 성적 조회할 학생 이름 입력 > ");
		String inName = scan.next();

		int sum = 0;
		// 리스트, 배열, 셋, 맵 같은 컬렉션을 순회할 때 자주 사용
		for(int score : students.get(inName)){ // "김가나" -> [96,100,55,80,70]
			sum += score;
		}

		System.out.println(inName + "학생의 성적 총점: " + sum + ", 평균은" + sum/5);
	}

}
