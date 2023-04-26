package chapter10;

public class TryCatchFinallyRunTimeExceptionExample {
	public static void main(String[] args) {
		//두 숫자를 입력받아 덧셈을 한 값을 출력하는 프로그램 
		String data1;
		String data2;
		try { // option + command + z 
			data1 = args[0];
			data2 = args[1];
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("실행 매개값의 수가 부족합니다.");
			return;
		}
		
		try {
			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);
			int result = value1 + value2;
			System.out.println(value1 + " + " +value2  + "=" + result);
		} catch (NumberFormatException e) {
			System.out.println("숫자로 변환할 수 없습니다.");
		} finally {
			System.out.println("다시 실행하세요.");
		}
		
	}
}
