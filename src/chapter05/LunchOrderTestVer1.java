package chapter05;

import java.util.Scanner;

public class LunchOrderTestVer1 {

	public static void main(String[] args) {
		//메뉴판
		System.out.println("*************************************************");
		System.out.println("\t @@@@Welcom to Food Mart@@@@");
		System.out.println("*************************************************");
		System.out.println("\t 1. 햄버거(🍔):100\t 2.피자(🍕):200");
		System.out.println("\t 3. 라면(🍜):300\t\t 4.샐러드(🥗):400");
		System.out.println("\t 9. 나가기");
		System.out.println("*************************************************");
		System.out.println("************Food Mart에 오신것을 환영합니다***********");
		Scanner scan = new Scanner(System.in);
		int menuNo = -1;
		String menuName = "";
		int menuPrice = 0;
				
		// 1. 메뉴선택
		System.out.println("메뉴 선택(숫자) : ");
		// 입력값 확인
		// 정수일경우
		if(scan.hasNextInt()) {
			menuNo = scan.nextInt();
			
//			//if문 작성
//			if(menuNo == 1) {
//				System.out.println("햄버거(🍔)선택");
//			} else if(menuNo == 2) {
//				System.out.println("피자(🍕)선택");
//			} else if(menuNo == 3) {
//				System.out.println("라면(🍜)선택");
//			} else if(menuNo == 4) {
//				System.out.println("샐러드(🥗)선택");
//			} else if(menuNo == 9) {
//				System.out.println("- 프로그램을 종료합니다. -");
//				// 시스템 종료
//				System.exit(0);
//			} else {
//				System.out.println("메뉴 준비중입니다.");
//			}
			
			// switch문 작성
			// 한줄일 경우 칸띄우기를 하지 않아도 되긴하다.
			switch(menuNo) {
				case 1:	menuName = "햄버거(🍔)";	menuPrice = 100;	break;
				case 2:	menuName = "피자(🍕)";	menuPrice = 200;	break;
				case 3:	menuName = "라면(🍜)";	menuPrice = 300;	break;
				case 4:	menuName = "샐러드(🥗)";	menuPrice = 400;	break;
				case 9:
					System.out.println("- 프로그램을 종료합니다. -");
					// 시스템 종료
					System.exit(0);
					break;
				default: System.out.println("메뉴 준비중입니다. 다시 입력해주세요.");
			} //switch끝
			
		}else {
			// 입력값이 정수가 아닐 경우
			System.out.println("올바르지 않는 입력값입니다. 다시 입력해주세요.");
		}
		
		System.out.println("주문 하신 메뉴는 " + menuName + "이고 가격은 " + menuPrice + "원 입니다.");
		
		// 2. 주문 메뉴 결제
		int charge = 0;
		int change = 0;
		System.out.print("결제할 금액을 입력해주세요. : ");

		if(scan.hasNextInt()) {
			charge = scan.nextInt();
			if(charge >= menuPrice) {
				change = charge - menuPrice;
			} else {
				// 입력받은 금액이 가격보다 작을 경우.
				System.out.println("금액이 부족합니다. 다시 입력해주세요.");
			}
			
		} else {
			// 입력값이 정수가 아닐 경우
			System.out.println("올바르지 않는 입력값입니다. 다시 입력해주세요.");
		}
		
		// 3. 주문 내역 : 주문한 메뉴 XX, 결제 금액 XX, 잔돈 XX입니다.
		System.out.println("주문한 메뉴는 " + menuName + " 결제금액" + "("+ menuPrice + ") " + "잔돈" + "(" + change + ")"+"입니다.");
	}
}