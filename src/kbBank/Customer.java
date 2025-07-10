package kbBank;

import java.util.Scanner;

public class Customer {
	private String name;
	private String accountNumber;
	private String password;
	private int money;
	private AccountPaperVo paper;
	Scanner scan = new Scanner(System.in);
	
	public Customer() {
		
	}
	
	public Customer(String name, String accountNumber, String password, int money) {
		this.name = name;
		this.accountNumber = accountNumber;
		this.password = password;
		this.money = money;
	}
	
	public AccountPaperVo getPaper() {		
		return paper;
	}

	public Scanner getScan() {
		return scan;
	}
	
	public void setPaper(AccountPaperVo paper) {
		this.paper = paper;
		this.paper.setName(name);
		this.paper.setAccountNumber(accountNumber);
		this.paper.setPassword(password);
		this.paper.setMoney(money);
	}
	
	public void answerMoney(AccountPaperVo paper) {
		paper.setMoney(100);
		System.out.println("금액을 입력했습니다. " + paper.getMoney());
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
}
