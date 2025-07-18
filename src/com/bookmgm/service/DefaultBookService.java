package com.bookmgm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.bookmgm.application.BookManagementApplicaion;
import com.bookmgm.model.Book;
import com.bookmgm.repository.AladinBookRepository;
import com.bookmgm.repository.BookRepository;
import com.bookmgm.repository.InMemoryBookRepository;
import com.bookmgm.repository.Yes24BookRepository;

public class DefaultBookService implements BookService{
	BookManagementApplicaion bmApp;
	// 도서 정보
	BookRepository repository;
	// 도서관 정보
	List<BookRepository> repositoryList;
	
	public DefaultBookService() {
	}
	
	public DefaultBookService(BookManagementApplicaion bmApp) {
		this.bmApp = bmApp;
		repositoryList = new ArrayList<BookRepository>();
		repositoryList.add(new InMemoryBookRepository());
		repositoryList.add(new AladinBookRepository());
		repositoryList.add(new Yes24BookRepository());
		
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
			repository = repositoryList.get(rno - 1);
			System.out.println("교육센터 도서관 선택");
		} else if(rno == 2) {
			repository = repositoryList.get(rno - 1);
			System.out.println("알라딘 도서관 선택");
		} else if(rno == 3) {
			repository = repositoryList.get(rno - 1);
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
		Book book = createBook();
		
		// repository에 도서 정보 등록
		if(repository.insert(book)) {
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
			List<Book> list = repository.selectAll();

			System.out.println("[도서 목록 조회]");
			System.out.println("==================================");
			for(Book book : list) {
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
			String id = bmApp.scan.next();
			
			// 도서 번호로 검색
			Book book = repository.select(id);

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
			String id = bmApp.scan.next();
			
			// 도서 번호로 검색
			Book book = repository.select(id);

			if(book != null) {
				Book newBook = createBook(book);

				// 도서 정보 수정
				if(repository.update(newBook)) {
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
			String id = bmApp.scan.next();
			
			// 도서 번호로 검색
			Book book = repository.select(id);

			if(book != null) {
				if(repository.remove(book)) {
					System.out.println("[" + id  +"] 도서를 삭제 했습니다.");
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
	public Book createBook() {
		Book book = new Book();
		Random random = new Random();
		boolean flag = false;
		book.setId(String.valueOf(random.nextInt(1000,9999)));
				
		System.out.println("[도서 등록]");
		System.out.print("도서명 : ");
		book.setName(bmApp.scan.next());

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
	 * 도서 정보 생성
	 * @param Book old book 정보
	 * @return Book 수정된 도서 정보
	 * 도서 수정시 도서 정보를 일부 수정하여 반환
	 */
	public Book createBook(Book book) {
		boolean flag = false;
		
		System.out.println("[도서 정보 수정]");
		System.out.print("도서명 : ");
		book.setName(bmApp.scan.next());

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
	public void printBook(Book book) {
		System.out.print("[" + book.getId() + "] ");
		System.out.print(book.getName() + " - ");
		System.out.print(book.getAuthor() + ", ");
		System.out.println(book.getPrice());	
	}
}
