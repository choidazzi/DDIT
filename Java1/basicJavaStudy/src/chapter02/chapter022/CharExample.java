package chapter02.chapter022;

public class CharExample {
	public static void main(String[] args) {
		char c1 = 'A'; //문자를 직접 저장
		char c2 = 65; //10진수로 저장
		char c3 = '\u0041'; //16진수로 저장
		
		char c4 = '가'; //문자를 직접 저장
		char c5 = 44032; //10진수로 저장
		char c6 = '\uAC00'; //16진수로 저장
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c5);
		System.out.println(c6);
	}
}
/*잘못된 코딩 예
 * char 타입은 문자리터럴 '' 을 저장가능하게 하는 변수(문자리터럴은 유니코드로 변환되어 저장)
 * 따라서
 * char v1 = "A" < 큰따옴표 사용하면 오류 
 * 이럴 경우,
 * String v1 = "A" or char v1 = 'A' 로 수정
 */
