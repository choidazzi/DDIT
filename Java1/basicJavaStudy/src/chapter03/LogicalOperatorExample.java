package chapter03;

public class LogicalOperatorExample {
	public static void main(String[] args) {
		int charCode = 'A';
		
		//논리곱 AND
		if ((charCode >= 65) & (charCode <= 90)) {
			System.out.println("대문자군요.");
		}
		//& : 두개 다 비교 -ex. 두개 다 false => false
		if ((charCode >= 97) && (charCode <= 122)) {
			System.out.println("소문자군요.");
		}
		//&& : 하나만 비교 (더 효율적) -ex. 하나라도 false면 false 값 산출
		if (!(charCode < 48) && !(charCode >57)) {
			System.out.println("0~9 숫자군요.");
		}
		
		int value = 6;
		
		//논리합 OR (=비트연산자)
		if ((value%2 == 0) | (value%3 == 0)) {
			System.out.println("2 또는 3의 배수군요.");
		}
		//| : 두개 다 비교 
		if ((value%2 == 0) || (value%3 == 0)) {
			System.out.println("2 또는 3의 배수군요.");
		}
		//|| : 하나만 비교 (더 효율적) -ex. 하나라도 true면 true 값 산출
		// ^ : 배타적 논리합. 두 개의 값이 같으면 false, 다르면 true
	}
}
