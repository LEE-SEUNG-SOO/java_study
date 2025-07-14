package chapter08;

public class Shape {
	String color;
	
	// 자식만 사용가능한 메소드
	protected Shape(String color) {
		this.color = color;
	}	
}
