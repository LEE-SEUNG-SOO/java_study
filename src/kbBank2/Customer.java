package kbBank2;

import java.util.Scanner;

public class Customer {
	private String name;
	private String accountNumber;
	private String password;
	private int money;
	private AccountPaperVo accountPaper;
	private Scanner scan;
	
	public Customer() {
		
	}
	
	public Customer(String name, String accountNumber, String password, int money) {
		this.name = name;
		this.accountNumber = accountNumber;
		this.password = password;
		this.money = money;
		this.scan = new Scanner(System.in);
		
		System.out.println(printName(name) + " 방문");
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

	public AccountPaperVo getAccountPaper() {
		System.out.println(printName(name) + " 입출금 정보 전달");
		return accountPaper;
	}

	public void setAccountPaper(AccountPaperVo accountPaper) {
		this.accountPaper = accountPaper;
		writeAccoutPaper();
	}

	public Scanner getScan() {
		return scan;
	}

	public void setScan(Scanner scan) {
		this.scan = scan;
	}
	
	/**
	 *  입출금 용지 작성
	 */
	private void writeAccoutPaper() {
		accountPaper.setName(name);
		accountPaper.setAccountNumber(accountNumber);
		accountPaper.setPassword(password);
		accountPaper.setMoney(money);
		
		System.out.println(printName(name) + " 입출금 정보 작성 완료");
	}
	
	/**
	 * 고객명 출력용
	 * @param name 고객이름
	 * @return [고    객 : 고객이름]
	 */
	public String printName(String name) {
		return "[고   객 : " + name +"]";
	}
	
	/**
	 * 입출금 용지 추가 작성
	 * @param checkResult 유효성 체크 결과
	 * 	1: 이름, 2: 계좌번호, 3: 비밀번호, 4: 출금금액 미입력
	 * @return 입출금용지
	 */
	public AccountPaperVo answer(int checkResult) {
		switch(checkResult) {
			case BankMan.ACCOUNT_NAME:
				accountPaper.setName(scan.next());
				break;
			case BankMan.ACCOUNT_NUMBER:
				accountPaper.setAccountNumber(scan.next());
				break;
			case BankMan.ACCOUNT_PASSWORD:
				accountPaper.setPassword(scan.next());
				break;
			case BankMan.ACCOUNT_MONEY:
				accountPaper.setMoney(scan.nextInt());
				break;
			default:
		}
		return accountPaper;
	}
}
