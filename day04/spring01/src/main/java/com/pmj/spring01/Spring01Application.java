package com.pmj.spring01;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring01Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring01Application.class, args);

		// 날짜타입
		LocalDate date1 = LocalDate.now();
		System.out.println(date1);

		LocalDate date2 = LocalDate.of(2027,7,9);
		System.out.println(date2);

		// Date Formatting
		String date3 = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		System.out.println(date3);

		System.out.println(LocalDate.now().getYear()); 		 // 2025
		System.out.println(LocalDate.now().getMonth());      // APRIL
		System.out.println(LocalDate.now().getMonthValue()); // 4
		System.out.println(LocalDate.now().getDayOfMonth()); // 4
		System.out.println(LocalDate.now().getDayOfYear());  // 94
		System.out.println(LocalDate.now().getDayOfWeek());  // FRIDAY

		// 날짜 차이
		System.out.println(LocalDate.now().plusDays(2));		 // 2025-04-06
		System.out.println(LocalTime.now().minusHours(2)); //07:50:41.667778600
	}

}
