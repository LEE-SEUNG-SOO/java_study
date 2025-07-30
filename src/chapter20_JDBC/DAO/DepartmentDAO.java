package chapter20_JDBC.DAO;

import java.util.ArrayList;
import java.util.List;

import chapter20_JDBC.VO.DepartmentVO;
import db.DBConn;

public class DepartmentDAO extends DBConn{
	// Field	
	// Constructor
	public DepartmentDAO() {
		super();
	}
	
	// Method	
	// 3단계 CRUD 기능에 따라 메소드 생성
	
	// C : Insert
	public boolean insert(DepartmentVO department) {
		// insert결과
		boolean result = false;
		try {
			String sql = "INSERT INTO department(dept_id, dept_name, unit_id, start_date)";
			sql += "VALUES(?, ?, ?, curdate()) ";
			
			getPreparedStatement(sql);
			
			pstmt.setString(1, department.getDeptId());
			pstmt.setString(2, department.getDeptName());
			pstmt.setString(3, department.getUnitId());
			
//			if(stmt != null) {
//				StringBuilder sb = new StringBuilder();
//				sb.append("INSERT INTO department(dept_id, dept_name, unit_id, start_date)");
//				sb.append(" VALUES(");
//				sb.append("'" + department.getDeptId() + "', ");
//				sb.append("'" + department.getDeptName() + "', ");
//				sb.append("'" + department.getUnitId() + "', ");
//				sb.append("curdate() )");
//				
//				String sql = sb.toString();
////				String sql = "INSERT INTO department(dept_id, dept_name, unit_id, start_date) ";
////				sql += "values() ";
//				
//				// insert
//				int resultRow = stmt.executeUpdate(sql);
				int resultRow = pstmt.executeUpdate();
				
				// insert에 성공햇을경우
				if(resultRow > 0) {
					result = true;
				}
			} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
		
	// 전체 리스트 출력
	public List<DepartmentVO> getList() {
		List<DepartmentVO> list = new ArrayList<DepartmentVO>();
		
		String sql = """
					select  dept_id, 
							dept_name, 
							unit_id, 
							start_date
					from department
				""";
		try {
			getStatement();
			rs = stmt.executeQuery(sql);

			while(rs.next()) {
				// rs 객체의 한 row를 가져와서 DepartmentVO에 저장
				DepartmentVO dvo = new DepartmentVO();
				dvo.setDeptId(rs.getString(1));
				dvo.setDeptName(rs.getString(2));
				dvo.setUnitId(rs.getString(3));
				dvo.setStartDate(rs.getString(4));
				list.add(dvo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
