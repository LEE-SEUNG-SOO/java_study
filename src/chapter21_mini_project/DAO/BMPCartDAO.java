package chapter21_mini_project.DAO;

import java.util.ArrayList;
import java.util.List;

import chapter21_mini_project.VO.BMPCartVO;
import chapter21_mini_project.bookinterface.BookInterface;
import db.DBConn;

public class BMPCartDAO extends DBConn implements BookInterface<BMPCartVO>{

	@Override
	// 장바구니 도서 정보 추가
	public int insert(BMPCartVO bmpCart) {
		int result = 0;
		
		// sql 베이스
		String sql = """
					INSERT INTO book_market_cart(bid, count, total, cid)
					VALUES(?, ?, ?, ?)
				""";
		
		try {
			// sql 설정
			getPreparedStatement(sql);
			// 파라미터 설정
			pstmt.setString(1, bmpCart.getbId());
			pstmt.setInt(2, bmpCart.getCount());
			pstmt.setInt(3, bmpCart.getTotal());
			pstmt.setString(4, bmpCart.getcId());
			// sql 실행
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	// 장바구니 도서 정보 수정
	public int update(BMPCartVO bmpCart) {
		int result = 0;
		
		// sql 베이스
		String sql = """
					UPDATE book_market_cart
					SET count = ?, total = ? 
					WHERE cid = ?
					AND bid = ?
				""";
		
		try {
			// sql 설정
			getPreparedStatement(sql);
			// 파라미터 설정
			pstmt.setInt(1, bmpCart.getCount());
			pstmt.setInt(2, bmpCart.getTotal());
			pstmt.setString(3, bmpCart.getcId());
			pstmt.setString(4, bmpCart.getbId());
			// sql 실행
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	// 장바구니 도서 번호로 삭제
	public int remove(String cid, String bid) {
		int result = 0;
		// sql 베이스
		String sql = """
					DELETE FROM book_market_cart
					WHERE cid= ?
					AND bid = ?
				""";
		
		try {
			// sql 설정
			getPreparedStatement(sql);
			// 파라미터 설정
			pstmt.setString(1, cid);
			pstmt.setString(2, bid);
			// sql 실행
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int getCount(String cid) {
		int result = 0;
		
		// sql 베이스
		String sql = """
					SELECT count(cid)
					FROM book_market_cart
					WHERE cid = ?
				""";
		
		try {		
			// sql 설정
			getPreparedStatement(sql);
			// 파라미터 설정
			pstmt.setString(1, cid);
			
			// sql 실행
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				result = rs.getInt(1);
			}
				
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	// 장바구니 정보 확인
	public List<BMPCartVO> findAll(String cid) {
		List<BMPCartVO> list = new ArrayList<BMPCartVO>();
		
		// sql 베이스
		String sql = """
					SELECT bid, count, total, cid
					FROM book_market_cart 
					WHERE cid = ?
				""";
		
		try {		
			// sql 설정
			getPreparedStatement(sql);
			// 파라미터 설정
			pstmt.setString(1, cid);
			// sql 실행
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BMPCartVO bmpCart = new BMPCartVO();
				
				bmpCart.setbId(rs.getString(1));
				bmpCart.setCount(rs.getInt(2));
				bmpCart.setTotal(rs.getInt(3));
				bmpCart.setcId(rs.getString(4));
				
				list.add(bmpCart);
			}
				
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}


	@Override
	// 장바구니 비우기
	public int remove(String cid) {
		int result = 0;
		
		// sql 베이스
		String sql = """
					DELETE FROM book_market_cart
					WHERE cid = ?
				""";
		
		try {
			// sql 설정
			getPreparedStatement(sql);
			// 파라미터 설정
			pstmt.setString(1, cid);
			// sql 실행
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	// 도서 번호로 장바구니 검색
	public BMPCartVO find(String cid, String bid) {
		BMPCartVO bmpCart  = new BMPCartVO();
		
		// sql 베이스
		String sql = """
					SELECT bid, count, total, cid
					FROM book_market_cart
					WHERE cid = ? 
					AND bid = ?
				""";
		
		try {		
			// sql 설정
			getPreparedStatement(sql);
			// 파라미터 설정
			pstmt.setString(1, cid);
			pstmt.setString(2, bid);
			
			// sql 실행
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				bmpCart.setbId(rs.getString(1));
				bmpCart.setCount(rs.getInt(2));
				bmpCart.setTotal(rs.getInt(3));
				bmpCart.setcId(rs.getString(4));
			}
				
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return bmpCart;
	}

	@Override
	public List<BMPCartVO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BMPCartVO find(String bid) {
		// TODO Auto-generated method stub
		return null;
	}
}
