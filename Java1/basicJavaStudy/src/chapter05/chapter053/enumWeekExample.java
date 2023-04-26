package chapter05.chapter053;

import java.util.Calendar;

public class enumWeekExample {
	public static void main(String[] args) {
		// 오늘의 요일을 알아내는 방법
		// 1. Date 객체
		// 2. Calendar 객체
		// 3. LoccalDate 객체
		Calendar calendar = Calendar.getInstance(); // 캘린더 객체 가져오기

		int week = calendar.get(Calendar.DAY_OF_WEEK); // 일(1) ~ 토(7)까지의 숫자를 리턴
		Week Today = null;

		switch (week) {
			case 1: {
			Today = Week.SUNDAY;
			break;
		}
			case 2: {
			Today = Week.MONDAY;
			break;
		}
			case 3: {
			Today = Week.TUESDAY;
			break;
		}
			case 4: {
			Today = Week.WEDNESDAY;
			break;
		}
			case 5: {
			Today = Week.THURSDAY;
			break;
		}
		case 6: {
			Today = Week.FRIDAY;
			break;
		}
		case 7: {
			Today = Week.SATURDAY;
			break;
		}
		}
		System.out.println("오늘 요일: " + Today.korName);

		if (Today == Week.SUNDAY) {
			System.out.println("일요에는 축구를 합니다.");
		} else {
			System.out.println("열심히 자바 공부를 합니다.");
		}
	}
}
