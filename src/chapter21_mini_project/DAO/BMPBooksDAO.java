package chapter21_mini_project.DAO;

import java.util.ArrayList;
import java.util.List;

import chapter21_mini_project.VO.BMPBooksVO;
import db.DBConn;

public class BMPBooksDAO extends DBConn implements BookInterface<BMPBooksVO>{

	@Override
	/**
	 * 도서 등록
	 * @param book 도서 정보
	 * @return result 0 : 1
	 */
	public int insert(BMPBooksVO book) {
		int result = 0;
		
		// sql 베이스
		String sql = """
					INSERT INTO book_market_books(btitle, bprice, bauthor, bsubtitle, bgroup, bdate)
					VALUES(?, ?, ?, ?, ?, curdate())
				""";
		try {
			// sql 설정
			getPreparedStatement(sql);
			// 파라미터 설정
			pstmt.setString(1, book.getbTitle());
			pstmt.setInt(2, book.getbPrice());
			pstmt.setString(3, book.getbAuthor());
			pstmt.setString(4, book.getbSubTitle());
			pstmt.setString(5, book.getbGroup());
			
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	/**
	 * 도서 수정
	 * @param book 도서정보
	 * @return result 0 : 1
	 */
	public int update(BMPBooksVO book) {
		int result = 0;
		// sql 베이스
		String sql = """
					UPDATE book_market_books
					SET btitle = ? , bprice = ? , bauthor = ? , bsubtitle = ? , bgroup = ? , bdate = curdate()
					WHERE bid = ?
				""";
		try {
			// sql 설정
			getPreparedStatement(sql);
			// 파라미터 설정
			pstmt.setString(1, book.getbTitle());
			pstmt.setInt(2, book.getbPrice());
			pstmt.setString(3, book.getbAuthor());
			pstmt.setString(4, book.getbSubTitle());
			pstmt.setString(5, book.getbGroup());
			pstmt.setString(6, book.getbId());
			// sql 실행
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	/**
	 * 도서 삭제
	 * @param bid 도서번호
	 * @return result 0 : 1
	 */
	public int remove(String bid) {
		int result = 0;
		// sql 베이스
		String sql = """
				DELETE FROM book_market_books
				WHERE bid = ?
				""";
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

	@Override
	public int getCount(String cid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	/**
	 * 도서 목록 조회
	 * @return list 도서테이블의 전 레코드
	 */
	public List<BMPBooksVO> findAll() {
		List<BMPBooksVO> list = new ArrayList<BMPBooksVO>();
		
		// sql 베이스
		String sql = """
					SELECT bid, btitle, bprice, bauthor, bsubtitle, bgroup, bdate
					FROM book_market_books
				""";
		try {		
			// sql 설정
			getPreparedStatement(sql);
			
			// sql 실행
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BMPBooksVO bmpBooks = new BMPBooksVO();
				
				bmpBooks.setbId(rs.getString(1));
				bmpBooks.setbTitle(rs.getString(2));
				bmpBooks.setbPrice(rs.getInt(3));
				bmpBooks.setbAuthor(rs.getString(4));
				bmpBooks.setbSubTitle(rs.getString(5));
				bmpBooks.setbGroup(rs.getString(6));
				bmpBooks.setbDate(rs.getString(7));
				
				list.add(bmpBooks);
			}
				
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public BMPBooksVO find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int remove(String id, String bid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BMPBooksVO> findAll(String cid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BMPBooksVO find(String cid, String bid) {
		// TODO Auto-generated method stub
		return null;
	}

}
