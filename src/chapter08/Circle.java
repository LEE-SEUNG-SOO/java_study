package chapter08;

public class Circle extends Shape implements ShapeInterface {
//	String color;
	int radius;
	
	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public Circle() {
		this("흰색",0);
	}

	public Circle(String color, int radius) {
		super(color);
//		this.color = color;
		this.radius = radius;
	}
	
	@Override
	public void draw() {
		System.out.println(color + CIRCLE);
	}

	@Override
	public double getArea() {
		return radius * radius * Math.PI;
	}
}
