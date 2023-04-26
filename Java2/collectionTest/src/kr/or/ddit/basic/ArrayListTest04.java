package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 문제) 5명의 별명을 입력 받아 ArrayList에 저장하고 저장된 별명들 중
 * 	       길이가 제일 긴 별명을 출력하시오.
 * 		   (단, 각 별명의 길이가 같은 것을 입력할 수 있다.)
 * */
public class ArrayListTest04 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<String> nameList = new ArrayList<>();
		System.out.println("5명의 별명을 입력하세요.");
		for (int i = 1; i <= 5; i++) {
			System.out.print(i + "번째 사람 별명: ");
			String name = scan.nextLine();
			nameList.add(name);
		}
		System.out.println();

		// 제일 긴 별명이 저장될 변수 선언 & 초기화
		String a = nameList.get(0);
		for (int i = 0; i < nameList.size(); i++) {
			if (nameList.get(i).length() > a.length()) {
				a = nameList.get(i);
			} 
		}
		System.out.println("제일 긴 별명들");
		for (int i = 0; i < nameList.size(); i++) {
			if (a.length() == nameList.get(i).length()) {
				System.out.println(nameList.get(i)); 
			}
		}
	}
}
