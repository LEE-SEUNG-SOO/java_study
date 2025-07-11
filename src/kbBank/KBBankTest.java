package kbBank;

public class KBBankTest {

	public static void main(String[] args) {
		//입출금 용지 한장 비치됨
		AccountPaperVo paper = AccountPaperVo.getInstance();
		
		BankMan staff = new BankMan("박보검");
		staff.showAccountList();
		
		// 고객 입장
		Customer customer = new Customer("홍길동","kb-1234","1234",0);
		// 용지 작성
		customer.setPaper(paper);
		// 은행 직원에게 용지 전달
		staff.setPaper(customer.getPaper());
		// 은행직원이 용지확인
		boolean result = staff.checkPaper();

		// 용지 내용에 부족한 내용이 존재할 경우
		while(!result) {
			// 고객이 금액을 입력
			customer.answerMoney(paper);
			// 은행 직원이 용지확인
			result = staff.checkPaper();
		}
		// 출금 처리를 하고, 잔액 400만원으로 업데이트
		staff.changeProcess();
		// 고객이 잔액을 확인하고 퇴장
		//customer.confirmBalance();
	}
}

