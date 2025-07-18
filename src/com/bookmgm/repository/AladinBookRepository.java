package com.bookmgm.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.bookmgm.model.Book;

public class AladinBookRepository implements BookRepository{
	List<Book> library = new ArrayList<Book>();
	
	public AladinBookRepository() {
		System.out.println("** 알라딘 도서관 생성**");
	}
	
	/**
	 * 도서 추가
	 */
	@Override
	public boolean insert(Book book) {
		return library.add(book);
	}

	/**
	 * 도서 수정
	 */
	@Override
	public boolean update(Book book) {
		boolean result = false;
		
		for(int i = 0; i < library.size(); i++) {
			Book selectBook = library.get(i);
			
			if(selectBook.getId().equals(book.getId())) {
				library.set(i, book);
				result = true;
				i = library.size();
			}
		}
		
		return result;
	}

	/**
	 * 도서 제거
	 * @param id : 도서 번호
	 */
	@Override
	public boolean remove(String id) {
		boolean result = false;
		
		Iterator<Book> ie = library.iterator();
		
		while(ie.hasNext()) {
			Book book = ie.next();
			if(book.getId().equals(id)) {
				ie.remove();
				result =true;
				break;
			}
		}
		
		return result;
	}
	
	/**
	 * 도서 제거
	 * @param book : 도서 정보
	 */
	@Override
	public boolean remove(Book book) {
		boolean result = false;
		
		Iterator<Book> ie = library.iterator();
		
		while(ie.hasNext()) {
			Book selectBook = ie.next();
			if(selectBook == book) {
				ie.remove();
				result =true;
				break;
			}
		}
		
		return result;
	}
	
	/**
	 * 등록된 도서 정보 갯수
	 */
	@Override
	public int getCount() {
		return library.size();
	}

	/**
	 * 모든 도서 정보 출력
	 */
	@Override
	public List<Book> selectAll() {
		return library;
	}

	/**
	 * 도서 정보 검색
	 */
	@Override
	public Book select(String id) {
		Book selectBook = null;
		
		for(Book book : library) {
			if(book.getId().equals(id)) {
				selectBook = book;
				break;
			}
		}
		
		return selectBook;
	}
	
}
