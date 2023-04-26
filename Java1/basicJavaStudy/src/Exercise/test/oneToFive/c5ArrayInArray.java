package Exercise.test.oneToFive;

public class c5ArrayInArray {
	public static void main(String[] args) {
		int[][] mathScores = new int[2][3];
		for (int i = 0; i < mathScores.length; i++) {
			for (int j = 0; j < mathScores[i].length; j++) {
				System.out.println(mathScores[i][j]);
			}
		}
		System.out.println();
		
	}
}
