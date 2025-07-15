package chapter08;

public class ObjectTypeCastingTest {

	public static void main(String[] args) {
		Circle yellowC = new Circle("노랑",1);
		Rectangle blueR = new Rectangle("파랑",3,4);
		
		// 부모클래스 = new 자식클래스 <- O
		Shape s = new Circle("초록",2); // 자동 형변환
		//Circle cs = s; // s는 Shape만 사용하므로 에러
		Circle cs = (Circle)s; // 명시적형변환을 통해 자식의 타입으로 변경후에는 가능
		//Rectangle r = (Rectangle)s; // 에러발생 Circle타입으로 생성했기때문에 Rectangle타입으로 형변환 불가
		
		cs.draw();
		
		// Shape타입으로 생성
		Shape s2 = new Shape("빨강");
		//Circle cs2 = (Circle)s2; // 에러발생 Shape은 Circle보다 영역이 작기때문에 형변환 불가
		
		// 인터페이스로도 생성가능
		// 인터페이스를 통해 자식의 모습으로 객체를 구현하는 것을 권장함
		ShapeInterface si = new Circle("코랄",1);
		// 인터페이스에는 draw 메소드가 있기때문에 사용가능.
		si.draw(); // Circle의 draw 메소드가 실행
		System.out.println(si.getArea()); // Circle의 getArea 메소드가 실행
		System.out.println("-------------------------");
		Circle cs3 = (Circle)si;
		cs3.draw();
		System.out.println(cs3.getArea());
		System.out.println(cs3.getRadius());
		System.out.println("-------------------------");
		// 자식클래스 = new 부모클래스 <- X
		//Circle c = new Shape("초록");
		// 같은 자식끼리 불가
		// Rectangle t = new Circle("그린", 2,3);
		
		yellowC.draw();
		blueR.draw();
		// Circle타입으로 생성은 했으나 선언된게 Shape타입이므로 Circle의 draw메소드 사용불가
		//s.draw();
		System.out.println(s.color);

		System.out.println("-------------------------");
		
		ShapeInterface rsi2 = new Rectangle("보라",5,4); // 다형성
		rsi2.draw();
		System.out.println(rsi2.getArea());
		System.out.println("-------------------------");
		
		ShapeInterface rsi3 = new Triangle("연두",5,4); // 다형성
		rsi3.draw();
		System.out.println(rsi3.getArea());
		System.out.println("-------------------------");
		
		
		
	}
}
