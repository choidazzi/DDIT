package exercise;

import java.util.Iterator;

//숫자로 이루어진 문자열 str 이 있을 때, 각 자리의 합을 더한 결과를 출력하는 코드를 완성하라. 
//만일 문자열이 "12345"라면, ‘1+2+3+4+5’의 결과인 15를 출력이 출력되 어야 한다. 
//[Hint] String클래스의 charAt(정수)을 사용 => ex str.charAt(2) 문자열의 2번째 자리를 추출. =>char type
public class exercise49 {
	public static void main(String[] args) {
		String str = "12345";
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			sum += str.charAt(i) - '0';
		}
		System.out.println(sum);
	}
}
