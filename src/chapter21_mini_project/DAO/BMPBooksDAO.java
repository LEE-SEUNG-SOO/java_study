package chapter21_mini_project.DAO;

import java.util.ArrayList;
import java.util.List;

import chapter21_mini_project.VO.BMPBooksVO;
import chapter21_mini_project.bookinterface.BookInterface;
import db.DBConn;

public class BMPBooksDAO extends DBConn implements BookInterface<BMPBooksVO>{

	@Override
	public int insert(BMPBooksVO entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(BMPBooksVO entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCount(String cid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	// 도서 목록 조회
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
