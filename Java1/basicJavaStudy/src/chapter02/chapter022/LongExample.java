package chapter02.chapter022;

public class LongExample {
	public static void main(String[] args) {
		long var1 = 10;
		long var2 = 20L;
		//long var3 = 10000000000; 컴파일 에러. 왜냐하면 리터럴은 int type(-21억~21억까지 표현 가능. L붙여야됨)
		long var4= 10000000000L;
		
		System.out.println(var1);
		System.out.println(var2);
		System.out.println(var4);
	}
}
