package chapter07;
/*
 * 클래스 생성
 * 객체의 재사용성을 높이기 위해 작성
 */
public class Animal2 {
	// Field : 전역 변수
	String name;
	int age;
	
	// Constructor 생성자는 오버로딩이 가능하다.
	public Animal2(){ // 기본 생성자
		System.out.println("객체를 생성한다.");
	}
	// 오버로딩
	public Animal2(String name){ // field의 name값 초기화
		this.name = name;
		System.out.println("객체를 생성한다.");	
	}
	// 오버로딩
	public Animal2(String name, int age){ // field의 name, age값 초기화
		this.name = name;
		this.age = age;
		System.out.println("객체를 생성한다.");
	}
	
	// Method [접근제어자(public)] [반환타입] [메소드명]()
	public void sleep() {
		String date = "20250703";
		System.out.println(name + " " + date+ " -> 잠을 잔다.");
	}
	
}
