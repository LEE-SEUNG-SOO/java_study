package chapter08;

public class Triangle extends Shape implements ShapeInterface {
//	String color;
	int length;
	int height;
	
	public Triangle() {
		this("흰색",0,0);
	}

	public Triangle(String color, int length, int height) {
//		this.color = color;
		super(color);
		this.length = length;
		this.height = height;
	}
	
	@Override
	public void draw() {
		System.out.println(color + TRIANGLE);
	}
	
	@Override
	public double getArea() {
		return (double)((length * height) / 2);
	}
}
