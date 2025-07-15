package drink_interface;

public class Payment {
	// Field
	int amount;
	int change;
	
	// Constructor
	public Payment() {
		
	}
	
	// Method
	public int getAmount() {
		return amount;
	}
	
	// amount 설정
	public void setAmount(int amount) {
		this.amount += amount;
	}
	
	// change 설정
	public boolean setPayment(int total) {
		// 결제 완료 플래그
		boolean paymentFlag = false;
		// 입금 금액이 결제 금액 이상일 경우
		if(amount >= total) {
			// 잔액 계산
			change = amount - total;
			// 결제 완료 플래그 변경
			paymentFlag = true;
		}
		
		return paymentFlag;
	}
	
	// change를 반환
	public int getChange() {
		return change;
	}

}
