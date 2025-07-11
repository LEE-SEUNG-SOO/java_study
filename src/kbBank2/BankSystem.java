package kbBank2;

public class BankSystem {
	AccountVo[] accountList;
	String name;
	
	public BankSystem() {
		this("KB");
	}
	public BankSystem(String name) {
		this.name = name;
		// 고객정보 리스트 생성
		createAccountList();
	}
	// 고객정보 리스트 생성
	private void createAccountList() {
		String[] names = {"홍길동","이순신","김유신"};
		String[] accountNumbers = {"kb-123","kb-456","kb-789"};
		String[] passwords = {"123","456","789"};
		int[] money = {1000,300,500};
		
		accountList = new AccountVo[names.length];
		
		// 고객의 계좌정보 설정
		for(int i = 0; i < names.length; i++) {
			AccountVo account = new AccountVo();
			account.setName(names[i]);
			account.setAccountNumber(accountNumbers[i]);
			account.setPassword(passwords[i]);
			account.setMoney(money[i]);
			
			accountList[i] = account;
		}
	}
	
	/**
	 * 고객 정보 출력
	 */
	public void showAccountList() {
		System.out.println("====================고객 정보=====================");
		for(AccountVo account : accountList) {
			System.out.print(account.getName() + "\t");
			System.out.print(account.getAccountNumber() + "\t");
			System.out.print(account.getPassword() + "\t");			
			System.out.println(account.getMoney());	
		}		
		System.out.println("================================================");
	}
	
	/**
	 * 고객 정보 출력(고객 정보를 입력받았을 경우)
	 */
	public void showAccountList(AccountVo account) {
		System.out.println("====================고객 정보=====================");
		System.out.print(account.getName() + "\t");
		System.out.print(account.getAccountNumber() + "\t");
		System.out.print(account.getPassword() + "\t");			
		System.out.println(account.getMoney());	
		System.out.println("================================================");
	}
	
	// 고객 계좌 확인
	public int searchAccount(AccountPaperVo accountPaper) {
		int accountIdx = -1;
		
		for(int i = 0; i < accountList.length; i ++) {
			// 고객리스트 순차 확인
			AccountVo account = accountList[i];
			
			/* 고객정보의 이름    == 입출금 정보의 이름 &&
			*  고객정보의 계좌번호 == 입출금 정보의 계좌번호 &&
			*  고객정보의 비밀번호 == 입출금 정보의 비밀번호 일 경우
			*/
			if(account.getName().equals(accountPaper.getName())
				&& account.getAccountNumber().equals(accountPaper.getAccountNumber())
				&& account.getPassword().equals(accountPaper.getPassword())) {
					accountIdx = i;
					i = accountList.length;
				}
		}
		
		return accountIdx;
	}
	
	// 고객 정보를 입력받아 해당 고객의 정보 출력
	public void confirmMoney(AccountPaperVo accountPaper) {
		int accountIdx = searchAccount(accountPaper);
		
		// 검색결과 인덱스가 존재할 경우
		if(accountIdx != -1) {
			AccountVo account = accountList[accountIdx];
			// 고객 정보 출력
			showAccountList(account);
		} else {
			System.out.println("일치하는 고객 정보가 없습니다.");		
		}
	}
}
