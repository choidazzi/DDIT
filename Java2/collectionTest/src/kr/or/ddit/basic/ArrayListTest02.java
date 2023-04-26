package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 문제) 5명의 사람 이름을 입력 받아 ArrayList에 저장한 후에 
 * 			이 ArrayList에 저장된 이름들 중에서 '김'씨 성의 이름을 모두 출력하세요. 
 * 			(입력은 Scanner객체를 이용한다. )
 */
public class ArrayListTest02 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		ArrayList<String> nameList = new ArrayList<>();
		System.out.println("5명의 이름을 입력하세요.");
		for (int i = 1; i <= 5; i++) {
			System.out.print(i + "번째 사람 이름: ");
			String name = scan.nextLine();
			nameList.add(name);
		}

		System.out.println();
		System.out.println("김 씨 성을 가진 사람들: ");
		for (int i = 0; i < nameList.size(); i++) {
//			if (nameList.get(i).substring(0, 1).equals("김"))
//				System.out.println(nameList.get(i));
//			if (nameList.get(i).indexOf("김") == 0) 
//				System.out.println(nameList.get(i));
//			if (nameList.get(i).charAt(0) == '김')  //character 형을 반환하기 떄문에 == '김'
//				System.out.println(nameList.get(i));
			if (nameList.get(i).startsWith("김")) 
				System.out.println(nameList.get(i));
		}
	}
}
