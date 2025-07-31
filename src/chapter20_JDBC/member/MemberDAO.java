package chapter20_JDBC.member;

import java.util.ArrayList;
import java.util.List;

import db.DBConn;

public class MemberDAO extends DBConn implements GenericInterface<MemberVO>{
	
	public MemberDAO() {
		super();
	}
	
	// CRUD 기능 구현 - 어플리케이션 기반의 DB연동은 기본적으로 Autocommit = true
	/**
	 * 데이터 추가
	 * @param memberVo member객체
	 */
	@Override
	public int insert(MemberVO member) {
		int result = 0;
		String sql = """
					INSERT INTO member(name, email, created_at)
					VALUES(?, ?, sysdate())
				""";
		try {
			// sql 설정
			getPreparedStatement(sql);
			// 파라미터 설정
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getEmail());
			// sql 실행
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 전체 리스트 출력
	 */
	@Override
	public List<MemberVO> listAll() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		String sql = "SELECT member_id, name, email, left(created_at,10)"
					+ " FROM member";
		try {
			// sql 설정
			getPreparedStatement(sql);
			// sql 실행
			rs = pstmt.executeQuery();
			
			if(rs != null) {
				while(rs.next()) {
					MemberVO member = new MemberVO();
					member.setMemberId(rs.getInt(1));
					member.setName(rs.getString(2));
					member.setEmail(rs.getString(3));
					member.setCreatedAt(rs.getString(4));
					
					list.add(member);
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * memberId로 데이터 검색
	 * @param memberId memberId
	 */
	public MemberVO search(int memberId) {
		MemberVO memberVO = new MemberVO();
		
		String sql = "SELECT member_id, name, email, created_at"
					+ " FROM member"
					+ " WHERE member_id = ?";
		
		try {
			// sql 설정
			getPreparedStatement(sql);
			// 파라미터 설정
			pstmt.setInt(1, memberId);
			// sql 실행
			rs = pstmt.executeQuery();
			
			if(rs != null) {
				while(rs.next()) {
					memberVO.setMemberId(rs.getInt(1));
					memberVO.setName(rs.getString(2));
					memberVO.setEmail(rs.getString(3));
					memberVO.setCreatedAt(rs.getString(4));
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return memberVO;
	}
	
	/**
	 * name으로 데이터 검색
	 * @param name name
	 */
	public List<MemberVO> search(String name) {
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		String sql = """
					SELECT member_id,
							name,
							email,
							created_at
					FROM member
					WHERE name = ?
				""";
		
		try {
			// sql 설정
			getPreparedStatement(sql);
			// 파라미터 설정
			pstmt.setString(1, name);
			// sql 실행
			rs = pstmt.executeQuery();
			
			if(rs != null) {
				while(rs.next()) {
					MemberVO memberVO = new MemberVO();
					
					memberVO.setMemberId(rs.getInt(1));
					memberVO.setName(rs.getString(2));
					memberVO.setEmail(rs.getString(3));
					memberVO.setCreatedAt(rs.getString(4));
					
					list.add(memberVO);
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * 데이터 수정
	 * @param memberVo member객체
	 */
	@Override
	public int update(MemberVO member) {
		int result = 0;
		
		String sql = """
					UPDATE member 
						SET name = ?, 
							email = ?, 
							created_at = sysdate()
						WHERE member_id = ?
					""";
		
		try {
			// sql 설정
			getPreparedStatement(sql);
			// 파라미터 설정
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getEmail());
			pstmt.setInt(3, member.getMemberId());
			// sql실행
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 데이터 삭제
	 * @param memberId memberId
	 */
	@Override
	public int delete(int memberId) {
		int result = 0;
		
		String sql = "DELETE FROM member WHERE member_id = ?";
		
		try {
			// sql 설정
			getPreparedStatement(sql);
			// 파라미터 설정
			pstmt.setInt(1, memberId);
			// sql 실행
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
