package kbank;

public class KBBank {
	private AccountVo accountVo;
	private AccountPaperVo paper;
	private Customer customerInfo;
	
	public void setAccountInfo() {
		accountVo = new AccountVo("홍길동",123456789,5000000,1234);
	}
	
	public void start(Customer customer, BankMan bankMan) {
		paper = AccountPaperVo.getInstance();
		customerInfo = customer;
		customer.writePaper(paper);
		bankMan.checkPaper(paper);
	}
	
	public AccountVo getAccountVo() {
		return accountVo;
	}
	
	public Customer getCustomerInfo() {
		return customerInfo;
	}
}
