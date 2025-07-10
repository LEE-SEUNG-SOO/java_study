package kbank;
/**
 * 은행의 고객 정보를 담는 클래스이며, 은행 직원을 통해 생성된다.
 */
public class AccountVo {
	private String name;
	private int account;
	private int money;
	private int password;

	public AccountVo() {
		
	}
	
	public AccountVo(String name, int account, int money, int password) {
		this.name = name;
		this.account = account;
		this.money = money;
		this.password = password;
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
