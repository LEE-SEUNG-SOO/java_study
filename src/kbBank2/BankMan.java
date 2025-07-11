package kbBank2;

public class BankMan {
	// Field
	String name;
	private AccountPaperVo accountPaper;
	private BankSystem bankSystem;
	int result;

	public static final int ACCOUNT_OK = 0;
	public static final int ACCOUNT_NAME = 1;
	public static final int ACCOUNT_NUMBER = 2;
	public static final int ACCOUNT_PASSWORD = 3;
	public static final int ACCOUNT_MONEY = 4;
	
	public BankMan() {

	}
	
	public BankMan(String name, BankSystem bankSystem) {
		this.name = "[은행직원 : " + name + "]";
		this.bankSystem = bankSystem;
		System.out.println(this.name + " 업무시작");
	}

	public AccountPaperVo getAccountPaper() {
		return accountPaper;
	}

	public void setAccountPaper(AccountPaperVo accountPaper) {
		this.accountPaper = accountPaper;
		System.out.println(name + " 입출금 정보 받음");
	}

	public BankSystem getBankSystem() {
		return bankSystem;
	}

	public void setBankSystem(BankSystem bankSystem) {
		this.bankSystem = bankSystem;
	}
	
	/**
	 * 고객의 입출금용지 유효성 체크
	 * @param accountPaper 입출금 용지 정보
	 * @return 유효성 체크결과 재실시필요 : true
	 */
	public boolean checkValidate(AccountPaperVo accountPaper) {
		boolean validateFlag = true;
		result = 0;
		
		System.out.println(name + " 유효성 체크 실시");
		
		if(accountPaper.getName() == null) {
			result = ACCOUNT_NAME;
		} else if(accountPaper.getAccountNumber() == null) {
			result = ACCOUNT_NUMBER;	
		} else if(accountPaper.getPassword() == null) {
			result = ACCOUNT_PASSWORD;
		} else if(accountPaper.getMoney() == 0) {
			result = ACCOUNT_MONEY;
		} else {
			result = ACCOUNT_OK;
			validateFlag = false;
		}
		
		ask();
		
		return validateFlag;
	}
	
	/**
	 * 고객의 출금 정보유효성 체크 결과에 따른 질문
	 */
	public void ask() {
		switch(result) {
			case ACCOUNT_NAME:
				System.out.print(name + " 이름을 입력해주세요. : ");
				break;
			case ACCOUNT_NUMBER:
				System.out.print(name + " 계좌번호를 입력해주세요. : ");
				break;
			case ACCOUNT_PASSWORD:
				System.out.print(name + " 패스워드를 입력해주세요. : ");
				break;
			case ACCOUNT_MONEY:
				System.out.print(name + " 금액을 입력해주세요. : ");
				break;
			default:
				System.out.println(name + " 입출금 정보 확인 완료");
		}
	}

	/**
	 *  출금 처리
	 */
	public void processWithDrawal() {
		System.out.println(this.name + " 출금 요청 처리중");
		
		// 고객 계정 검색
		int accountIdx = bankSystem.searchAccount(accountPaper);
		
		// 검색결과 인덱스가 존재할 경우
		if(accountIdx != -1) {
			AccountVo account = bankSystem.accountList[accountIdx];
			
			// 검색한 계정금액 >= 출금용지 금액 일경우
			if(account.getMoney() >= accountPaper.getMoney()) {
				// 계정금액 = 계정금액 - 출금용지 금액
				int money = account.getMoney() - accountPaper.getMoney();
				account.setMoney(money);
				
				bankSystem.accountList[accountIdx] = account;
				
				// 출금 완료 확인
				processCompleted(accountIdx);
				
			} else {
				System.out.println(this.name + " 잔액이 부족합니다.");
			}
		} else {
			System.out.println(this.name + " 계좌 정보가 일치하지 않습니다.");		
		}
	}
	
	/**
	 *  출금 완료 확인
	 * @param accountIdx 계좌정보 인덱스
	 */
	public void processCompleted(int accountIdx) {
		System.out.println(this.name + " 출금 완료");
		System.out.println(this.name + " 출금액 : " + accountPaper.getMoney());
		System.out.println(this.name + " 잔액  : " + bankSystem.accountList[accountIdx].getMoney());
	}
}
