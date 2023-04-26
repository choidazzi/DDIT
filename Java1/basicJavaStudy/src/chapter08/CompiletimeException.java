package chapter08;

public class CompiletimeException {
	public static void main(String[] args) throws ClassNotFoundException {
//		Class.forName("java.lang.String");  //ClassNotFoundException --예외처리 해야
		//1. try catch(finally) => 예외를 직접 처리하는 방식 
		try {
			Class.forName("java.lang.String"); //실행 시도 하고 
		} catch (ClassNotFoundException e) { //실행 시도 중 에러가 발생하면 아래의 실행문 실행 
			
		}
		//2. throws 예외 => 예외를 직접 처리하지 않고 떠넘기는 방식 //위에 throws ClassNotFoundException
		Class.forName("java.lang.String");
		
		
		System.out.println(args[0]); //RuntimeException 발생 
		
	}
}
