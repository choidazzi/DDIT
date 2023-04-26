package chapter02.chapter021;

import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		Scanner  sc = new Scanner(System.in);
		System.out.print("첫번째: ");
		double num1 =   sc.nextDouble();
		System.out.print("두번째: ");
		double num2 =   sc.nextDouble();
		System.out.println("------------------------");
		System.out.print("결과: ");
		String r = (num2 ==0.0)? "무한대": String.valueOf(num1/num2);
		System.out.println(r);
	}
}
