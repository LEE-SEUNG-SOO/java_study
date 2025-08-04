package com.scoremgm.repository;

import java.util.ArrayList;
import java.util.List;

import com.scoremgm.model.MemberVO;

import chapter21_mini_project.bookinterface.BookInterface;
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
		// 결과값
		int result = 0;
		
		// insert sql 베이스
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

	/**
	 * 학생 정보 수정
	 */
	@Override
	public int update(MemberVO member) {
		// 실행 결과
		int result = 0;
		
		// UPDATE sql 베이스
		String sql = """
					UPDATE score_member 
					SET kor = ?, eng = ?, math = ?, mdate = sysdate()
					WHERE mid = ?
				""";
		try {
			// sql 설정
			getPreparedStatement(sql);
			// 파라미터 설정
			pstmt.setInt(1, member.getKor());
			pstmt.setInt(2, member.getEng());
			pstmt.setInt(3, member.getMath());
			pstmt.setString(4, member.getMid());
			// sql 실행
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 학생 정보 삭제
	 */
	public int remove(String mid) {
		// 실행 결과
		int result = 0;
		// DELETE sql 베이스
		String sql = """
					DELETE FROM score_member
					WHERE mid = ?
				""";
		
		try {
			// sql 설정
			getPreparedStatement(sql);
			// 파라미터 설정
			pstmt.setString(1, mid);
			// sql 실행
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 학생 총 수 출력
	 */
	@Override
	public int getCount() {
		// 결과값
		int result = 0;
		// select sql 베이스
		String sql = "SELECT COUNT(*) FROM score_member";
		
		try {
			// sql 설정
			getPreparedStatement(sql);
			// sql 실행
			rs = pstmt.executeQuery();
			// 실행 결과 설정
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
		// 모든 학생 정보
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		// select sql 베이스
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
			// sql 설정
			getPreparedStatement(sql);
			// sql 실행
			rs = pstmt.executeQuery();
		
			// 실행결과 설정
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
				
				// sql 실행 결과 설정
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
		// 학번 기준 학생 정보
		MemberVO member = null;
		
		// select sql 베이스
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
			// sql 설정
			getPreparedStatement(sql);
			// 파라미터 설정
			pstmt.setString(1, mid);
			// sql 실행
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				// 실행 결과 설정
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
