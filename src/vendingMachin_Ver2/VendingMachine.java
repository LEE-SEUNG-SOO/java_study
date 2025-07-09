package vendingMachin_Ver2;

import commons.Menu;

public class VendingMachine {
	// Field
	public static final String[] NAMELIST = {"☕ 밀크커피","☕ 아메리카노","🍋 유자차","🥛 우유 "};
	public static final int[] PRICELIST = {300,400,300,200};
	public static final int MAX_NUM = NAMELIST.length;
	Menu[] menuList = new Menu[VendingMachine.MAX_NUM];
	Menu[] orderMenuList = new Menu[VendingMachine.MAX_NUM];
	int coin;
	User user;
	
	// Constructor
	// 메뉴 생성
	public VendingMachine() {
		// 메뉴 생성
		createMenu();
	}
	
	// Method
	public void init() {
		// 메뉴리스트 설정
		coin = 0;
		orderMenuList = new Menu[VendingMachine.MAX_NUM];
	}
		
	// 메뉴 생성
	public void createMenu() {
		for(int i = 0; i < VendingMachine.MAX_NUM; i++) {
			menuList[i] = new Menu();
			Menu menu = menuList[i];
			
			menu.setNo(i+1);
			menu.setName(NAMELIST[i]);
			menu.setPrice(PRICELIST[i]);
		}
	}
	
	// 메뉴 출력
	public void viewMenu(Menu[] menuList) {
		System.out.println("========= 메뉴판 =========");
		for(Menu menu : menuList) {
			if(menu != null) {
				System.out.print(menu.getNo() + ".");
				System.out.print(menu.getName() + "\t");
				System.out.println(menu.getPrice() + "원");
			}
		}
		System.out.println("=============================");
	}
	
	// 동전 입금
	public void acceptCoin() {
		System.out.print(user.name + "님 동전을 넣어주세요.(100원 또는 500원) : ");
		int checkCoin = user.insertCoin();
		
		// 입력한 값이 100 또는 500이 아닐경우
		if(!(checkCoin == 100 || checkCoin == 500)) {
			System.out.println("100원 또는 500원만 입력가능합니다. 다시 입력해주세요.");
			acceptCoin();
		} else {
			// 입금 총액
			coin += checkCoin;
			
			// 입력한 총 금액이 최소 금액의 메뉴보다 작을경우
			if(!checkCoin(coin)) {
				System.out.println("금액이 부족합니다. 추가로 동전을 넣어주세요.");
				acceptCoin();
			} else {
				System.out.println("입금 금액 : " + coin);
				System.out.print(user.getName() + "님 추가 입금 하시겠습니까?(끝:n, 계속:n제외 아무키) : ");
				if(!user.scan.next().equals("n")) {
					acceptCoin();
				}
			}
		}
	}
	
	// 메뉴 주문
	public void orderMenu() {
		// 메뉴 표시
		viewMenu(orderMenuList);
		System.out.print(user.getName() + "님 메뉴를 선택해주세요.(숫자) : ");
		
		if(user.scan.hasNextInt()) {
			int orderMenu = user.getScan().nextInt();
			// 선택한 메뉴 설정
			if(orderMenuCheck(orderMenu)) {
				Menu menu = orderMenuList[orderMenu-1];	
				System.out.println(menu.getName() + " 제조중..");
				System.out.println(menu.getName() + " 제조완료");
				
				int change = payment(menu);
				
				// 잔액으로 계속 할지 체크
				finalCheck(change);
			} else {
				System.out.println("선택하신 메뉴는 주문 할 수 없습니다.");
				orderMenu();
			}
		} else {
			System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			user.scan.next();
			orderMenu();
		}
	}
	
	// 메뉴 결제
	public int payment(Menu menu) {
		int change = 0;
		// 잔액 입금 총액 - 선택 메뉴 가격
		change = coin - menu.getPrice();
		
		System.out.println("잔액 : " + change);
		
		return change;
	}

	// 코인 체크
	public boolean checkCoin(int checkCoin) {
		boolean checkFlag = false;
		
		for(int i = 0; i < VendingMachine.MAX_NUM; i++) {
			Menu menu = menuList[i];
			// 메뉴의 가격이 코인보다 작거나 같을경우
			if(menu.getPrice() <= checkCoin) {
				// 오더메뉴리스트에 해당 메뉴 추가
				orderMenuList[i] = menu;
				checkFlag = true;
			}	
		}
		return checkFlag;
	}
	
	// 파이널 체크
	public void finalCheck(int change) {
		// 초기화
		init();
		
		// 잔액으로 추가 주문이 가능할 경우
		if(checkCoin(change)) {
			System.out.println(user.getName() + "님 추가로 주문 하시겠습니까?(종료:n, 그외 계속주문)");
			
			// n입력시 종료
			if(user.scan.next().equals("n")) {
				System.out.println(user.getName() + "님 이용해주셔서 감사합니다.");
			} else {
				// 코인에 잔액을 넣는다
				coin = change;
				// 메뉴 주문
				orderMenu();
			}
		}
		// 잔액이 메뉴의 최소금액 보다 작을경우
		else {
			System.out.println("잔액이 부족하므로 종료됩니다.");
			System.out.println(user.getName() + "님 이용해주셔서 감사합니다.");
		}
	}
	
	// 주문 가능한 메뉴 체크
	public boolean orderMenuCheck(int orderMenu) {
		boolean result = false;
		
		// 주문 가능한 메뉴리스트에서 선택한 메뉴번호가 존재할경우 true
		for(Menu menu : orderMenuList) {
			if(menu != null) {
				if(menu.getNo() == orderMenu) {
					result = true;
					break;
				}
			}
		}
		
		return result;
	}
	
	// 유저 설정
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}
