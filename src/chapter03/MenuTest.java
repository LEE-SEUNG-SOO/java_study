package chapter03;

import java.util.Scanner;

public class MenuTest {

	public static void main(String[] args) {
		// 첫화면출력
		System.out.println("******************************************");
		System.out.println("\t Welcome to Shopping Mall");
		System.out.println("\t Welcome to Food Market");
		System.out.println("******************************************");
		System.out.println("\t 1. 상품보기\t 2. 상품구입");
		System.out.println("\t 3. 영수증보기\t 4. 종료");
		System.out.println("******************************************");

		// 입력
		Scanner scan = new Scanner(System.in);
		System.out.print("메뉴를 선택해주세요(숫자) > ");
		int num = scan.nextInt();
		
		// 출력
		System.out.println("선택한 메뉴 : " + num);
		
	}

}
