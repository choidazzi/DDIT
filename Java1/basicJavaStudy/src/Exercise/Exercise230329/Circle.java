package Exercise.Exercise230329;

public class Circle extends Shape{
	private double radius;

	public Circle(double radius) {
		super();
		this.radius = radius;
	}
	
	@Override
	public double area() {
		return radius * radius * Math.PI;
	}

	@Override
	public double perimeter() {
		return 2 * radius * Math.PI;
	}
	
	@Override
	public String toString() {
		return "도형의 종류: 원, 둘레: " +perimeter() + "cm, 넓이: " + area() + "㎠ ,";
	}
}
