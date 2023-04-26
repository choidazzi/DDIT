package Exercise.Exercise230314;

import java.util.Scanner;

public class exercise41 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("삼각형의 첫번째 변의 길이를 입력하세요:");
		int first = scanner.nextInt();
		System.out.print("삼각형의 두번째 변의 길이를 입력하세요:");
		int second = scanner.nextInt();
		System.out.print("삼각형의 세번째 변의 길이를 입력하세요:");
		int third = scanner.nextInt();
		int maxNumber = 0;
		//제일 큰 변 구하기 
		if(first >= second && first >= third) {
			maxNumber = first;
		} else if(second >= first && second >= third) {
			maxNumber = second;
		} else if(third >= first && third >= third) {
			maxNumber = third;
		} 
		//삼각형 여부
		if(maxNumber < first + second + third - maxNumber) {
			System.out.println("삼각형을 만들 수 있습니다.");
		} else {
			System.out.println("삼각형을 만들 수 없습니다.");
		}
	}
}
