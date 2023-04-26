package Exercise.test.oneToFive;

import java.util.Scanner;

public class t44 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("철");
		String c = sc.nextLine();
		System.out.println("영");
		String y = sc.nextLine();
		
		if (c.equals(y)) {
			System.out.println("비김");
		} else if (c.equals("바위")&&y.equals("보") 
					|| c.equals("가위")&&y.equals("바위")
					|| c.equals("보")&&y.equals("가위")) {
			System.out.println("영희승");
		} else {
			System.out.println("철수 ");
		}
	}
}
