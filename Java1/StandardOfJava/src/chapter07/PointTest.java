package chapter07;

public class PointTest {
	public static void main(String[] args) {
		Point3d p3 = new Point3d();
		System.out.println(p3.getLocation());
	}
}

class Point{
	int x =10;
	int y = 20;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Point3d extends Point{
	int z = 30;
	public Point3d() {
		this(100,200,300);
		// TODO Auto-generated constructor stub
	}
	public Point3d(int x, int y, int z) {
		super(x, y);
		this.z =z;
	}
	
	String getLocation() {	//오버라이딩 
		return "x: " + x + ", y: " + y + ", z: " + z;
	}
}
