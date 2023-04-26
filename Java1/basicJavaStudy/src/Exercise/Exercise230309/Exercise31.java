package Exercise.Exercise230309;

import java.util.Scanner;

public class Exercise31 {
	public static void main(String[] args) throws Exception{
		Scanner scanner = new Scanner(System.in);
		//큰수: ((a + b) + Math.abs(a - b)) / 2
		//작은수: ((a + b) - Math.abs(a - b)) / 2
		//Math.abs() : 절댓값
		System.out.print("첫 번째 숫자를 입력하세요: ");
		String strNum1 = scanner.nextLine();
		
		System.out.print("두 번째 숫자를 입력하세요: ");
		String strNum2 = scanner.nextLine();
		
		int a = Integer.parseInt(strNum1);
		int b = Integer.parseInt(strNum2);
		int largeNum = ((a + b) + Math.abs(a-b)) / 2;
		int smallNum = ((a + b) - Math.abs(a-b)) / 2;
		
		int share = largeNum / smallNum;
		int rest = largeNum % smallNum;
		
		System.out.printf("큰 수를 작은 수로 나눈 몫은 %d이고 나머지는 %d이다", share , rest);
	}
}
