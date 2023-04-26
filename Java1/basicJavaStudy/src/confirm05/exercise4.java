package confirm05;

public class exercise4 {
	public static void main(String[] args) {
		int max = 0;
		int[] array = {1, 5, 3, 8, 2};
//				array [0] =1
//				array [1] =5
//				array [2] =3
//				array [3] =8
//				array [4] =2
		
//		for (int i = 0; i < array.length - 1; i++) {
//			if(array[i] > array [i+1]) {
//				max = array[i];
//			} else {
//				max = array [i + 1];
//			}
//		}
		for (int i : array) {
			if (i>max) {
				max = i;
			}
		}
		System.out.println("max: " + max);
	}
}
