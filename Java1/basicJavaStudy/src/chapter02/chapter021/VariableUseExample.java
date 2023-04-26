package chapter02.chapter021;

public class VariableUseExample {
	public static void main(String[] args) { //Ctrl + space : 단축어
		int hour = 3; // 3; + ctrl + 1 => int i(varible) = 3; 
		int minute = 5;
		System.out.println(hour + "시간 " + minute + "분"); //syso + ctrl + space => System.out.println()
		int totalMinute = (hour * 60) + minute;
		System.out.println("총 " + totalMinute + "분");
	}
}
