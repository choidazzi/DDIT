package chapter04;

public class confirm426 {
	public static void main(String[] args) {
		for (int i = 1; i < 5; i++) {
			for (int j = 5; j > 0; j--) {
				if (j > i) {
					System.out.print(" ");
				} else
					System.out.print("*");
			}
			System.out.println();
		}
	}
}
