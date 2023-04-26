package chapter06.package02;

import chapter06.package01.A;

public class C {
	public C() {
		A a = new A();
		a.field1 = 1;
//		a.field2 = 1; //default 필드 접근 불가 compile error 
//		a.field3 = 1;  private 필드 접근 불가 compile error
		
		a.method1();
//		a.method2(); default 필드 접근 불가 compile error
//		a.method3(); private 필드 접근 불가 compile error
	}
}
