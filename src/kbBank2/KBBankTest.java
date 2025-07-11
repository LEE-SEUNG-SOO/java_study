package kbBank2;

public class KBBankTest {

	public static void main(String[] args) {
		boolean validateFlag = true;
		// 뱅크시스템 가동(고객 정보 리스트 생성)
		BankSystem bankSystem = new BankSystem();
		
		// 뱅크 시스템의 정보 확인
		bankSystem.showAccountList();

		// 입출금 용지 생성
		AccountPaperVo accountPaper = AccountPaperVo.getInstance();
		
		// 은행직원
		BankMan staff = new BankMan("박보검", bankSystem);

		// 고객 입장
		Customer hong = new Customer("홍길동","kb-123","123",0);
		
		// 입출금 용지 작성
		hong.setAccountPaper(accountPaper);
		
		// 입출금 용지 확인
		AccountPaperVo.showInfo();
		
		// 직원이 입출금 용지를 받음
		staff.setAccountPaper(hong.getAccountPaper());
		
		// 직원이 입출금 용지 확인(빈값 확인)
		validateFlag = staff.checkValidate(staff.getAccountPaper());
		
		// 입출금 용지 반복 확인
		while(validateFlag) {
			
			// 추가 입력한 값에 유효성 체크 반복 실시 결과 모든 값이 입력됬을 경우
			if(!staff.checkValidate(hong.answer(staff.result))) {
				// 반복문 종료
				validateFlag = false;
			}
		}
		
		// 출금 처리
		staff.processWithDrawal();
				
		// 출금 후 계좌 정보 출력
		bankSystem.confirmMoney(hong.getAccountPaper());
	}
}

