package exercise;

import java.util.Random;

//1부터 6사이의 임의의 정수를 변수 value에 저장하는 코드를 완성하라.
public class exercise47 {
	public static void main(String[] args) {
		Random random = new Random();
		int randomNum = random.nextInt(6) + 1;
		System.out.println(randomNum);
	}
}
