package Exercise.Exercise230309;

import java.util.Scanner;

public class Exercise32 {
	public static void main(String[] args) throws Exception{
		//2번 문제는 1번 또는(or) 2번 만족
		Scanner scanner = new Scanner(System.in);
		System.out.print("수도입니까?(수도: 1, 수도아님:0)");
		int city = Integer.parseInt(scanner.nextLine());
		
		System.out.print("총 인구는? (단위: 만)");
		int population = Integer.parseInt(scanner.nextLine());
		
		System.out.print("연 소득이 1억 이상인 인구는?(단위: 만)");
		int income = Integer.parseInt(scanner.nextLine());
		
		String metro = ((city == 1 && (population >= 100)) || (income >= 50)) ? "이 도시는 메트로 폴리스 입니다." : "이 도시는 메트로 폴리스가 아닙니다.";  
		System.out.println(metro);
	}
}
