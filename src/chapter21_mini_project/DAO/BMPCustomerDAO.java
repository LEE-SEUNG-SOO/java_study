package chapter21_mini_project.DAO;

import java.util.List;

import chapter21_mini_project.VO.BMPCustomerVO;
import chapter21_mini_project.bookinterface.BookInterface;
import db.DBConn;

public class BMPCustomerDAO extends DBConn 
	implements BookInterface<BMPCustomerVO> {

	// 로그인
	public BMPCustomerVO find(String name, String phone) {
		BMPCustomerVO customer = new BMPCustomerVO();
		// sql 베이스
		String sql = """
					SELECT cid, cname, cphone, caddr, cdate
					FROM book_market_customer
					WHERE cname = ?
					AND cphone = ?
				""";
		
		// sql 설정
		getPreparedStatement(sql);
		
		try{
			// 이름
			pstmt.setString(1, name);
			// 폰번호
			pstmt.setString(2, phone);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {				
				customer.setcId(rs.getString(1));
				customer.setcName(rs.getString(2));
				customer.setcPhone(rs.getString(3));
				customer.setcAddr(rs.getString(4));
				customer.setcDate(rs.getString(5));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return customer;
	}

	@Override
	public int insert(BMPCustomerVO customer) {
		int result = 0;
		// sql 베이스
		String sql = """
					INSERT INTO book_market_customer(cname, cphone, caddr, cdate)
					VALUES(?, ?, ?, curdate())
				""";
		
		try {
			// sql 설정
			getPreparedStatement(sql);
			// 파라미터 설정
			pstmt.setString(1, customer.getcName());
			pstmt.setString(2, customer.getcPhone());
			pstmt.setString(3, customer.getcAddr());
			// sql 실행
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
				
		return result;
	}

	@Override
	public int update(BMPCustomerVO entity) {
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
	public List<BMPCustomerVO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BMPCustomerVO find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int remove(String cid, String bid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BMPCustomerVO> findAll(String cid) {
		// TODO Auto-generated method stub
		return null;
	}

}
