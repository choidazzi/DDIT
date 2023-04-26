package chapter03;

public class IncreaseDecreaseOperatorExample {
	public static void main(String[] args) {
		int a = 1;
		int b = 1;
		int plusPlusa = ++a;
		int bPlusPlus = b++;
		System.out.println("plusPlusa= " + plusPlusa + " , a= " + a); // 1. a=1 -- ++a ----------> 2. a + 1 = 2 -----> 3. a=2 , plusPlusa = 2
		System.out.println("plusPlusb= " + bPlusPlus + " , b= " + b); // 1. b=1 -- bbPlusPlus에 1 저장-> 2. b + 1 = 2 ----> 3. b=2, bPlusPlus = 1  
		
		
		int x = 10;
		int y = 10;
		int z;
		System.out.println("-------------------------");
		
		x++;
		++x;
		System.out.println("x= " + x); //x = 12
		
		System.out.println("-------------------------");
		y--;
		--y;
		System.out.println("y= " + y); //y = 8
		
		System.out.println("-------------------------");
		z = x++;
		System.out.println("z= " + z); //z = 12
		System.out.println("x= " + x); //x = 13
		
		System.out.println("-------------------------");
		z = ++x;
		System.out.println("z= " + z); //z = 14
		System.out.println("x= " + x); //x = 14
		
		System.out.println("-------------------------");
		z = ++x + y++;
		System.out.println("z= " + z); // z = 15 + 8 = 23
		System.out.println("x= " + x); // x = 15
		System.out.println("y= " + y); // y = 9
	}
}
