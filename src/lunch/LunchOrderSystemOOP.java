package lunch;

import java.util.Scanner;

public class LunchOrderSystemOOP {
	// Field
	Scanner scan;// = new Scanner(System.in);
	// 메뉴관련메소드클래스
	LunchOrderMenuManager menuManager;
	// 런치 메뉴 이름
	String[] lunchMenuNames = {"햄버거(🍔)", "피이자(🍕)", "라아면(🍜)", "샐러드(🥗)"}; // 선언 + 할당
	// 런치 메뉴 가격
	int[] lunchMenuPrice = {100, 200, 300, 400};
	// 타이틀명
	String title;
	// 주문 건수
	int orderCount = 0;
	// 결제 금액(사용자의 입력)
	int amount = 0;
	// 잔액
	int change = 0;
	
	// 주문할 메뉴 : LunchMenu
	LunchMenu[] lunchMenuList;// = new LunchMenu[4];
	// 주문할 메뉴 리스트
	LunchOrderItem[] orderItemList;// = new LunchOrderItem[4];
	// 결제 내역
	LunchPaymentItem paymentItem;
	
	// Constructor
	// 기본 생성자
	public LunchOrderSystemOOP() {
		scan = new Scanner(System.in);
//		menuManager = new LunchOrderMenuManager(lunchMenuNames, lunchMenuPrice);
		// this : LunchOrderSystemOOP의 주소를 파라미터로 설정
		lunchMenuList = new LunchMenu[4];
		orderItemList = new LunchOrderItem[4];
		menuManager = new LunchOrderMenuManager(this);
		// 생성자 실행시 런치 메뉴 생성 메소드 실행
		menuManager.createLunchMenu();
	}
	// String타입의 파라미터를 받는 생성자
	public LunchOrderSystemOOP(String title) {
		this.title = title;
		scan = new Scanner(System.in);
//		menuManager = new LunchOrderMenuManager(lunchMenuNames, lunchMenuPrice);
		// this : LunchOrderSystemOOP의 주소를 파라미터로 설정
		lunchMenuList = new LunchMenu[4];
		orderItemList = new LunchOrderItem[4];
		menuManager = new LunchOrderMenuManager(this);
		// 생성자 실행시 런치 메뉴 생성 메소드 실행
		menuManager.createLunchMenu();
		// 생성자 호출시 실행
		menuManager.showMainMenu();
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
		orderItemList = new LunchOrderItem[4];
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
