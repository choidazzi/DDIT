package chapter02.chapter022;

public class EscapeExample {
	public static void main(String[] args) {
		System.out.println("번호\t이름\t직업"); // \t : tab 만큼 띄움
		System.out.println("행\n단위\n출력"); // \n : 줄바꿈(new line)
		System.out.println("행\r단위\r출력"); // \r : 캐리지라인 (\n 을 더 많이 사용)
		System.out.println("우리는 \"개발자\" 입니다."); // \" : 큰따옴표 (")
		System.out.println("봄\\여름\\가을\\겨울"); // \\: 역슬래시(\)
	}
}
