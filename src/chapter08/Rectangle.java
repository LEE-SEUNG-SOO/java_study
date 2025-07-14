package chapter08;

public class Rectangle extends Shape implements ShapeInterface {
//	String color;
	int width;
	int height;
	
	public Rectangle() {
		this("흰색",0,0);
	}

	public Rectangle(String color, int width, int height) {
//		this.color = color;
		super(color);
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void draw() {
		System.out.println(color + RECTANGLE);
	}
	
	@Override
	public double getArea() {
		return width * height;
	}
}
