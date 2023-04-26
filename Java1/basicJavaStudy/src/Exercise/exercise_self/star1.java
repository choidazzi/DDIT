package Exercise.exercise_self;

import java.util.Iterator;

public class star1 {
//	*
//	**
//	***
//	****
	public static void main(String[] args) {
//		for (int i = 1; i < 5; i++) {
//			for (int j = 0; j < i; j++) {
//				System.out.print("*");
//			}System.out.println("");
//		}
		
		for (int i = 1; i < 5; i++) {
			for (int j = 4; j > i; j--) {
				System.out.print(" ");
			}
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}System.out.println();
		}
		}
	}

