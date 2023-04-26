package chapter10;

public class CompiletimeExceptionExample {
	public static void main(String[] args) throws ClassNotFoundException{
		//1. try catch (finally) => 예외를 직접 처리하는 방식 
		try {
			Class.forName("java.lang.String");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	// 2.throws 예와 => 예외를 직접 처리하지 않고 떠넘기는 방식
	public static void findClass() throws ClassNotFoundException {
		Class clazz = Class.forName("java.lang.String2");
	}
}
