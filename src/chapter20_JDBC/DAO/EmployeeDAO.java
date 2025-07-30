package chapter20_JDBC.DAO;

//import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import chapter20_JDBC.VO.EmployeeVO;
import db.DBConn;

/*
 * employee DAO
 */
public class EmployeeDAO extends DBConn{
	// Field
//	private String url = "jdbc:mysql://localhost:3306/hrdb2019";
//	private String user = "root";
//	private String password = "mysql1234";
//	Connection con;
//	Statement stmt;
//	ResultSet rs;
	
	// Constructor
	public EmployeeDAO() {
		// 1단계 실행
		super();
//		try {
//			con = DriverManager.getConnection(url, user, password);
//	
//			System.out.println("1단계 성공 : " + con);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
	
	// Method
	// 2단계 statement 객체 생성
	public void getStatment() {
//		try {
//			stmt = con.createStatement();
//			System.out.println("2단계 성공 : " + stmt);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
	
	// 3단계 CRUD 기능에 따라 메소드 생성
	public List<EmployeeVO> getList() {
		List<EmployeeVO> list = new ArrayList<EmployeeVO>();
		String sql = """
					select  emp_id, 
							emp_name, 
							hire_date, 
							salary
					from employee
				""";
		try {
			getStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				// rs 객체의 한 row를 가져와서 EmployeeVO에 저장
				EmployeeVO evo = new EmployeeVO();
				evo.setEmpId(rs.getString(1));
				evo.setEmpName(rs.getString(2));
				evo.setHireDate(rs.getString(3));
				evo.setSalary(rs.getInt(4));
				list.add(evo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// DBConn.java
		close();
		
		return list;
	};
	
//	// 5단계 close
//	public void close() {
//		super.close();
//		/*
//		 * try { if(rs != null) { rs.close(); } if(stmt != null) { stmt.close(); }
//		 * if(con != null) { con.close(); } } catch (Exception e) { e.printStackTrace();
//		 * }
//		 */
//	}
}
