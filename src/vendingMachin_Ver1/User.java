package vendingMachin_Ver1;

import java.util.Scanner;

public class User {
	// Field
	// 입력
	Scanner scan;
	// 이름
	String name;

	// Constructor
	public User() {
		this("홍길동");
	}
	public User(String name) {
		this.name = name;
		scan = new Scanner(System.in);
	}
	
	// Method
	// 동전 넣기
	public int insertCoin() {
		System.out.print("[" + name + "] 동전 입력 > : ");
		// 동전 체크용
		int coin = 0;
		if(scan.hasNextInt()) {
			// 동전 체크용
			coin = scan.nextInt();
			
//			// 입력한 값이 100원 또는 500원 일경우
//			if(coinCheck(checkCoin)) {
//				// coin에 입력한값 플러스
//				coin += checkCoin;
//			} else {
//				System.out.println("100원 또는 500원 동전만 사용가능합니다.");
//				insertCoin();
//			}
		} else {
			System.out.println("잘못된 입력입니다.");
			insertCoin();
		}
		
		return coin;
	}
	
//	// 코인 체크
//	public boolean coinCheck(int checkCoin) {
//		// 체크결과
//		boolean checkFlag = false;
//		
//		// 입력한 값이 100원 또는 500원 일경우
//		if(checkCoin == 100 || checkCoin == 500) {
//			// 체크결과 = true
//			checkFlag = true;
//		}		
//		return checkFlag;
//	}
	
	// 메뉴 선택
	public int selectMenu() {
		System.out.print("[" + name + "] 메뉴 선택 > : ");
		// 메뉴 선택
		int Menu = 0;
		if(scan.hasNextInt()) {
			// 메뉴 선택
			Menu = scan.nextInt();
		} else {
			System.out.println("잘못된 입력입니다.");
			selectMenu();
		}
		
		return Menu;
	}
}
