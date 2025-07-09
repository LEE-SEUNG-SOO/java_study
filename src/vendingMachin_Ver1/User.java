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
		} else {
			System.out.println("잘못된 입력입니다.");
			scan.next();
			insertCoin();
		}
		
		return coin;
	}

	// 메뉴 선택
	public int selectMenu() {
		System.out.print("[" + name + "] 메뉴 선택 > : ");
		// 메뉴 선택
		int menuNo = 0;
		if(scan.hasNextInt()) {
			// 메뉴 선택
			menuNo = scan.nextInt();
		} else {
			System.out.println("잘못된 입력입니다.");
			scan.next();
			selectMenu();
		}
		
		return menuNo;
	}
}
