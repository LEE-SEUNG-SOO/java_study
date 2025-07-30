package chapter20_JDBC;

import java.util.List;

import chapter20_JDBC.DAO.EmployeeDAO;
import chapter20_JDBC.VO.EmployeeVO;

/*
 * employeeVO, employeeDAO 테스트
 */
public class EmployeeTest {

	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAO();
//		dao.getStatment();
		List<EmployeeVO> list = dao.getList();
	
		list.forEach( (employee) -> {
			System.out.print(employee.getEmpId() + "\t");
			System.out.print(employee.getEmpName() + "\t");
			System.out.print(employee.getHireDate() + "\t");
			System.out.print(employee.getSalary() + "\n");
		});
		
//		dao.close();
	}
}