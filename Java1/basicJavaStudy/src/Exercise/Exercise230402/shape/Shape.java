package Exercise.Exercise230402.shape;
//Shape 객체들이 배열에 저장되어 있을 때 Arrays.sort() 배열 저장 가능
public abstract class Shape implements Comparable<Shape>{ 
	public abstract double area();
	public abstract double perimeter();
	
	@Override
	public int compareTo(Shape o) { //부모 클래스에서 compareTo() 정의하면 자식 클래스에서 정의 안해도 됨. 
		if (area() > o.area()) { //크다 
			return 1;
		} else if (area() < o.area()) { //작다  
			return -1;
		}else //같다 
		return 0;
	}
}
					