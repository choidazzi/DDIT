package chapter08;

public class ExceptionEx9 {
	public static void main(String[] args) {
		try {
			Exception e = new Exception("고의로 발생시켰음"); //생성자에 String을 넣어주면 이 String이 Exception인스턴스에 메시지로 저장 
			throw e; // 예외를 발생시킴 
//			throw new Exception("고의로 발생시켰음"); 위의 두 줄을 줄여쓸 수 있음 
		} catch (Exception e) {
			System.out.println("에러메시지: " + e.getMessage()); //getMessage() 로 위에 저장된 String 출력 
			e.printStackTrace();
		}
		System.out.println("프로그램이 정상 종료되었음.");
	}
}
