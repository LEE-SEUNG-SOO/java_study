package chapter21_mini_project.DAO;

import java.util.List;

import chapter21_mini_project.VO.BMPCustomerVO;
import db.DBConn;

public class BMPCustomerDAO extends DBConn 
	implements BookInterface<BMPCustomerVO> {
	
	@Override
	/**
	 * 로그인(고객 정보 확인)
	 * @param name 이름
	 * @param phone 폰번호
	 * @return customer 고객정보
	 */
	public BMPCustomerVO find(String name, String phone) {
		BMPCustomerVO customer = new BMPCustomerVO();
		// sql 베이스
		String sql = """
					SELECT cid, cname, cphone, caddr, cdate
					FROM book_market_customer
					WHERE cname = ?
					AND cphone = ?
				""";		
		try{
			// sql 설정
			getPreparedStatement(sql);
			// 파라미터 설정
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			// sql 실행
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				// 실행 결과 레코드 취득
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
	/**
	 * 회원가입(고객 정보 등록)
	 * @param customer 고객 정보
	 * @return result 0 : 1
	 */
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
