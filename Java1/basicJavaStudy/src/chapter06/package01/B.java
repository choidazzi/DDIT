package chapter06.package01;

public class B {
	public B() {
		A a = new A();
		a.field1 = 1;
		a.field2 = 1;
//		a.field3 = 1; private 필드 접근 불가 compile error 
		
		a.method1();
		a.method2();
//		a.method3();  private 메소드 접근 불가 compile error
	}
}
