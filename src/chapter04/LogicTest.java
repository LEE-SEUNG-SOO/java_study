package chapter04;

import java.util.Scanner;

/*
 * 연산자실습
 */

public class LogicTest {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//지역변수를 선언하는 경우에는 반드시 초기화를 진행한다.
		String name = "";
		int age = 0, height =0;
		//int height = 0;
		boolean parent = false, hearchDease = false;
		//boolean hearchDease = false;
		System.out.println("**********놀이기구 탑승전 유의사항 및 체크*************");
		System.out.println("놀이기구 탑승전 유의사항 및 체크");
		System.out.println("나이 6세이상(단 키120cm이상 부모님 동반시 탑승가능)");
		System.out.println("키 120cm 이상");
		System.out.println("심장질환자 탑승불가");
		System.out.println("************************************************");
		
		//이름입력
		System.out.print("이름을 입력해주세요. : ");
		name = input.next();
		
		//나이입력
		System.out.print("나이를 입력해주세요. : ");
		age = input.nextInt();
		
		//키입력
		System.out.print("키를 입력해주세요. : ");
		height = input.nextInt();
		
		//부모님동반 유무입력
		System.out.print("부모님 동반유무를 적어주세요.(동반:1, 미동반:0) : ");
		parent = (input.nextInt() == 1 ? true : false);
		
		// 심장질환 유무입력
		System.out.print("심장질환이 있으신가요.(유:1, 무:0) : ");
		hearchDease = (input.nextInt() == 1 ? true : false);
				
//		System.out.println(name + ", " + age +  ", " + height +  ", " + parent +  ", " + hearchDease);
		
		// 결과
		System.out.println("탑승 유무 결과 : " +  name + "님 " +
		((!hearchDease && (age >=6 ? (height >= 120 ? true : false) : 
					(parent && height >= 120 ? true : false))) ? "탑승가능합니다." : "탑승불가능합니다."));
	}

}
