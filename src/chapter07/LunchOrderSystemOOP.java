package chapter07;

import java.util.Scanner;

public class LunchOrderSystemOOP {
	// Field
	Scanner scan = new Scanner(System.in);
	// 런치 메뉴 이름
	String[] lunchMenuNames = {"햄버거(🍔)", "피이자(🍕)", "라아면(🍜)", "샐러드(🥗)"};
	// 런치 메뉴 가격
	int[] lunchMenuPrice = {100, 200, 300, 400};
	// 주문 건수
	int orderCount = 0;
	// 결제 금액(사용자의 입력)
	int amount = 0;
	// 잔액
	int change = 0;
	
	// 주문할 메뉴 : LunchMenu
	LunchMenu[] lunchMenuList = new LunchMenu[4];
	// 주문할 메뉴 리스트
	LunchOrderItem[] orderItemList = new LunchOrderItem[4];
	// 결제 내역
	LunchPaymentItem paymentItem;
	
	// Constructor
	// Method
	/*
	 * 런치 메뉴 생성
	 */
	public void createLunchMenu() {
		// luchMenuList에 메뉴명, 가격 설정
		for(int i = 0; i < lunchMenuNames.length; i++) {
			LunchMenu menu = new LunchMenu();
			menu.name = lunchMenuNames[i];
			menu.price = lunchMenuPrice[i];
			menu.no = i + 1;
			
			lunchMenuList[i] = menu;
		}
	}
	
	/*
	 * 런치 메뉴 출력
	 */
	public void showLunchMenu() {
		System.out.println("*************************************************");
		// 런치 메뉴 출력
		for(LunchMenu lunchmenu : lunchMenuList) {
			System.out.print(lunchmenu.no + ". ");
			System.out.print(lunchmenu.name + "\t");
			System.out.println(lunchmenu.price + "원");
		}
		System.out.println("*************************************************");
		// 런치 메뉴 선택
		selectLunchMenu();
	}
	
	/*
	 * 런치 메뉴 선택
	 */
	public void selectLunchMenu() {
		System.out.print("런치 메뉴를 선택해주세요.(숫자) : ");
		
		if(scan.hasNextInt()) {
			int mainMenu = scan.nextInt();
			// 런치 메뉴 확인
			lunchMenuCheck(mainMenu);	
		} else {
			System.out.println("=> 숫자를 입력해주세요.");
			scan.next();
			// 런치 메뉴 선택
			selectLunchMenu();
		}
	}
	
	/*
	 * 메인 메뉴 출력
	 */
	public void showMainMenu() {
		// 메뉴판
		System.out.println("*************************************************");
		System.out.println("\t @@@@Welcom to Food Mart@@@@");
		System.out.println("*************************************************");
		System.out.println("\t 1. 음식 주문");
		System.out.println("\t 2. 주문 내역");
		System.out.println("\t 3. 음식 결제");
		System.out.println("\t 4. 결제 내역");
		System.out.println("\t 9. 프로그램 종료");
		System.out.println("*************************************************");
		System.out.println("************Food Mart에 오신것을 환영합니다***********");

		// 런치 메뉴 생성
		createLunchMenu();
		// 메인 메뉴 선택
		selectMainMenu();
		
	} // showMainMenu
	
	/*
	 * 메인 메뉴 선택
	 */
	public void selectMainMenu() {
		System.out.print("메인 메뉴를 선택해주세요.(숫자) : ");
		
		if(scan.hasNextInt()) {
			int mainMenu = scan.nextInt();
			mainMenuCheck(mainMenu);	
		} else {
			System.out.println("=> 숫자를 입력해주세요.");
			scan.next();
			selectMainMenu();
		}
	}
	
	/*
	 * 메인 메뉴 확인
	 */
	public void mainMenuCheck(int mainMenu) {
		switch(mainMenu) {
		// 1. 음식 주문
		case 1:
			showLunchMenu();
			showMainMenu();
			break;
		// 2. 주문 내역
		case 2:
			orderList();
			showMainMenu();
			break;
		// 3. 음식 결제
		case 3:
			payment();
			showMainMenu();
			break;
		// 4. 결제 내역
		case 4:
			paymentList();
			showMainMenu();
			break;
		// 9. 시스템 종료
		case 9:
			System.out.println(" -- 음식 주문 시스템을 종료합니다 --");
			System.exit(0);
			break;
		default:
			System.out.println("=> 메뉴 준비중입니다.");
			showMainMenu();
		}
	}
	
	/*
	 * 런치 메뉴 확인
	 */
	public void lunchMenuCheck(int lunchMenu) {
		// lunchMenu : 1~4이면 주문가능, 그외는 메뉴 준비중 다시 입력
		if(lunchMenu >= 1 && lunchMenu <= 4 ) {
			// 주문 진행 : order메소드 실행
			order(lunchMenu);			
		} else {
			System.out.println("=> 메뉴 준비중입니다.");
			showLunchMenu();
		}
	}
	
