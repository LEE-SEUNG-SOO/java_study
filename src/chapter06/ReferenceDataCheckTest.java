package chapter06;

import java.util.Scanner;

/*
 * 레퍼런스 데이터 확인
 * 기본형 데이터와 참조형 데이터의 저장구조를 정리
 * String데이터 주의
 */
public class ReferenceDataCheckTest {

	public static void main(String[] args) {
		// 기본형
		int a = 10;
		int b = 10;
		String str1 = "홍길동";
		String str2 = "홍길동";
		String str3 = "홍길순";
		
		// 참조형
		String strObj1 = new String("홍길동");
		String strObj2 = new String("홍길동");
		
		System.out.println("-------call by value(기본형)------------");	
		// a와 b 비교 (기본형) true
		System.out.println("a == b (기본형) : " + (a == b)); // call by value 형태로 값을 비교.
		// str1와 str2 비교 (기본형) true
		System.out.println("str1 == str2 (기본형) : " + (str1 == str2)); // call by value 형태로 값을 비교.
		
		System.out.println("-------call by reference(참조형)------------");		
		System.out.println("strObj1.hashcode : " + System.identityHashCode(strObj1));		
		System.out.println("strObj2.hashcode : " + System.identityHashCode(strObj2));		
		// strObj1와 strObj2 비교 (참조형) false
		System.out.println("strObj1 == strObj2 (참조형) : " + (strObj1 == strObj2)); // 주소 비교
		// strObj1와 strObj2의 값 비교 (참조형) true
		System.out.println("strObj1.equals(strObj2) (참조형) : " + (strObj1.equals(strObj2))); // 값 비교.
		
		// 참조형에 기본형을 넣으면 기본형이 참조형형식으로 데이터를 만들어서 넣는다.
		strObj1 = str1;
		System.out.println(strObj1);
		System.out.println(System.identityHashCode(strObj1));
		System.out.println(System.identityHashCode(str1));
		
		
		System.out.println("-----------Scanner로 입력받은 값 비교------------");
		//Scanner 객체를 이용하여 문자열 입력
		Scanner scan = new Scanner(System.in);
		
		System.out.print("문자열 입력 : ");
		String sdata = scan.next();
		
		System.out.println(sdata.hashCode());
		System.out.println(System.identityHashCode(sdata));
		System.out.println("str2 == sdata : " + (str2 == sdata));
		System.out.println("str2.equals(sdata) : " + str2.equals(sdata));
	}

}
