package Exercise.test.sixtoseven;

public class Circle {
	//필드
	double radius;
	double x;
	double y;
	
	//생성자 
	public Circle() {

	}
	
	//메소드 
	double getRadius() {
		if (radius>0) {
			return radius;
		} return 0.0;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	double getArea() {
		return radius * radius * Math.PI;
	}
}
