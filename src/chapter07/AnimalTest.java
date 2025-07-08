package chapter07;
/*
 * Animal클래스의 실행
 */
public class AnimalTest {
	
	public static void main(String[] args) {
		System.out.println(" -- AnimalTest 클래스 실행!!! -- ");
		
		// 사자, 호랑이 객체 생성
		Animal lion = new Animal();
		Animal tiger = new Animal();
		Animal giraffe = new Animal();
		Animal elephant = new Animal();
		Animal2 lion2 = new Animal2();
		Animal2 lion3 = new Animal2("심바");
		Animal2 lion4 = new Animal2("심바" , 5);

		Animal3 lion5 = new Animal3("심바");
		
		giraffe.name = "기린이";
		elephant.name = "코순이";

		// lion 객체의 name, age 설정
		lion.name = "심바";
		lion.age = 5;
		
		// tiger 객체의 name, age 설정	
		tiger.name = "호돌이";
		tiger.age = 2;
				
		// lion객체의 name, age 출력
		System.out.println("lion.name : " + lion.name);
		System.out.println("lion.age : " + lion.age);
		
		// tiger객체의 name, age 출력
		System.out.println("tiger.name : " + tiger.name);
		System.out.println("tiger.age : " + tiger.age);

		// Animal클래스의 sleep메소드 실행
		lion.sleep();
		tiger.sleep();		
		
		System.out.println("giraffe.name : " + giraffe.name);
		System.out.println("elephant.name : " + elephant.name);
		
		
		System.out.println("----------Animal2---------");
		
		System.out.println("--> 생성자 초기화");
		System.out.println("lion2.name : " + lion2.name);
		System.out.println("lion2.age : " + lion2.age);
		System.out.println("lion3.name : " + lion3.name);
		System.out.println("lion3.age : " + lion3.age);
		System.out.println("lion4.name : " + lion4.name);
		System.out.println("lion4.age : " + lion4.age);
		
		System.out.println("---------------------------");
		
		System.out.println("----------Animal3---------");

		lion5.info();
		
		System.out.println("---------------------------");
		
	}

}
