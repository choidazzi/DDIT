package Exercise.Exercise230402.shape;

public class Circle extends Shape {
	private double radius;

	public Circle(double radius) {
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
		return String.format("도형의 종류: 원, 둘레: %.2fcm, 넓이: %.2f㎠", perimeter(), area());
	}
}
