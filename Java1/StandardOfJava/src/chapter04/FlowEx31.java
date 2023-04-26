package chapter04;

public class FlowEx31 {
	public static void main(String[] args) {
		for (int i = 0; i <= 10; i++) {
			if (i % 3 == 0) 
				continue; // 3의 배수가 아니라면 출력 , 3의 배수라면 블럭의 끝으로 이동 
			System.out.println(i);
		}
	}
}
