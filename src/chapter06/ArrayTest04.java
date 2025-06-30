package chapter06;

import java.util.Scanner;

/*
 * 참조변수확인
 * call by value     : 저장소(heap영역)에 데이터가 들어가는것. (기본형 데이터)
 * call by reference : 저장소(heap영역)에 주소가 들어가는것.  (참조형 데이터)
 * 
 */
public class ArrayTest04 {

	public static void main(String[] args) {
		// 배열 객체 생성 후 크기 확인 : 기본형 데이터를 저장하는 객체 생성
		int numberList[] = new int[5];
		String nameList[] = {"홍길동","이순신","김유신"};
		boolean flagList[] = new boolean[2];
		
		// 배열 객체 생성 후 크기 확인 : 참조형 데이터를 저장하는 객체 생성
		Scanner scanList[] = new Scanner[3]; // Scanner 클래스의 객체를 3개 저장하는 객체 생성
		
		// scanList 0번지에 Scanner 객체 생성후 주소 저장
		scanList[0] = new Scanner(System.in);
		scanList[1] = new Scanner(System.in);
		scanList[2] = new Scanner(System.in);
	
		System.out.println("numberList의 크기 : " + numberList.length);
		System.out.println("nameList의 크기   : " + nameList.length);
		System.out.println("flagList의 크기   : " + flagList.length);
		System.out.println("---------------------------------------------------");
		
		System.out.println("scanList의 크기   : " + scanList.length);
		System.out.println("scanList[0]의 값 : " + scanList[0]);
		System.out.println("scanList[1]의 값 : " + scanList[1]);
		System.out.println("scanList[2]의 값 : " + scanList[2]);
		System.out.println("scanList[0]의 해쉬코드 : " + scanList[0].hashCode());
		System.out.println("scanList[1]의 해쉬코드 : " + scanList[1].hashCode());
		System.out.println("scanList[2]의 해쉬코드 : " + scanList[2].hashCode());
		System.out.println("---------------------------------------------------");
		
		// scanList[2]의 주소값을 scanList[0]에 저장 call by reference
		scanList[0] = scanList[2];
		System.out.println("scanList[0]의 해쉬코드 : " + scanList[0].hashCode());
		System.out.println("scanList[1]의 해쉬코드 : " + scanList[1].hashCode());
		System.out.println("scanList[2]의 해쉬코드 : " + scanList[2].hashCode());
		System.out.println("---------------------------------------------------");
		
		int nList[] = new int[3];
		nList[0] = 10;
		nList[1] = 20;
		nList[2] = 30;
		
		// scanList[2]의 주소값을 scanList[0]에 저장 call by value
		nList[0] = nList[2];
		System.out.println("nList[0]의 값 " + nList[0]);
		System.out.println("nList[1]의 값 " + nList[1]);
		System.out.println("nList[2]의 값 " + nList[2]);
		
	}

}
