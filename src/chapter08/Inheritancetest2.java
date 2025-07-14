package chapter08;

public class Inheritancetest2 {
	public static void main(String[] args) {
		Circle redC = new Circle("빨간색",12);
		Triangle greenT = new Triangle("초록색",3,4);
		Rectangle yellowR = new Rectangle("노란색",5,6);
		
		redC.draw();
		System.out.println("원의 넓이 : " + redC.getArea());
		greenT.draw();
		System.out.println("삼각형의 넓이 : " + greenT.getArea());
		yellowR.draw();
		System.out.println("사각형의 넓이 : " + yellowR.getArea());
	}
}
