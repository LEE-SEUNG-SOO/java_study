package vendingMachin_Ver1;

import commons.Menu;

public class VendingMachine {
	// Field
	// 종료 상수 설정
	// [접근제어자] [???] [???] [데이터타입] [변수명]
	public static final int EXIT = 0; // 클래스이름.상수명 으로 접근 가능(static을 붙이면)
	String[] nameList = {"☕ 밀크커피","☕ 아메리카노","🍋 유자차","🥛 우유 "};
	int[] priceList = {300,400,300,200};
	Menu[] menuList;
	Menu[] orderMenuList;
	// 자판기 회사명
	String title;
	// 자판기 사용자
	User user;
	// 사용자가 입금한 금액
	int coin;
	// 주문한 메뉴 갯수
	int orderMenuCount;
	// 잔액
	int change;
	// 주문한 메뉴
	Menu orderMenu;
	
	// Constructor
	public VendingMachine(User user) {
		this("막심", user);
	}
	public VendingMachine(String title, User user) {
		this.title = title;
		this.user = user;
		init();
		// 메뉴 리스트 생성
		createMenuList();
		// 메뉴 출력
		showMenuList(menuList);
		// 입력된 동전 체크
		checkInsertCoin();
	}
	
	
	// Method
	// 초기화
	public void init() {
		coin = 0;
		change = 0;
		orderMenuCount = 0;
		orderMenu = new Menu();
		orderMenuList = new Menu[nameList.length];
	}
	// 초기화
	public void init(int coin) {
		this.coin = coin;
		change = 0;
		orderMenuCount = 0;
		orderMenu = new Menu();
		orderMenuList = new Menu[nameList.length];
	}
	
	// 메뉴 리스트 생성
	public void createMenuList() {
		menuList = new Menu[nameList.length];
		orderMenuList = new Menu[nameList.length];
		
		// 메뉴 리스트 설정
		for(int i = 0; i < nameList.length; i++) {
			int no = i + 1;
			String name = nameList[i];
			int prices = priceList[i];
			// 메뉴 생성자 실행
			Menu menu = new Menu(no,name,prices);
			menuList[i] = menu;
		}
	}
	
	// 메뉴 출력
	public void showMenuList(Menu[] menuList) {
		System.out.println("========= "+ title +" 메뉴판 =========");
		for(Menu menu : menuList) {
			if(menu != null) {
				System.out.print(menu.getNo() + ".");
				System.out.print(menu.getName() + "\t");
				System.out.println(menu.getPrice() + "원");
			}
		}
		System.out.println("=============================");
	}

	// 메뉴 선택
	public void selectMenu() {
		// 선택 가능한 메뉴 표시
		showMenuList(orderMenuList);
		System.out.println("메뉴를 선택해주세요.");
		System.out.println("선택 취소시 [" + VendingMachine.EXIT + "]입력");
		// 메뉴 선택
		int menuNo = user.selectMenu();
		
		// 0 이외의 숫자 입력
		if(menuNo != VendingMachine.EXIT) {
			// 선택한 메뉴 체크
			if(menuCheck(menuNo)) {
				// 주문
				placeOrder();
			}
			else {
				System.out.println("선택한 메뉴는 선택 할 수 없습니다. 다시 선택해주세요.");
				selectMenu();
			}
		} else {
			System.out.println("**********************************************");
			System.out.println("=> 동전 반환 : " + coin);
			System.out.println("=> 이용해주셔서 감사합니다.");
		}
	}
	
	// 메뉴 체크
	public boolean menuCheck(int menuNo) {
		boolean result = false;
		orderMenu = new Menu();
		
		// 선택한 메뉴가 선택가능한 메뉴에 있는지 확인
		for(int i = 0; i < orderMenuCount; i++) {
			Menu menu = orderMenuList[i];
			if(menu.getNo() == menuNo) {
				orderMenu = menu;
				i = orderMenuCount;
			}
		}
		
		// 선택한 메뉴가 존재할경우
		if(orderMenu != null) {
			result = true;
		} 
		
		return result;
	}
	
