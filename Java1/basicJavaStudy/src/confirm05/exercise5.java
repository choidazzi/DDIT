package confirm05;

public class exercise5 {
	public static void main(String[] args) {
		int[][] array = { 
				{ 95, 86 }, //score first
				{ 83, 92, 96 }, //score second 
				{ 78, 83, 93, 87, 88 } //score third
				};
		int sum = 0;
		double avg = 0.0;
		
		int count = 0;
		for (int[] score : array) {
			for (int s : score) {
				count++;
				sum += s;
				avg = sum / count;
			}
		}
		System.out.println(sum);
		System.out.println(avg);
	}
}