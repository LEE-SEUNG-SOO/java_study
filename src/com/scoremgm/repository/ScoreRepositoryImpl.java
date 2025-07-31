package com.scoremgm.repository;

import java.util.ArrayList;
import java.util.List;

import com.scoremgm.model.MemberVO;

import db.DBConn;
import db.GenericRepositoryInterface;

public class ScoreRepositoryImpl extends DBConn
	implements GenericRepositoryInterface<MemberVO> {
	
	public ScoreRepositoryImpl() {
		super();
	}
	
	/**
	 * 학생 정보 입력
	 */
	@Override
	public int insert(MemberVO member) {
		int result = 0;
		
		String sql = """
					INSERT INTO score_member(name, department, kor, eng, math, mdate)
					VALUES(?, ?, ?, ?, ?, sysdate() )
				""";
		try {
			// sql 설정
			getPreparedStatement(sql);
			// 파라미터 설정
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getDepartment());
			pstmt.setDouble(3, member.getKor());
			pstmt.setDouble(4, member.getEng());
			pstmt.setDouble(5, member.getMath());
			// sql 실행
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int update(MemberVO entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(String no) {
		// TODO Auto-generated method stub
		return 0;
	}
	
//	/**
//	 * 학생 정보 수정
//	 */
//	@Override
//	public boolean update(MemberVO member) {
//		boolean result = false;
//		int index;
//		
//		for(index = 0; index < storage.size(); index++) {
//			MemberVO m = storage.get(index);
//			
//			if(member.getNo().equals(m.getNo())) {
//				result = true;
//				storage.set(index, member);
//				index = storage.size();
//			}
//		}
//		
//		return result;
//	}
//	
//	/**
//	 * 학생 정보 삭제
//	 */
//	public boolean remove(String no) {
//		boolean result = false;
//		
//		Iterator<MemberVO> ie = storage.iterator();
//		
//		while(ie.hasNext()) {
//			MemberVO mebmer = ie.next();
//			if(mebmer.getNo().equals(no)) {
//				ie.remove();
//				result = true;
//				break;
//			}
//		}
//		
//		return result;
//	}
//	
	/**
	 * 학생 총 수 출력
	 */
	@Override
	public int getCount() {
		int result = 0;
		String sql = "SELECT COUNT(*) FROM score_member";
		
		try {
			getPreparedStatement(sql);			
			rs = pstmt.executeQuery();
			// 카운트 가져오기
			while(rs.next()) {
				result = rs.getInt(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 모든 학생 정보 출력 
	 */
	@Override
	public List<MemberVO> findAll(){
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		String sql = """
					SELECT 
						row_number() over(),
						mid, 
						name, 
						department, 
						kor, 
						eng, 
						math, 
						mdate
					FROM score_member
				""" ;
		try {
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
		
			while(rs.next()) {
				MemberVO member = new MemberVO();
				
				member.setRno(rs.getInt(1));
				member.setMid(rs.getString(2));
				member.setName(rs.getString(3));
				member.setDepartment(rs.getString(4));
				member.setKor(rs.getInt(5));
				member.setEng(rs.getInt(6));
				member.setMath(rs.getInt(7));
				member.setMdate(rs.getString(8));
				
				list.add(member);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * 학번 기준 학생 정보 검색 
	 */
	@Override
	public MemberVO find(String mid) {
		MemberVO member = null;
		
		String sql = """
					SELECT 
						mid, 
						name, 
						department, 
						kor, 
						eng, 
						math, 
						mdate
					FROM score_member
					WHERE mid = ?
				""" ;
		
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member = new MemberVO();
				member.setMid(rs.getString(1));
				member.setName(rs.getString(2));
				member.setDepartment(rs.getString(3));
				member.setKor(rs.getInt(4));
				member.setEng(rs.getInt(5));
				member.setMath(rs.getInt(6));
				member.setMdate(rs.getString(7));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return member;
	}
}
