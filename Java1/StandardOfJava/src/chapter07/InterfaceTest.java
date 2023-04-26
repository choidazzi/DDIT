package chapter07;

class A{	//User 
	public void methodA(B b) {
		b.methodB();
	}
}

class B{ //Provider 
	public void methodB() {
		System.out.println("methodB()");
	}
}

class InterfaceTest {
	public static void main(String args[]) {
		A a = new A();
		a.methodA(new B());
	}
}
