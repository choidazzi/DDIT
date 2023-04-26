package confirm02;

public class Confirm2_3_9 {
	public static void main(String[] args) {
		long  var1 = 2L;
		float var2 = 1.8f;
		double var3 = 2.5;
		String var4 = "3.9";
		//결과가 9가 나와야 함. 소수점 한 자리 버려야 함.
		int result = (int) (var1 + var2 + var3+ (int)Double.parseDouble(var4)); 
		//소수점일 때, double로 바꾸고 int로 cast
		//ctrl + 1 하면 단체로 cast 됨.
		System.out.println(result);
	}
}