package chapter05;

import java.util.Scanner;

/*
 * 음료 주문 시스템
 * 5.제어문_실습자료.md
 */
public class DrinkOrderTestVer1 {

	public static void main(String[] args) {
		// 변수 선언
		Scanner scan = new Scanner(System.in);
		String selectMenuName = "";
		int selectMenuPrice = 0;
		int paymentMoney = 0;
		String selectMenuPriceOutput = "";
		String charge = "";
		boolean menuSelctFlag = true;
		boolean paymentFlag = true;
		
		// 2.1 메뉴 출력 기능
		System.out.println("[시작]");
		System.out.println("=========== 메뉴판 ===========");
		System.out.println("1. ☕ 아메리카노 \t- 2,800원");
		System.out.println("2. 🍵 바닐라 라떼 \t- 3,500원");
		System.out.println("3. 🥤 딸기 쉐이크 \t- 4,000원");
		System.out.println("============================");

		// 2.2 음료 주문 기능
		while(menuSelctFlag) {
			System.out.print("주문할 메뉴 번호 입력> ");
			// 입력 값 확인(정수 판정)
			if(scan.hasNextInt()) {
				// 선택 메뉴 정보 저장
				switch(scan.nextInt()) {
				case 1:
					selectMenuName = "☕ 아메리카노";
					selectMenuPrice = 2800;
					menuSelctFlag = false;
					break;
				case 2:
					selectMenuName = "🍵 바닐라 라떼";
					selectMenuPrice = 3500;
					menuSelctFlag = false;
					break;
				case 3:
					selectMenuName = "🥤 딸기 쉐이크";
					selectMenuPrice = 4000;
					menuSelctFlag = false;
					break;
				default:
					// 메뉴 이외의 번호를 입력했을 경우
					System.out.println("준비중 입니다. 다시 입력해주세요.");
				}
			} else {
				// 정수 외의 값을 입력했을 경우
				System.out.println("올바르지 않은 입력값 입니다.다시 입력해주세요. ");
				scan.next();
			}
		}// 2.2 음료 주문 기능 끝
		
		// 출력용 메뉴가격 저장
		selectMenuPriceOutput = String.format("%,d", new Object[] {selectMenuPrice});
		// 선택 메뉴 확인
		System.out.println("주문 메뉴 : " + selectMenuName + ", 결제 예정 금액 : " + selectMenuPriceOutput + "원");

		// 2.3 결제 기능 시작
		while(paymentFlag) {
			System.out.print("결제할 금액 입력> ");
			// 입력값 확인(정수 판정)
			if(scan.hasNextInt()) {
				// 입력금액을 총 입금 금액에 중첩하여 대입
				paymentMoney += scan.nextInt();
				
				// 총 입금 금액 확인
				System.out.println("총 입금 금액 : " + String.format("%,d", new Object[] {paymentMoney}) + "원");
				
				// 총 입금 금액 >= 선택 메뉴 금액
				if(paymentMoney >= selectMenuPrice) {
					// 잔돈 출력
					charge = String.format("%,d", new Object[] {(paymentMoney - selectMenuPrice)});
					System.out.println("결제 완료! 잔돈: " + charge + "원");
					paymentFlag = false;
				} else {
					// 추가 입금 메세지 출력
					System.out.println("금액이 부족합니다. 다시 입력해주세요.");
				}
			} else {
				// 정수 외의 값을 입력했을 경우
				System.out.println("올바르지 않은 입력값 입니다.다시 입력해주세요. ");
				scan.next();
			}
		}// 2.3 결제 기능 시작 끝

		System.out.println("[종료]");
		System.out.println("이용해주셔서 감사합니다.");
	} // main 끝
}
