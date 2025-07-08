package lunch;

public class LunchOrderMenuManager {
	// Field
//	String[] lunchMenuNames;
//	int[] lunchMenuPrice;
	// LunchOrderSystemOOP클래스의 주소를 받기 위한 전역변수
	LunchOrderSystemOOP system;
	
	// Constructor
	public LunchOrderMenuManager() {
		
	}
//	public LunchOrderMenuManager(String[] lunchMenuNames,int[] lunchMenuPrice) {
//		this.lunchMenuNames = lunchMenuNames;
//		this.lunchMenuPrice = lunchMenuPrice;
//	}
	// 생성자를 통해 LunchOrderSystemOOP클래스의 주소를 받아 사용
	public LunchOrderMenuManager(LunchOrderSystemOOP system) {
		this.system = system;
	}
	// Method
	/*
	 * 런치 메뉴 생성
	 */
	public void createLunchMenu() {
		// luchMenuList에 메뉴명, 가격 설정
		for(int i = 0; i < system.lunchMenuNames.length; i++) {
			LunchMenu menu = new LunchMenu();
			menu.name = system.lunchMenuNames[i];
			menu.price = system.lunchMenuPrice[i];
			menu.no = i + 1;
			
			system.lunchMenuList[i] = menu;
		}
	}
	
	/*
	 * 런치 메뉴 출력
	 */
	public void showLunchMenu() {
		System.out.println("*************************************************");
		// 런치 메뉴 출력
		for(LunchMenu lunchmenu : system.lunchMenuList) {
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
		
		if(system.scan.hasNextInt()) {
			int mainMenu = system.scan.nextInt();
			// 런치 메뉴 확인
			lunchMenuCheck(mainMenu);	
		} else {
			System.out.println("=> 숫자를 입력해주세요.");
			system.scan.next();
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
		System.out.println("\t @@@@Welcom to ["+ system.title + "] Mart@@@@");
		System.out.println("*************************************************");
		System.out.println("\t 1. 음식 주문");
		System.out.println("\t 2. 주문 내역");
		System.out.println("\t 3. 음식 결제");
		System.out.println("\t 4. 결제 내역");
		System.out.println("\t 9. 프로그램 종료");
		System.out.println("*************************************************");
		System.out.println("************Food Mart에 오신것을 환영합니다***********");

		// Constructor에서 진행
//		// 런치 메뉴 생성
//		createLunchMenu();
		// 메인 메뉴 선택
		selectMainMenu();
		
	} // showMainMenu
	
	/*
	 * 메인 메뉴 선택
	 */
	public void selectMainMenu() {
		System.out.print("메인 메뉴를 선택해주세요.(숫자) : ");
		
		if(system.scan.hasNextInt()) {
			int mainMenu = system.scan.nextInt();
			mainMenuCheck(mainMenu);	
		} else {
			System.out.println("=> 숫자를 입력해주세요.");
			system.scan.next();
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
			system.orderList();
			showMainMenu();
			break;
		// 3. 음식 결제
		case 3:
			system.payment();
			showMainMenu();
			break;
		// 4. 결제 내역
		case 4:
			system.paymentList();
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
			system.order(lunchMenu);			
		} else {
			System.out.println("=> 메뉴 준비중입니다.");
			showLunchMenu();
		}
	}
	
}
