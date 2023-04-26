package chapter10;

public class TryCatchFinallyRunTimeExceptionExample2 {
	public static void main(String[] args) {
		// 두 숫자를 입력받아 덧셈을 한 값을 출력하는 프로그램
		// 다중 catch 문
		String data1;
		String data2;
		try { // option + command + z
			data1 = args[0];
			data2 = args[1];
			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);
			int result = value1 + value2;
			System.out.println(value1 + " + " + value2 + "=" + result);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("실행 매개값의 수가 부족합니다.");
			return;
		} catch (NumberFormatException e) {
			System.out.println("숫자로 변환할 수 없습니다.");
		} catch (Exception e) { // 모든 하위 타입을 잡을 수 있음
			e.printStackTrace();
		} finally { //반드시 실행 된다. 
			
		}
	}
}
