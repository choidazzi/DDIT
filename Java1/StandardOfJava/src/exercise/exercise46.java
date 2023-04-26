package exercise;
//두개의주사위를던졌을때, 눈의합이6이되는모든경우의수를출력하는프로그램을 작성하시오.
public class exercise46 {
	public static void main(String[] args) {
		//주사위는 1~6
		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <=6; j++) {
				if (i + j == 6) {
					System.out.println(i + "," + j);
				} 
			}
		}
	}
}
