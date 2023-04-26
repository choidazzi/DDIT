package chapter07;

class A1{
	void autoPlay(I i) {
		i.play();
	}
}

interface I{
	public abstract void play();
}

class B1 implements I{
	@Override
	public void play() {
		System.out.println("Play in B class");
	}
}

class C implements I{
	@Override
	public void play() {
		System.out.println("Play in C class");
	}
	
}
class InterfaceTest2 {
	public static void main(String[] args) {
		A1 a = new A1();
		a.autoPlay(new B1());
		a.autoPlay(new C());
	}
}
