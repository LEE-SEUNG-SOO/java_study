package chapter20_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * JDBC
 */
public class MysqlConnectTest {

	public static void main(String[] args) {
		// url 형식 
		// jdbc:mysql://서버주소:포트번호/DB명?옵션들;
		String url = "jdbc:mysql://localhost:3306/hrdb2019";
		String user = "root";
		String password = "mysql1234";
		
		// 0단계 - 드라이버 다운로드 및 패스 추가
		// 1단계 - 드라이버 로딩 및 Connection 객체 생성		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("1단계 성공 : " + con);
			
			// 2단계 - Statement, PrepareStatement(보안에 강함. 주로 사용)
			Statement stmt = con.createStatement();
			System.out.println("2단계 성공 : " + stmt);
			String sql;
			
			// 3단계 - stmt객체를 통한 ResultSet 객체 생성
//			sql = "SELECT emp_id, emp_name, dept_id, salary FROM employee"
//						+ " " + "WHERE dept_id = 'SYS'";
//			StringBuilder sb = new StringBuilder();
//			sb.append("SELECT emp_id, emp_name, dept_id, salary FROM employee");
//			sb.append(" WHERE dept_id = 'SYS'");
//
//			sql = sb.toString();
			
			// JDK 15이상에서만 사용가능 --> 자바스크립트 ``(벡틱연산자~) : 템플릿 리터럴
			sql = """
				select 
					row_number() over() as rno, 
					emp_id, 
					emp_name, 
					dept_id,
					salary,
					hire_date 
				from employee
				WHERE dept_id = 'SYS';
					""";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs != null) {
				System.out.println("3단계 성공 : " + rs);
				
				// 4단계 - rs객체에서 데이터 추출
				while(rs.next()) {
					// 인덱스로 출력
					// ArrayList에 담아서 반환하여 사용하게끔 설정
					System.out.print(rs.getInt(1) + "\t");		// rno
					System.out.print(rs.getString(2) + "\t");	// emp_id
					System.out.print(rs.getString(3) + "\t");	// emp_name
					System.out.print(rs.getString(4) + "\t");	// dept_id
					System.out.print(rs.getInt(5) + "\t");		// salary
					System.out.print(rs.getDate(6) + "\n");		// hire_date
//					// 객체 이름으로 출력
//					System.out.println("컬럼명으로 출력 : " + rs.getInt("rno"));
				}
				
				System.out.println("4단계 성공 데이터 추출 : " + rs);
			} else {
				System.out.println("3단계 실패 : " + rs);
			}
			
			// 5단계 - 사용한 모든 객체 종료 close
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(con != null) con.close();
			
			System.out.println("5단계 성공");
			
		} catch (SQLException e) {
			System.out.println("에러 발생");
			e.printStackTrace();
		}
	}
}
