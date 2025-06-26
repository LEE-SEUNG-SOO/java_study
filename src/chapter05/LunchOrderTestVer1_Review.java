package chapter05;

import java.util.Scanner;

public class LunchOrderTestVer1_Review {

	public static void main(String[] args) {
		// 변수 선언
		// main에서 사용되는 변수는 항상 위에 둘것.
		String menuName = "";
		int menuPrice =0;
		int charge = 0;
		int change = 0;
		Scanner scan = new Scanner(System.in);
	
		//메뉴판
		System.out.println("*************************************************");
		System.out.println("\t @@@@Welcom to Food Mart@@@@");
		System.out.println("*************************************************");
		System.out.println("\t 1. 햄버거(🍔):100\t 2.피자(🍕):200");
		System.out.println("\t 3. 라면(🍜):300\t\t 4.샐러드(🥗):400");
		System.out.println("\t 9. 나가기");
		System.out.println("*************************************************");
		System.out.println("************Food Mart에 오신것을 환영합니다***********");
		
		// 1. 메뉴선택
		System.out.print("메뉴를 선택해주세요. : ");		
		if(scan.hasNextInt()) {
			switch(scan.nextInt()){
			case 1:
				menuName = "햄버거(🍔)";
				menuPrice = 100;
				break;
			case 2:
				menuName = "피자(🍕)";
				menuPrice = 200;
				break;
			case 3:
				menuName = "라면(🍜)";
				menuPrice = 300;
				break;
			case 4:
				menuName = "샐러드(🥗)";
				menuPrice = 400;
				break;
			case 9:
				System.out.println("나갑니다.");
				System.exit(0);
				break;
			default:
				System.out.println("메뉴 준비중입니다.");
			}
		} else {
			System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
		}

		// 2. 주문 메뉴 결제
		if(menuPrice != 0) {
			System.out.print("결제 하실 금액은 " + menuPrice + "원 입니다. 결제를 진행해주세요. : ");
			
			if(scan.hasNextInt()) {
				charge += scan.nextInt();
				if(charge >= menuPrice) {
					change = charge - menuPrice;
				} else {
					System.out.println("금액이 부족합니다. 다시 결제해주세요.");
					System.out.println("현재 금액 : " + charge + "부족한 금액 " + (menuPrice - charge));
					System.out.print("금액 입력 : ");
					
					if(scan.hasNextInt()) {
						charge += scan.nextInt();
						
						if(charge >= menuPrice) {
							change = charge - menuPrice;
						} else {
							System.out.println("금액이 부족합니다. 처음부터 다시해주세요.");
						}
					} else {
						System.out.println("잘못된 입력입니다. 다시 결제해주세요.");
					}
				}
			}else {
				System.out.println("잘못된 입력입니다. 다시 결제해주세요.");
			}
			
			if(charge >= menuPrice) {
				// 3. 주문 내역 : 주문한 메뉴 XX, 결제 금액 XX, 잔돈 XX입니다.
				System.out.println("주문하신 메뉴는 " + menuName +", 결제 금액은 " + charge + "원, 잔돈은 " + change + "원 입니다.");				
			}
		}
	}
}