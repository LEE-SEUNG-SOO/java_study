package com.bookmgm.repository;

import java.util.ArrayList;
import java.util.List;
import com.bookmgm.model.BookVO;

import db.DBConn;
import db.GenericRepositoryInterface;

public class Yes24BookRepository extends DBConn
	implements GenericRepositoryInterface<BookVO> {
	List<BookVO> library = new ArrayList<BookVO>();
	
	public Yes24BookRepository() {
		System.out.println("** Yes24 도서관 생성**");
	}
	
	/**
	 * 도서 추가
	 */
	@Override
	public int insert(BookVO book) {
		// 실행 결과
		int result = 0;
		// sql 베이스
		String sql = """
					INSERT INTO book_yes24(title, author, price, isbn, bdate)
					VALUES(?, ?, ?, ?, sysdate())
				""";
		
		try {
			// sql 설정
			getPreparedStatement(sql);
			// 파라미터 설정
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.setInt(3, book.getPrice());
			pstmt.setInt(4, book.getIsbn());
			// sql 실행
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	/**
	 * 도서 제거
	 * @param bid : 도서 번호
	 */
	@Override
	public int remove(String bid) {
		// 실행 결과
		int result = 0;
		// sql 베이스
		String sql = "DELETE FROM book_yes24 WHERE bid = ?";

		try {
			// sql 설정
			getPreparedStatement(sql);
			// 파라미터 설정
			pstmt.setString(1, bid);
			// sql 실행
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	/**
	 * 등록된 도서 정보 갯수
	 */
	@Override
	public int getCount() {
		// 실행 결과
		int result = 0;
		// sql 베이스
		String sql = "SELECT count(bid) FROM book_yes24";
		
		try {
			// sql 설정
			getPreparedStatement(sql);
			// sql 실행
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				// 카운트 갯수 설정
				result = rs.getInt(1);
			};
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 도서 수정
	 */
	@Override
	public int update(BookVO book) {
		// 실행 결과
		int result = 0;
		// sql 베이스
		String sql = """
					UPDATE book_yes24
					 SET title = ?, author = ?, price = ?, bdate = sysdate()
					 WHERE bid = ?
				""";
		try {
			// sql 설정
			getPreparedStatement(sql);
			// 파라미터 설정
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.setInt(3, book.getPrice());
			pstmt.setString(4, book.getBid());
			// sql 실행
			result = pstmt.executeUpdate();		
			
		}catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 모든 도서 정보 출력
	 */
	@Override
	public List<BookVO> findAll() {
		List<BookVO> list = new ArrayList<BookVO>();
		
		// sql 베이스
		String sql = "SELECT bid, title, author, price, isbn, bdate FROM book_yes24";
		
		try {
			// sql 설정
			getPreparedStatement(sql);
			// sql 실행
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				// 출력 결과 설정
				BookVO book = new BookVO();
				
				book.setBid(rs.getString(1));
				book.setTitle(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPrice(rs.getInt(4));
				book.setIsbn(rs.getInt(5));
				book.setBdate(rs.getString(6));
				
				list.add(book);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	
	/**
	 * 도서 정보 검색
	 */
	@Override
	public BookVO find(String bid) {
		// 실행 결과
		BookVO book = null;
	
		// sql 베이스
		String sql = "SELECT bid, title, author, price, isbn, bdate"
					+ " FROM book_yes24"
					+ " WHERE bid = ?";
				
		try {
			// sql 설정
			getPreparedStatement(sql);
			// 파라미터 설정
			pstmt.setString(1, bid);
			// sql 실행
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				book = new BookVO();
				
				// 실행 결과 설정
				book.setBid(rs.getString(1));
				book.setTitle(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPrice(rs.getInt(4));
				book.setIsbn(rs.getInt(5));
				book.setBdate(rs.getString(6));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return book;
	}
}
