package vendingMachin_Ver1;

import commons.Menu;

public class VendingMachine {
	// Field
	String[] nameList = {"☕ 밀크커피","☕ 아메리카노","🍋 유자차","🥛 우유"};
	int[] priceList = {300,400,300,200};
	Menu[] menuList;
	String title;
	
	// Constructor
	public VendingMachine() {
		this("막심");
	}
	public VendingMachine(String title) {
		this.title = title;
		// 메뉴 리스트 생성
		createMenuList();
		// 메뉴 출력
		showMenuList();
	}
	// Method
	// 메뉴 리스트 생성
	public void createMenuList() {
		menuList = new Menu[nameList.length];
		
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
	public void showMenuList() {
		System.out.println("========= "+ title +" 메뉴판 =========");
		for(Menu menu : menuList) {
			System.out.print(menu.getNo() + ".");
			System.out.print(menu.getName() + " - ");
			System.out.println(menu.getPrice() + "원");
		}
		System.out.println("=============================");
	}
}