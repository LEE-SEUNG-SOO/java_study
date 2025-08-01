package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import commons.DefaultInterface;

/*
 * Connection, statment, close 기능을 실행하는 클래스
 */
public class DBConn implements DefaultInterface {
	// Field
	protected Connection con;
	protected Statement stmt;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	
	// Constructor
	protected DBConn() {
		// 1단계 실행
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
//			System.out.println("1단계 성공 : " + con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Method
	// 2단계 statement 객체 생성
	protected void getStatement() {
		try {
			stmt = con.createStatement();
//			System.out.println("2단계 성공 : " + stmt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 2단계 preparedstatement 객체 생성
	protected void getPreparedStatement(String sql) {
		try {
			pstmt = con.prepareStatement(sql);
//			System.out.println("2단계 성공 : " + pstmt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 5단계 close
	public void close() {
		try {
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(con != null) {
				con.close();
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
