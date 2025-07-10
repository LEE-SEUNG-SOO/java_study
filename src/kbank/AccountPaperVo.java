package kbank;

public class AccountPaperVo {
	private String name;
	private int account;
	private int money;
	private int password;
	
	static AccountPaperVo ap = new AccountPaperVo();
	
	private AccountPaperVo() {
		
	}
	
	public static AccountPaperVo getInstance() {
		return ap;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAccount() {
		return account;
	}
	public void setAccount(int account) {
		this.account = account;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
}