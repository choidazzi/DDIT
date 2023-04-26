package chapter06.package01;

public class A {
	//필드
	public int field1; // public 접근제한 
	int field2; //default 접근제한 
	private int field3; // private 접근제한
	
	public A() {
		field1 = 1;
		field2 = 1;
		field3 = 1;
		
		method1();
		method2();
		method3();
	} //클래스 내부일 경우 접근 제한자의 영향울 받지 않음 
	
	public void method1() {}
	void method2() {}
	private void method3() {}
	
}
