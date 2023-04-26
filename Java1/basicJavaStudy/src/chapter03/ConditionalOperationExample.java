package chapter03;

import java.util.Scanner;

public class ConditionalOperationExample {
	public static void main(String[] args) throws Exception{
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("점수를 입력하세요: ");
		
		int score = Integer.parseInt(scanner.nextLine()) ;
		char grade = score > 90 ? 'A' : score > 80 ? 'B' : 'C'; //괄호 안해도 됨.
		
		System.out.println(score + "점은" + grade + "등급입니다.");
		}
	} //다시 공부...!
