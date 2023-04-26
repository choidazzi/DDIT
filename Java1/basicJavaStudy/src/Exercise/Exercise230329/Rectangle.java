package Exercise.Exercise230329;

public class Rectangle extends Shape{
	private double width;
	private double height;

	public Rectangle(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}
	
	@Override
	public double area() {
		return width * height;
	}
	
	@Override
	public double perimeter() {
		return 2* (width + height);
	}
	
	@Override
	public String toString() {
		return "도형의 종류: 사각형, 둘레: " +perimeter() + "cm, 넓이: " + area() + "㎠,";
	}
}
