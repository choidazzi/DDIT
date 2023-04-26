package kr.or.ddit.basic.args;

public class ArgsTest {
	/*
	 *   가변형 인수 => 메서드의 인수의 개수가 메서드를 호출할 때마다 다를 수 있을 때 사용한다.
	 * 
	 * - 가변형 인수는 메서드 안에서는 배열로 처리된다. 
	 * - 가변형 인수는 한가지 자료형만 사용할 수 있다.  
	 * */
	
	
	//매개변수로 받은 정수들의 합계를 구하는 메서드 만들기 
	// (이 정수들의 개수는 상황에 따라 다르다)
	
	//배열을 이용한 메서드 
	public int sumArr(int[] data) {
		int sum = 0;
		for (int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		return sum;
	}
	
	//가변형 인수를 이용한 메서드 
	public int sumArg(int...data) {
		int sum = 0;
		for (int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		return sum;
	}
	
	//가변형 인수와 일반적인 인수를 같이 사용할 경우에는 가변형 인수를 제일 뒤 쪽에 배치해야 한다. 
	public String sumArg2(String name, int... data) {
		int sum = 0;
		for (int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		return name + "씨의 합계: " + sum;
	}
	
	public static void main(String[] args) {
		ArgsTest at = new ArgsTest();
		
		//1,2,3,4,5를 sumArr() 메서드에 전달해서 결과를 출력하시오.
//		int[] numArr = {1,2,3,4,5};
		int[] numArr = new int[] {1,2,3,4,5};
		System.out.println("결과: " + at.sumArr(numArr));
		
		//100, 200, 300, 400
		System.out.println(at.sumArr(new int[] {100,200,300,400}));
		System.out.println("=================");

		System.out.println(at.sumArg(1,2,3,4,5));
		System.out.println(at.sumArg(100,200,300,400));
		System.out.println("=================");
		System.out.println(at.sumArg2("신짱구", 30,60,90));
		
//		at.test01(0, "신짱구");
//		System.out.println("=================");
//		at.test01(3, "신짱아");
	}
	
//	public void test01(int a, String str) {
//		System.out.println("a= " + a);
//		System.out.println("str= " + str);
//	}
//	
//	public int test02(int a, int b, int c) {
//		return a + b + c;
//	}
}
