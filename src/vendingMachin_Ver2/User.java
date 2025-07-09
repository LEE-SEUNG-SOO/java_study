package vendingMachin_Ver2;

import java.util.Scanner;

public class User {
	// Field
	String name;
	Scanner scan;
	
	// Constructor
	public User() {
		this("홍길동");
	}
	public User(String name) {
		this.name = name;
		scan = new Scanner(System.in);
	}
	
	// Method
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Scanner getScan() {
		return scan;
	}
	public void setScan(Scanner scan) {
		this.scan = scan;
	}
	
	// 동전 입력
	public int insertCoin() {
		int coin = 0;

		if(scan.hasNextInt()) {
			coin = scan.nextInt();
		} else {
			System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			scan.next();
			insertCoin();
		}
		
		return coin;
	}
}
