package drink;

import java.util.Scanner;

import commons.Menu;

public class OrderSystem {
	// Field
	// Scanner
	Scanner scan = new Scanner(System.in);
	// 메뉴 이름
	String[] names = {"☕아메리카노","🍵바닐라라떼","🥤딸기쉐이크"};
	// 메뉴 가격
	int[] price = {2800,3500,4000};
	// 메뉴 리스트
	Menu[] menuList;
	// 주문 메뉴
	Order order;
	// 메뉴 결제
	Payment payment;
	// 가게 이름
	String title;
	
	// Constructor
	public OrderSystem() {
		this("Mega");
	}

	// Constructor
	public OrderSystem(String title) {
		this.title = title;
		init();
	}
	
	// Method
	// 초기화
	public void init() {
		payment = new Payment();
		// 메뉴의 이름, 가격 설정
		createMenuList();
		showMenu();
		orderMenu();
		processpayment();
	}
	/*
	 * 메뉴의 이름, 가격 설정
	 */
	public void createMenuList() {
		// menuList 배열의 크기 설정
		menuList = new Menu[names.length];
		// 메뉴 리스트 설정
		for(int i = 0; i < names.length; i++) {
			// Menu생성자를 통한 설정(no, name, price)
			Menu menu = new Menu(i+1,names[i],price[i]);
			menuList[i] = menu;
		}
	}
	
	/*
	 * 메뉴판 표시
	 */
	public void showMenu() {
		System.out.println("========= " + title +" coffe =========");
		// 설정된 메뉴 출력
		for(Menu menu : menuList) {
			System.out.println(menu.getNo() + ". " + menu.getName() + " - " + changeFomat(menu.getPrice()) +"원");
		}
		System.out.println("==============================");
	}
	
	public void orderMenu() {
		System.out.print("=> 메뉴 선택(숫자), 종료(9): ");
		
		// 숫자를 입력했을 경우
		if(scan.hasNextInt()) {
			int selectMenu = scan.nextInt();
			// 1~3을 입력했을 경우
			if(selectMenu >= 1 && selectMenu <= 3) {
				// 메뉴 주문
				placeOrder(selectMenu);
			}
			// 9입력시 종료
			else if(selectMenu == 9) {
				System.out.println("시스템 종료");
				System.exit(0);
			} 
			else {
				System.out.println("메뉴 준비중입니다.");
				orderMenu();
			}
		} else {
			System.out.println("올바르지 않은 입력값입니다.");
			scan.next();
			orderMenu();
		}
	}
	
	// 메뉴 검색
	public Menu searchMenu(int selectMenu) {
		Menu resultMenu = new Menu();
		
		for(Menu menu : menuList) {
			// 선택한 메뉴가 메뉴리스트의 no와 같을경우
			if(menu.getNo() == selectMenu) {
				resultMenu = menu;
				break;
			}
		}
		return resultMenu;
	}
	
	// 메뉴 주문
	public void placeOrder(int selectMenu) {
		order = new Order(searchMenu(selectMenu));
		if(order != null) {
			order.getInfo();
			System.out.println("=> 주문완료");
		} else {
			System.out.println("order is null!!");
		}
	}
	
	// 메뉴 결제
	public void processpayment() {
		System.out.print("=> 결제할 금액 입력 : ");
		
		// 숫자를 입력했을 경우
		if(scan.hasNextInt()) {
			payment.setAmount(scan.nextInt());
			System.out.println("총 입금 금액 : " + changeFomat(payment.getAmount()) + "원");
			// 입금한 총 금액이 결제액 이상일 경우
			if(payment.setPayment(order.orderMenu.getPrice())) {
				System.out.println("=> 결제 완료");
				System.out.println("잔액 : " + changeFomat(payment.getChange()) + "원");
				init();
			} else {
				System.out.println("=> 결제 금액 부족");
				processpayment();
			}
		} else {
			System.out.println("올바르지 않은 입력값입니다.");
			scan.next();
			processpayment();
		}
	}
	
	// 금액에 대해 ,표시 설정
	public String changeFomat(int num) {
		return String.format("%,d", num);
	}
}