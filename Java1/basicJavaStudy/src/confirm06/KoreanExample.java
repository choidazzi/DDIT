package confirm06;

public class KoreanExample {
	public static void main(String[] args) {
		Korean korean = new Korean();
		Korean K1 = new Korean("이소연","1234",25);
		System.out.println(K1.name);
		System.out.println(K1.ssn);
		Korean K2 = new Korean("신진수","2345",26);
		Korean K3 = new Korean("김채현","3456",27);
		Korean K4 = new Korean("서예린","4567",28);	
	}
}
 