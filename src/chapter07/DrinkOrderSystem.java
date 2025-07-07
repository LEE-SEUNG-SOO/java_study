package chapter07;

import java.util.ArrayList;
import java.util.Scanner;

public class DrinkOrderSystem {
	// Field
	Scanner scan = new Scanner(System.in);
	// 메뉴
	DrinkMenu[] drinkMenu = new DrinkMenu[3];
	// 드링크 오더
	DrinkOrder drinkOrder;
	// 주문 가격
	DrinkPayment drinkPayment;
	// 메뉴 이름
	String[] menuName = {"☕아메리카노","🍵바닐라라떼","🥤딸기쉐이크"};
	// 메뉴 가격
	int[] menuPrice = {2800,3500,4000};
	// 선택한 메뉴 번호 설정
	int selectMenuNumber = 0;
	// 입금 금액
	int payment = 0;
	
	// Constructor
	
	// Method
	
	// 메뉴 설정
	public void setMenu() {
		// drinkMenu객체에 메뉴 설정
		for(int i = 0; i < drinkMenu.length; i++) {
			drinkMenu[i] = new DrinkMenu();
			drinkMenu[i].name = menuName[i];
			drinkMenu[i].price = menuPrice[i];
		}
	}
	
	// 메뉴판 출력
	public void menuList() {
		// 메뉴 설정
		setMenu();
		
		// 메뉴판 표시
		showMenu();
		
		// 메뉴 선택
		selectMenu();
		
		// 주문 이력
		showSelectMenu();
		
		// 결제
		payment();
	}
	
	
	// 메뉴판 표시
	public void showMenu() {
		System.out.println("=== 메뉴판 ===");
		// 설정된 메뉴 출력
		for(int i = 0; i < menuName.length; i++) {
			System.out.println(i+1 + ". " + drinkMenu[i].name + " - " + changeFomat(drinkMenu[i].price) +"원");
		}
	}
	
	// 메뉴 선택
	public void selectMenu() {
		System.out.print("주문할 메뉴 번호 입력> ");
		
		if(scan.hasNextInt()) {
			int number = scan.nextInt();
			// 입력된 값이 1~3일 경우
			if(number >= 1 && number <= 3) {
				// drinkOrder객체 설정
				drinkOrder = new DrinkOrder();
				// 주문 메뉴 번호 설정
				drinkOrder.drinkNumber = number - 1;
				// 주문 메뉴의 갯수 설정
				drinkOrder.count++;
				// 주문 메뉴의 총합금액
				drinkOrder.sum = drinkMenu[number-1].price * drinkOrder.count;		
			} else {
				System.out.println("=> 준비중 입니다");
				selectMenu();
			}
			
		} else {
			System.out.println("=> 올바르지 않은 입력값 입니다.");
			scan.next();
			selectMenu();
		}
	}
	
	// 금액에 대해 ,표시 설정
	public String changeFomat(int num) {
		return String.format("%,d", new Object[] {num});
	}
	
	// 주문 이력
	public void showSelectMenu() {	
		System.out.print("=> 주문 메뉴 : ");
		System.out.print(drinkMenu[drinkOrder.drinkNumber].name + ", ");
		System.out.println("결제 예정 금액 : " + changeFomat(drinkOrder.sum) +"원");
	}
	
	// 결제
	public void payment() {
		System.out.print("결제할 금액 입력 : ");
		
		if(scan.hasNextInt()) {
			payment += scan.nextInt();
			System.out.println("총 입금 금액 : " + changeFomat(payment) +"원");
			
			// 입금 총합이 결제 금액보다 클경우
			if(payment >= drinkOrder.sum) {
				drinkPayment = new DrinkPayment();
				// 잔액
				drinkPayment.change = (payment - drinkOrder.sum);
				// 지불 금액
				drinkPayment.payment = payment;
				
				System.out.println("=> 결제 완료! 잔돈 : " + changeFomat(drinkPayment.change) + "원");
			} else {
				System.out.println("금액이 부족합니다. 다시입력해주세요.");
				payment();
			}
			
		} else {
			System.out.println("=> 올바르지 않은 입력값 입니다.");
			scan.next();
			payment();
		}
	}
}