	/*
	 * 기존 주문 이력 검색
	 */
	public int searchOrderItemIdx(int lunchMenu) {
		int idx = -1;
		// 주문 내역 리스트에서 선택한 메뉴와 일치하는 인덱스 추출
		for(int i = 0; i < orderCount; i++) {
			if(orderItemList[i].lunchMenu.no == lunchMenu) {
				idx = i;
			}
		}
		
		return idx;
	}
	
	/*
	 * 주문 리스트 초기화
	 */
	public void orderItemListInit() {
		// for문을 사용한 주문 리스트 초기화
		for(LunchOrderItem orderItem : orderItemList) {
			if(orderItem != null) {
				orderItem = null;
			}
		}
		
		// 주문 리스트 초기화(new생성자 사용)
		//orderItemList = new LunchOrderItem[4];
		orderCount = 0;
		// 입금 금액 초기화
		amount = 0;
	}
	
	/*
	 * 1. 음식 주문 order()
	 */
	public void order(int lunchMenu) {
	
		// lunchMenuList의 메뉴 번호 확인
		for(LunchMenu menu : lunchMenuList) {
			if(menu.no == lunchMenu) {
				// 기존 주문 이력 검색
				int idx = searchOrderItemIdx(lunchMenu);
				// 기존 주문 이력이 없을경우
				if(idx == -1) {
					orderItemList[orderCount] = new LunchOrderItem();
					orderItemList[orderCount].lunchMenu = menu;
					orderItemList[orderCount].qty = 1;
					orderCount++;
				} 
				// 기존 주문 이력이 있을경우, qty값 1증가
				else {
					orderItemList[idx].qty += 1;
				}
				System.out.println("=> 주문 완료");
				break;
			}
		}
	}	
	
	/*
	 * 2. 주문 내역 orderList()
	 */
	public void orderList() {
		// 주문 건수가 존재할 경우
		if(orderCount > 0) {
			// 주문 내역 출력
			System.out.println("********************주문 내역*********************");
			System.out.println("메뉴번호\t메뉴명\t\t가격\t수량");
			for(LunchOrderItem orderItem : orderItemList) {
				if(orderItem != null) {				
					System.out.print(orderItem.lunchMenu.no + "\t");
					System.out.print(orderItem.lunchMenu.name + "\t");
					System.out.print(orderItem.lunchMenu.price + "\t");
					System.out.print(orderItem.qty + "\n");
				}
			}
			System.out.println("************************************************");
			
		} else {
			System.out.println("=> 주문한 이력이 없습니다. 먼저 음식 주문을 선택해주세요.");
		}
	}
	
	/*
	 * 3. 음식 결제 payment()
	 */
	public void payment() {
		// 주문 건수가 존재할 경우
		if(orderCount > 0) {
			int totalPayment = totalPayment();
		
			System.out.println("결제 예정 금액 : " + totalPayment);
			System.out.println("입금 금액 : " + amount);
			System.out.print("금액을 입력해주세요. : ");
			
			if(scan.hasNextInt()) {
				// 입금 금액
				amount += scan.nextInt();
				
				// 총 입금액 >= 결제 예정 금액
				if(amount >= totalPayment) {
					// 주문한 목록 출력
					orderList();

					System.out.println("입금 금액 : " + amount);
					System.out.println("결제 금액 : " + totalPayment);
					System.out.println("잔액 : " + (amount - totalPayment));
					System.out.println("=> 결제 완료");

					// 주문 이력 설정
					paymentItem = new LunchPaymentItem();
					paymentItem.name = orderItemList[0].lunchMenu.name + "등";
					paymentItem.amount = amount;
					paymentItem.totalPayment = totalPayment;
					paymentItem.change = (amount - totalPayment);
					
					// 주문 내역 초기화
					orderItemListInit();

				} else {
					System.out.println("요금이 부족합니다. 추가 입력해주세요.");
					payment();
				}
			}else {
				System.out.println("올바르지 않은 입력입니다.");
				scan.next();
			}
			
		} else {
			System.out.println("=> 주문한 이력이 없습니다. 먼저 음식 주문을 선택해주세요.");
		}
	}
	
	/*
	 * 결제 예정 금액 계산
	 */
	public int totalPayment() {
		// 결제 예정 금액
		int totalPayment = 0;
		
		for(LunchOrderItem orderItem : orderItemList) {
			if(orderItem != null) {
				// 주문 내역의 총합
				totalPayment += (orderItem.lunchMenu.price * orderItem.qty) ;
			}
		}
		
		return totalPayment;
	}
	
	/*
	 * 4. 결제 내역 paymentList()
	 */
	public void paymentList() {
		// 결제 건수가 존재할 경우
			if(paymentItem != null) {
				// 결제 내역 출력
				System.out.println("********************결제 내역*********************");
				System.out.println("메뉴명\t\t입금액\t결제금액\t잔액");
				System.out.print(paymentItem.name + "\t");
				System.out.print(paymentItem.amount + "\t");
				System.out.print(paymentItem.totalPayment+ "\t");
				System.out.print(paymentItem.change + "\n");
				System.out.println("************************************************");
				
			} else {
				System.out.println("=> 주문한 이력이 없습니다. 먼저 음식 주문을 선택해주세요.");
			}
	}
	
} // class
