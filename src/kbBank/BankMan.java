package kbBank;

public class BankMan {
	String name;
	AccountPaperVo paper;
	AccountVo[] accountList; // 은행 고객 리스트
	
	public BankMan() {
		this("변우석");
	}
	
	public BankMan(String name) {
		this.name = name;
		accountList = createAccountList();
	}
	
	public void setPaper(AccountPaperVo paper) {
		this.paper = paper;
	}
	
	/**
	 * 출금 처리를 하고, 잔액 업데이트
	 */
	
	public void changeProcess() {
		
	}
	
	/**
	 * 금액을 묻는 처리
	 */
	public void askMoney() {
		System.out.println("금액을 다시 입력해주세요.");
	}
	
	/**
	 * 은행 직원이 용지를 확인하는 작업
	 */
	public boolean checkPaper() {
		boolean result = false;
		boolean checkFlag = false;
		AccountVo account = new AccountVo();
		
		System.out.println("============용지 내용============");
		System.out.println("이름    : " + paper.getName());
		System.out.println("계좌번호 : " + paper.getAccountNumber());
		System.out.println("비밀번호 : " + paper.getPassword());
		System.out.println("출금금액 : " + paper.getMoney());
		System.out.println("===============================");
		
		
		for(int i = 0; i< accountList.length; i++) {
			account = accountList[i];
			if(paper.getAccountNumber().equals(account.getAccountNumber())) {
				checkFlag = true;
				i = accountList.length;
			}
		}
		if(checkFlag) {
			if(!(paper.getName().equals(account.getName()))) {
				System.out.println("입력한 이름이 없습니다.");
			} else if(!(paper.getPassword().equals(account.getPassword()))) {
				System.out.println("입력한 패스워드가 틀립니다.");
			} else if(!(paper.getAccountNumber().equals(account.getAccountNumber()))) {
				System.out.println("입력한 계좌번호가 틀립니다.");
			} else if(paper.getMoney() <= 0) {
				System.out.println("금액이 입력되지 않았습니다.");
			}
			else {
				result = true;
				System.out.println("정보 확인이 완료되었습니다.");
			}
		} else {
			System.out.println("입력한 계좌번호의 고객이 존재하지 않습니다.");
		}
			
		return result;
	}
	
	
	/**
	 * 은행 직원이 관리하는 고객 리스트 생성
	 * @return AccountList 고객 리스트
	 */
	public AccountVo[] createAccountList() {
		String[] names = {"홍길동","이순신","김유신"};
		String[] numbers = {"kb-1234","kb-9876","kb-3456"};
		String[] passwords = {"1234","9876","3456"};
		int[] balances = {500,1000,700};
		
		AccountVo[] list = new AccountVo[names.length];
		
		for(int i = 0; i < names.length; i++) {
			AccountVo account = new AccountVo();
			account.setName(names[i]);
			account.setAccountNumber(numbers[i]);
			account.setPassword(passwords[i]);
			account.setBalance(balances[i]);
			
			list[i] = account;
		}
		
		return list;
	}
	
	/**
	 * 고객 정보 출력
	 */
	public void showAccountList() {
		int count = 0;
		for(AccountVo account : accountList) {
			System.out.println("======" + (++count) + "번째======");
			System.out.println("이름    : " + account.getName());
			System.out.println("계좌번호 : " + account.getAccountNumber());
			System.out.println("잔고금액 : " + account.getBalance());			
			System.out.println("패스워드 : " + account.getPassword());			
			System.out.println("=================");
		}
		
	}
	
	
}