	// 입력된 동전 체크
	public void checkInsertCoin() {
		System.out.println("=> 동전을 투입해 주세요.");
		int insertCoin = user.insertCoin();
		
		// 입력한 값이 100원 또는 500원 일경우
		if(coinCheck(insertCoin)) {
			// coin에 입력한값 플러스
			coin += insertCoin;
			System.out.println("총 투입 금액 : " + coin);
			
			// 메뉴 선택 최소 금액 체크
			if(checkMenu()) {
				// System.out.println("최소 금액 충족, 메뉴 선택");
				System.out.print("=> 메뉴 선택(n), 동전 투입(n이외 아무키) : ");
				if(user.scan.next().equals("n")) {
					// 메뉴 선택
					selectMenu();
				} else {
					// 입력된 동전 체크(재귀)
					checkInsertCoin();
				}
			} else {
				System.out.println("=> 최소 금액 부족");
				// 입력된 동전 체크(재귀)
				checkInsertCoin();
			}
			
		} else {
			System.out.println("100원 또는 500원 동전만 사용가능합니다.");
			System.out.println("=> 동전 반환");
			// 입력된 동전 체크(재귀)
			checkInsertCoin();
		}
	}
	
	// 코인 체크
	public boolean coinCheck(int coin) {
		// 체크결과
		boolean checkFlag = false;
		
		// 입력한 값이 100원 또는 500원 일경우
		if(coin == 100 || coin == 500) {
			// 체크결과 = true
			checkFlag = true;
		}		
		return checkFlag;
	}
	
	// 선택 가능한 메뉴 체크
	public boolean checkMenu() {
		boolean flag = false;
		
		// 주문 가능한 메뉴 리스트 생성
		createOrderMenuList();

		// 주문 가능한 메뉴 리스트에 값이 있을경우
		if(orderMenuCount > 0) {
			flag = true;
		}
		
		return flag;
	}
	
	// 주문 가능한 메뉴 리스트 생성
	public void createOrderMenuList() {
		orderMenuCount = 0;
		
		for(Menu menu : menuList) {
			// 메뉴의 금액이 입금금액보다 작을경우 주문 가능한 메뉴 리스트에 추가
			if(menu.getPrice() <= coin) {
				// 주문 가능한 메뉴 리스트에 해당 메뉴를 추가
				orderMenuList[orderMenuCount] = menu;
				orderMenuCount++;
			}
		}
	}
	
	// 주문
	public void placeOrder() {
		String orderName = orderMenu.getName();
		
		System.out.println("주문 메뉴 : " + orderName);
		System.out.println("결제 예정 금액 : " + orderMenu.getPrice());
		System.out.println(orderName + " 제조중..");
		System.out.println(orderName + " 제조완료");
		
		processPayment();
	}
	
	// 결제
	public void processPayment() {
		if(orderMenu != null) {
			int price = orderMenu.getPrice();
			
			if(price <= coin) {
				change = coin - price;
			}
			
			System.out.println("=> 결제 완료");
			System.out.println("잔돈 : " + change);
		}
		
		finalCheck();
	}
	
	// 결제후 추가 결제 확인
	public void finalCheck() {
		coin = change;
		// 잔돈이 최소 주문금액보다 크면 계속 주문
		if(checkMenu()) {
			System.out.print("=> 추가 주문(n이외 아무키), 종료(n) : ");
			
			// n입력시 시스템 종료
			if(user.scan.next().equals("n")) {
				System.out.println("이용해 주셔서 감사합니다.");
				System.exit(0);
			} else {
				init(coin);
				// 잔돈으로 추가 주문
				createOrderMenuList();
				selectMenu();
				// 추가로 코인을 넣어서 주문
//				checkInsertCoin();
			}
		}		
	}
	
}