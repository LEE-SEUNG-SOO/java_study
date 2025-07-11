package kbank;

public class BankMan {
	public String name;
	public KBBank kbBank;
	private AccountVo acVo;
	
	public BankMan() {
		
	}
	public BankMan(String name, KBBank kbBank) {
		this.name = name;
		this.kbBank = kbBank;
	}
	
	public void checkPaper(AccountPaperVo paper) {
		int result = checkAccount(paper);
		boolean roopFlag = true;
		
		switch(result) {
		case 1:
			System.out.println("이름이 다릅니다.");
			break;
		case 2:
			System.out.println("계좌번호가 다릅니다.");
			break;
		case 3:
			System.out.println("패스워드가 다릅니다.");
			break;
		case 4:
			System.out.println("출금 가능한 금액보다 적으신 금액이 큽니다.");
			break;
		default:
			roopFlag = false;
		}
		if(roopFlag) {
			System.out.println("정보를 다시 입력해주세요.");
			kbBank.getCustomerInfo().writePaper(paper);
		}
		
		outputMoney(paper);
		outputMessage(paper);
	}
	
	
	public int checkAccount(AccountPaperVo paper) {
		int result = 0;
		acVo = kbBank.getAccountVo();
		
		if(acVo.getName().equals(paper.getName())){
			if(acVo.getAccount() == paper.getAccount()) {
				if(acVo.getPassword() == paper.getPassword()) {
					if(acVo.getMoney() < paper.getMoney()) {
						result = 4;
					}
				} else {
					result = 3;
				}
			} else {
				result = 2;
			}
		} else {
			result = 1;
		}
		return result;
	}
	
	
	private void outputMoney(AccountPaperVo paper) {
		acVo.setMoney(acVo.getMoney() - paper.getMoney());
	}
	
	private void outputMessage(AccountPaperVo paper)  {
		System.out.println(paper.getName() +"님 인출이 완료되었습니다.");
		System.out.println("잔고 : " + String.format("%,d" , acVo.getMoney()) + "원");
		System.out.println("인출 금액 : " + String.format("%,d" , paper.getMoney()) + "원");
	}
}
