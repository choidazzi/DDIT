package chapter10;

public class ThrowsExample2 {
	public static void main(String[] args) {
	//throws => 메소드를 호출한 곳으로 예외를 던진다.
	//throws Exception => "method"가 Exception 예외를 던진다.
	
	try {
		Class.forName("");
		//throw => 예외를 개발자가 만든다.
		//I throw new Exception(); => "개발자"가 예외를 만들어서 던진다. 
		throw new Exception();
	} catch (Exception e) {
		e.printStackTrace(); //에러에 대한 정보를 콘솔 창에 print 
		System.err.println("사용 중 에러가 발생했습니다. 관리자에게 문의 하세요.");
	}
	}

	private static void findClass() throws ClassNotFoundException {
		Class.forName("");
	}
}
