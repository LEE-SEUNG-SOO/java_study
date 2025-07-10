package kbank;

public class KBbankTest {

	public static void main(String[] args) {
		KBBank kbBank = new KBBank();

		kbBank.setAccountInfo();
		
		Customer customer = new Customer("홍길동");
		BankMan bankMan = new BankMan("박보검", kbBank);
		
		kbBank.start(customer,bankMan);
		
	}
}

