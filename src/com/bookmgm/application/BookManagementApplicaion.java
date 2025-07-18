package com.bookmgm.application;

import java.util.Scanner;

import com.bookmgm.service.BookService;
import com.bookmgm.service.DefaultBookService;

public class BookManagementApplicaion {
	
	// 도서 등록
	public static final int REGISTER = 1;
	// 도서 목록
	public static final int LIST = 2;
	// 도서 검색
	public static final int SEARCH = 3;
	// 도서 수정
	public static final int UPDATE = 4;
	// 도서 삭제
	public static final int DELETE = 5;
	// 도서관 변경
	public static final int SELECTREPOSITORY = 6;
	// 종료
	public static final int EXIT = 7;
	
	public Scanner scan;
	public BookService service;	
	
	public BookManagementApplicaion() {
		scan = new Scanner(System.in);
		service = new DefaultBookService(this);
		showMenu();
	}
	
	/**
	 * 메뉴 표시
	 */
	public void showMenu() {
		String[] labels = {"도서 등록", "도서 목록 조회", "도서 검색", "도서 수정", "도서 삭제", "도서관 선택", "종료"};
		
		System.out.println("전체 도서수 : " + service.getCount());	
		System.out.println("========= 도서 관리 시스템 ==========");
		
		// 메뉴 표시
		for(int i = 0; i < labels.length; i++) {
			System.out.println("\t"+ (i+1) + ". " + labels[i]);
		}
		
		System.out.println("==================================");
		selectMenu();
	}

	/**
	 * 메뉴 선택
	 */
	public void selectMenu() {
		System.out.print("메뉴(숫자) : ");
		
		if(scan.hasNextInt()) {
			int menu = scan.nextInt();
			
			switch(menu) {
				// 도서 등록
				case REGISTER:
					service.register();
					showMenu();
					break;
				// 도서 목록
				case LIST:
					service.list();
					showMenu();
					break;
				// 도서 검색
				case SEARCH:
					service.search();
					showMenu();
					break;
				// 도서 수정
				case UPDATE:
					service.update();
					showMenu();
					break;
				// 도서 삭제
				case DELETE:
					service.delete();
					showMenu();
					break;
				// 도서관 변경
				case SELECTREPOSITORY:
					service.selectRepository();
					showMenu();
					break;
				// 종료
				case EXIT:
					service.exit();
					break;
				default :
					System.out.println("=> 메뉴 준비중 입니다.");
					selectMenu();
			}
			
		} else {
			System.out.println("=> 올바르지 않은 형식입니다. 다시 선택해주세요.");
			scan.next();
			selectMenu();
		}
	}
	
	public static void main(String[] args) {
		new BookManagementApplicaion();
	}

}
