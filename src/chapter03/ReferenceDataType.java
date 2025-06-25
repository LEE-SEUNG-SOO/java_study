package chapter03;

import java.util.Scanner;

public class ReferenceDataType {

	public static void main(String[] args) {
		// 참조 데이터 타입 정의 : 배열, 클래스, 인터페이스 ..
		String name = new String("홍길동");
		Scanner scan = new Scanner(System.in);
		
		//※※※※※※중요※※※※※※
		// String 클래스는 기본형으로도 사용 가능
		String name2 = "홍길동";
				
		System.out.println("String  : " + name);
		System.out.println("String2 : " + name2);
		System.out.println("String과 String2 비교결과 : " + (name == name2));
		System.out.println("Scanner : " + scan);

		
	}

}
