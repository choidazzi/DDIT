package chapter05.chapter052;

public class ArrayCreatByNewExample {
	public static void main(String[] args) {
		int[] arr1 = new int[3]; //몇 개짜리 배열인지 명시 해줘야함. heap에 3개짜리 방 생성.
		System.out.println(arr1[0]); //초기화를 하지 않아도 error 가 안남. why?? java는 내부적으로 배열 초기화 됨.
		System.out.println(arr1[1]);
		System.out.println(arr1[2]);
		
		System.out.println(arr1); //주소 출력 [I@2c8d66b2
		
		String[] arr2 = new String[3];
		arr2[0] = "1월"; 
		arr2[1] = "2월"; 
		System.out.println(arr2[0]);
		System.out.println(arr2[1]);
		System.out.println(arr2[2]); //String 은 null로 초기화됨 
		
		System.out.println(arr2); //주소 출력 [Ljava.lang.String;@5a39699c
		System.out.println(arr2.length); // var2.length 길이. 배열 3개니까 arr.length는 3
		
		String[]arr3 = new String[4];
		arr3[0] = "11월";
		arr3[1] = "12월";
		for (int i = 0; i < arr3.length; i++) {
			System.out.println(arr3[i]);
			
		}
	}
}
