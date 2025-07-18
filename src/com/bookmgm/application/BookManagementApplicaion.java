package com.bookmgm.application;

import java.util.Scanner;

import com.bookmgm.service.BookService;
import com.bookmgm.service.DefaultBookService;

public class BookManagementApplicaion {
	
	public static final int REGISTER = 1;
	public static final int LIST = 2;
	public static final int SEARCH = 3;
	public static final int UPDATE = 4;
	public static final int DELETE = 5;
	public static final int SELECTREPOSITORY = 6;
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
				case REGISTER:
					service.register();
					showMenu();
					break;
				case LIST:
					service.list();
					showMenu();
					break;
				case SEARCH:
					service.search();
					showMenu();
					break;
				case UPDATE:
					service.update();
					showMenu();
					break;
				case DELETE:
					service.delete();
					showMenu();
					break;
				case SELECTREPOSITORY:
					service.selectRepository();
					showMenu();
					break;
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
