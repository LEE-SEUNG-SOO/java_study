package kbank;

import java.util.Scanner;

public class Customer {
	public String name;
	Scanner scan = new Scanner(System.in);
	
	public Customer() {
		
	}
	public Customer(String name) {
		this.name = name;
	}
	
	public void writePaper(AccountPaperVo paper) {
		System.out.print("이름 : ");
		paper.setName(scan.next());
		
		System.out.print("계좌번호 : ");
		paper.setAccount(scan.nextInt());
		
		System.out.print("금액 : ");
		paper.setMoney(scan.nextInt());
		
		System.out.print("패스워드 : ");
		paper.setPassword(scan.nextInt());
	}
}
