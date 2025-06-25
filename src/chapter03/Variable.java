package chapter03;
/*
 * 변수 정의 방법
 */
// java.lang패키지는 자주 쓰는거라 import 불필요
//import java.lang.String;

public class Variable {
	
	//main method
	public static void main(String[] args) {
		// 기본자료형 변수 정의
		int age = 10;
		double aged = 10.0;
		boolean flag = true;	//true(1),false(0)
		char name ='홍';
		char name2 ='길';
		char name3 ='동';
		
		System.out.println("기본 자료형 변수 확인");
		System.out.println(age);
		System.out.println(aged);
		System.out.println(flag);
		System.out.print(name);
		System.out.print(name2);
		System.out.println(name3);
		System.out.println("----------------------");
		
		// 참조 자료형 변수 정의
		// String 클래스는 기본형과 참조형 모두 사용가능
		String sName ="홍길동";
		String sName2 = new String("홍길동 입니다.");

		System.out.println("참조 자료형 변수 확인");
		System.out.println(sName);
		System.out.println(sName2);
		System.out.println("----------------------");
	}
	
}
