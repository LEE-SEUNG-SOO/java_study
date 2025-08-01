package com.bookmgm.service;

import java.util.List;
import java.util.Random;

import com.bookmgm.application.BookManagementApplicaion;
import com.bookmgm.model.BookVO;
import com.bookmgm.repository.BookRepository;

import db.GenericRepositoryInterface;

public class DefaultBookService implements BookService{
	BookManagementApplicaion bmApp;
	// 도서관 정보(테이블명)
	String table;
	// 도서 정보
	GenericRepositoryInterface<BookVO> repository;
	
	public DefaultBookService() {
	}
	
	public DefaultBookService(BookManagementApplicaion bmApp) {
		this.bmApp = bmApp;
		repository = new BookRepository(this);
		// 도서관 선택
		selectRepository();
	}
	
	/**
	 * 도서관 선택
	 */
	public void selectRepository() {
		System.out.println("1. 교육센터");
		System.out.println("2. 알라딘");
		System.out.println("3. yes24");
		System.out.print("도서관 선택 : ");
		int rno = bmApp.scan.nextInt();
		
		// 도서관 설정
		if(rno == 1) {
			setTable("book_tj");
			System.out.println("교육센터 도서관 선택");
		} else if(rno == 2) {
			setTable("book_aladin");
			System.out.println("알라딘 도서관 선택");
		} else if(rno == 3) {
			setTable("book_yes24");
			System.out.println("yes24 도서관 선택");
		} else {
			System.out.println("해당하는 도서관 없음");
			selectRepository();
		}
	}
	
	/**
	 * 도서 등록
	 */
	@Override
	public void register() {
		// book 객체 생성
		BookVO book = createBook();
		
		// repository에 도서 정보 등록
		if(repository.insert(book) != 0) {
			System.out.println("도서가 등록되었습니다.");
		} else {
			System.out.println("도서 등록에 실패하였습니다.");
		}
	}
	
	/**
	 * 도서 목록 조회
	 */
	@Override
	public void list() {
		// 등록된 도서가 존재할경우
		if(getCount() != 0) {
			List<BookVO> list = repository.findAll();

			System.out.println("[도서 목록 조회]");
			System.out.println("==================================");
			for(BookVO book : list) {
				printBook(book);
			}
			System.out.println("==================================");
			
		} else {
			System.out.println("등록된 도서가 존재하지 않습니다.");
		}
	}
	
	/**
	 * 도서 검색
	 */
	@Override
	public void search() {
		// 등록된 도서가 존재할경우
		if(getCount() != 0) {
			System.out.print("도서 번호 : ");
			String bid = bmApp.scan.next();
			
			// 도서 번호로 검색
			BookVO book = repository.find(bid);

			if(book != null) {
				System.out.println("[도서 목록 조회]");
				System.out.println("==================================");
				printBook(book);
				System.out.println("==================================");
			} else {
				System.out.println("검색한 도서가 존재하지 않습니다.");
			}
		} else {
			System.out.println("등록된 도서가 존재하지 않습니다.");
		}
	}
	/**
	 * 도서 번호로 정보 수정
	 */
	@Override
	public void update() {
		// 등록된 도서가 존재할경우
		if(getCount() != 0) {
			System.out.print("도서 번호 : ");
			String bid = bmApp.scan.next();
			
			// 도서 번호로 검색
			BookVO book = repository.find(bid);

			if(book != null) {
				BookVO newBook = createBook(book);

				// 도서 정보 수정
				if(repository.update(newBook) != 0) {
					System.out.println("[도서 정보 수정 완료]");
					System.out.println("==================================");
					printBook(newBook);
					System.out.println("==================================");
				} else {
					System.out.println("도서 업데이트에 실패했습니다.");
				}
				
			} else {
				System.out.println("검색한 도서가 존재하지 않습니다.");
			}
		} else {
			System.out.println("등록된 도서가 존재하지 않습니다.");
		}
	}

	/**
	 * 도서 삭제
	 */
	@Override
	public void delete() {
		// 등록된 도서가 존재할경우
		if(getCount() != 0) {
			System.out.print("도서 번호 : ");
			String bid = bmApp.scan.next();
			
			// 도서 번호로 검색
			BookVO book = repository.find(bid);

			if(book != null) {
				if(repository.remove(book.getBid()) != 0) {
					System.out.println("[" + bid  +"] 도서를 삭제 했습니다.");
				} else {
					System.out.println("도서 삭제에 실패하였습니다.");
				}

			} else {
				System.out.println("검색한 도서가 존재하지 않습니다.");
			}
		} else {
			System.out.println("등록된 도서가 존재하지 않습니다.");
		}
	}

	@Override
	public void exit() {
		System.out.println("== 프로그램 종료 ==");
		repository.close();
		System.exit(0);
	}

	/**
	 * 등록된 도서 정보 갯수
	 */
	@Override
	public int getCount() {
		return repository.getCount();
	}
	/**
	 * 도서 정보 생성
	 * @return Book 도서 정보
	 */
	public BookVO createBook() {
		BookVO book = new BookVO();
		boolean flag = false;
		Random random = new Random();
		
		System.out.println("[도서 등록]");
		System.out.print("도서명 : ");
		book.setTitle(bmApp.scan.next());

		System.out.print("저자 : ");
		book.setAuthor(bmApp.scan.next());
		
		while(!flag) {			
			System.out.print("가격 : ");
			if(bmApp.scan.hasNextInt()) {
				book.setPrice(bmApp.scan.nextInt());
				flag = true;
			} else {
				System.out.println("숫자를 입력해주세요.");
				bmApp.scan.next();
			}
		}
		
		book.setIsbn(random.nextInt(1000,9999));
		
		return book;
	}
	
	/**
	 * 도서 정보 생성
	 * @param BookVO old book 정보
	 * @return Book 수정된 도서 정보
	 * 도서 수정시 도서 정보를 일부 수정하여 반환
	 */
	public BookVO createBook(BookVO book) {
		boolean flag = false;
		
		System.out.println("[도서 정보 수정]");
		System.out.print("도서명 : ");
		book.setTitle(bmApp.scan.next());

		System.out.print("저자 : ");
		book.setAuthor(bmApp.scan.next());
		
		while(!flag) {
			System.out.print("가격 : ");
			if(bmApp.scan.hasNextInt()) {
				book.setPrice(bmApp.scan.nextInt());
				flag = true;
			} else {
				System.out.println("숫자를 입력해주세요.");
				bmApp.scan.next();
			}
		}
		
		return book;
	}
	
	/**
	 * 도서 정보 출력 : 검색, 수정시 결과 출력
	 * @param book
	 */
	public void printBook(BookVO book) {
		System.out.print("[" + book.getBid() + "] ");
		System.out.print(book.getTitle() + " - ");
		System.out.print(book.getAuthor() + ", ");
		System.out.print(book.getPrice() + ", ");
		System.out.print(book.getIsbn() + ", ");
		System.out.print(book.getBdate() + "\n");
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}
}
