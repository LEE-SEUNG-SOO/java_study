package chapter21_mini_project.app;

import java.util.Scanner;

import chapter21_mini_project.service.BMPServiceImpl;

public class BookMiniProjectSystem {
	// 고객용
	public final int MENUGUESTINFO = 1;				// 고객 정보 확인
	public final int MENUCARTITEMLIST = 2;			// 장바구니 상품 목록 확인
	public final int MENUCARTCLEAR = 3;				// 장바구니 비우기
	public final int MENUCARTADDITEM = 4;			// 바구니에 항목 추가하기
	public final int MENUCARTREMOVEITEMCOUNT = 5;	// 장바구니의 항목 수량 줄이기
	public final int MENUCARTREMOVEITEM = 6;		// 장바구니의 항목 삭제하기
	public final int MENUCARTBILL = 7;				// 영수증 표시하기
	// 관리자 계정전용
	public final int MENUBOOKADDITEM = 1;			// 도서 등록(관리자 계정전용)
	public final int MENUTBOOKREMOVEITEM = 2;		// 도서 삭제(관리자 계정전용)
	public final int MENUBOOKUPDATEITEM = 3;		// 도서 수정(관리자 계정전용)
	// 종료
	public final int MENUEXIT = 8;					// 종료
	
	public Scanner scan;
	public BMPServiceImpl service;
	public boolean adminFlag = false;
	
	public BookMiniProjectSystem() {
		scan = new Scanner(System.in);
		service = new BMPServiceImpl(this);
		
		// 로그인
		login();
	}
	
	/**
	 * 로그인
	 */
	public void login() {
		// 이름
		String name = "";
		// 폰번호
		String phone;
		// 로그인 결과
		boolean flag = true;
		
		// 로그인에 성공 할때까지 반복
		while(flag) {
			System.out.print("이름을 입력하세요. : ");
			name = scan.next();
			
			System.out.print("연락처를 입력하세요.(010-1234-5678) : ");
			phone = scan.next();
			
			// 로그인
			if(service.login(name, phone)) {
				System.out.println("로그인 성공");
				flag = false;
			} else {
				System.out.print("로그인에 실패했습니다. 회원 가입을 하시겠습니까? ( Y / N )");
				String check = scan.next();
				
				// Y 또는 y를 입력시 회원가입
				if(check.equals("Y") || check.equals("y")) {
					System.out.print("주소를 등록해주세요. : ");
					String addr = scan.next();
					
					// 고객 테이블에 입력한 데이터 저장
					boolean result = service.createAccount(name, phone, addr);
					
					// insert 성공시
					if(result) {
						flag = false;
					}
				} else {
					System.out.println("이름과 연락처를 다시 입력해주세요.");
				}
			}
		}
		
		if(name.equals("admin")) {
			adminFlag = true;
		}
		
		// 관리자권한 확인
		if(adminFlag) {
			// 메뉴 표시(관리자 계정전용)
			showMenuAdmin();
			// 메뉴 선택(관리자 계정전용)
			selectMenuAdmin();
		} else {			
			// 메뉴 표시
			showMenu();
			// 메뉴 선택
			selectMenu();
		}
	}
	
	/**
	 * 메뉴 표시
	 */
	public void showMenu() {
		System.out.println("*************************************************************");
		System.out.println("\t	Welcome to Shopping Mall");
		System.out.println("\t	Welcome to Book Market!");
		System.out.println("*************************************************************");
		System.out.println("1. 고객 정보 확인하기\t 2. 장바구니 상품 목록 보기");
		System.out.println("3. 장바구니 비우기\t\t 4. 바구니에 항목 추가하기");
		System.out.println("5. 장바구니의 항목 수량 줄이기 6. 장바구니의 항목 삭제하기");
		System.out.println("7. 영수증 표시하기\t\t 8. 종료");		
		System.out.println("*************************************************************");
	}
	
	/**
	 * 메뉴 선택
	 */
	public void selectMenu() {
		int selectMenu = 0;
		System.out.print("메뉴 번호를 선택해주세요. : ");
				
		if(scan.hasNextInt()) {
			selectMenu = scan.nextInt();
			
			switch(selectMenu) {
				// 고객 정보 확인
				case MENUGUESTINFO :
					service.menuGuestInfo();
					break;
				// 장바구니 상품 목록 확인
				case MENUCARTITEMLIST :
					service.menuCartItemList();
					break;
				// 장바구니 비우기
				case MENUCARTCLEAR :
					service.menuCartClear();
					break;
				// 바구니에 항목 추가하기
				case MENUCARTADDITEM :
					service.menuCartAddItem();
					break;
				// 장바구니의 항목 수량 줄이기
				case MENUCARTREMOVEITEMCOUNT :
					service.menuCartRemoveItemCount();
					break;
				// 장바구니의 항목 삭제하기
				case MENUCARTREMOVEITEM :
					service.menuCartRemoveItem();
					break;
				// 영수증 표시하기
				case MENUCARTBILL :
					service.menuCartBill();
					break;
				// 종료
				case MENUEXIT :
					System.out.println("시스템 종료");
					service.menuExit();
					break;
				// 메뉴 이외의 값
				default :
					System.out.println("메뉴에 없는 번호입니다. 다시입력해주세요.");
					selectMenu();
			}
		} else {
			System.out.println("잘못된 입력입니다. 숫자로 입력해주세요.");
			scan.next();
			selectMenu();
		}
		
		showMenu();
		selectMenu();
	}
	
	/**
	 * 메뉴 표시(관리자 계정전용)
	 */
	public void showMenuAdmin() {
		System.out.println("*************************************************************");
		System.out.println("\t	Welcome to Shopping Mall");
		System.out.println("\t	Welcome to Book Market!");
		System.out.println("*************************************************************");
		System.out.println("1. 도서 등록\t 2. 도서 삭제");
		System.out.println("3. 도서 수정\t 8. 종료");
		System.out.println("*************************************************************");
	}	
	
	/**
	 * 메뉴 선택(관리자 계정전용)
	 */
	public void selectMenuAdmin() {
		int selectMenu = 0;
		System.out.print("메뉴 번호를 선택해주세요. : ");
				
		if(scan.hasNextInt()) {
			selectMenu = scan.nextInt();
			
			switch(selectMenu) {
				// 도서 등록(관리자 전용)
				case MENUBOOKADDITEM :
					// 도서 등록
					service.menuBookAddItem();
					break;
				// 도서 삭제(관리자 전용)
				case MENUTBOOKREMOVEITEM :
					// 도서 삭제
					service.menuBookRemoveItem();
					break;
				// 도서 수정(관리자 전용)
				case MENUBOOKUPDATEITEM :
					// 도서 삭제
					service.menuBookUpdateItem();
					break;
				// 종료
				case MENUEXIT :
					System.out.println("시스템 종료");
					service.menuExit();
					break;
				// 메뉴 이외의 값
				default :
					System.out.println("메뉴에 없는 번호입니다. 다시입력해주세요.");
					selectMenu();
			}
		} else {
			System.out.println("잘못된 입력입니다. 숫자로 입력해주세요.");
			scan.next();
			selectMenuAdmin();
		}
		
		showMenuAdmin();
		selectMenuAdmin();
	}	
}
