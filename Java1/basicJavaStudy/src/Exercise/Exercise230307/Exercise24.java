package Exercise.Exercise230307;

import java.util.Scanner;

public class Exercise24 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("원기둥 밑변의 반지름을 입력하시오.(단위: cm)");
		String radiusNumber1 = scanner.nextLine();
		
		System.out.print("원기둥 높이를 입력하시오.(단위: cm)");
		String radiusNumber2 = scanner.nextLine();
		
		double radius = Double.parseDouble(radiusNumber1);
		double height = Double.parseDouble(radiusNumber2);
		double area = radius * radius * Math.PI;
		double volumn = area * height;
		
		System.out.printf("원기둥 밑변의 넓이는 %17.14f㎠이고, 원기둥의 부피는 %17.13f㎤이다.", area, volumn);
		
	}
}

