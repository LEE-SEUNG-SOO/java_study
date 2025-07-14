package chapter08;

public class InheritanceTest {

	public static void main(String[] args) {
		// Client c1 = new Client(); // 추상클래스이므로 객체 생성 불가
		Person lee = new Person();
		Animal a1 = new Animal();
		
//		c1.name = "홍길동";
//		lee.name = "홍길동"; // Person객체의 name 사용
//		/*
//		 *  부모인 Client의 name 사용방법
//		 *  자식의 필드에 없는 변수명이 부모의 필드에 존재할 경우 부모의 필드의 변수 사용
//		 */
//		a1.name = "예삐";
	
		System.out.println("-------------------------------");
		
		//System.out.println("c1.name : " + c1.name);
		System.out.println("lee.name : " + lee.name);
		System.out.println("a1.name : " + a1.name);
		
		System.out.println("-------------------------------");
		
		Person kim = new Person("김유신", "종로구","010-9876-5432", 11);

		System.out.println("-------------------------------");

		System.out.println("kim.name : " + kim.name);
		
		System.out.println("-------------------------------");
		
		// Client의 메소드 실행
		//c1.printInfo();
		// Person의 메소드 실행
		lee.printInfo();
		// Client의 메소드 실행
		a1.printInfo();
		// Person의 메소드 실행
		kim.printInfo();

		System.out.println("-------------------------------");
		Animal dog = new Animal("명수",1,lee);
		Animal cat = new Animal("야옹",2,kim);
		
		// Animal의 메소드 실행
		dog.printInfo();
		// Animal의 메소드 실행
		cat.printInfo();
		
		dog.sound();
		cat.sound();
		
		System.out.println("-------------------------------");
		
		// Person의 메소드 실행
		lee.register();
		cat.register();
		
	}
}
