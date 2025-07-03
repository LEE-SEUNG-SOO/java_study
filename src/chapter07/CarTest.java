package chapter07;
/*
 * Car 클래스 실행
 */
public class CarTest {

	public static void main(String[] args) {
		// 1. 객체 생성
		Car avante = new Car();
		Car ev6 = new Car();
		
		// 2. 객체 데이터 할당
		avante.name = "아반테";
		avante.company = "현대";
		avante.price = 1000;

		ev6.name = "ev6";
		ev6.company = "기아";
		ev6.price = 2000;
		
		// 3. 객체의 메소드 호출
		System.out.println("*********************************");
		System.out.println("\tCar Information");
		System.out.println("*********************************");
		// 각 메소드 호출 종료시 main으로 돌아가는 복귀주소(리턴주소)를 갖는다.
		// main -> showInfo() -> main
		avante.showInfo();
		ev6.showInfo();
		System.out.println("*********************************");
		System.out.println(" -- main method 종료 -- ");
	}

}
