package chapter20_JDBC;

import java.util.List;

import chapter20_JDBC.DAO.DepartmentDAO;
import chapter20_JDBC.VO.DepartmentVO;

/*
 * department Test
 */
public class DepartmentTest {

	public static void main(String[] args) {
		DepartmentDAO ddao = new DepartmentDAO();
		
		DepartmentVO insertVO = new DepartmentVO();
		insertVO.setDeptId("KMD");
		insertVO.setDeptName("테스트3");
		insertVO.setUnitId("A");
		
		// insert	
		if(ddao.insert(insertVO)) {
			List<DepartmentVO> list = ddao.getList();
			list.forEach( (department) -> {
				System.out.print(department.getDeptId() + "\t");
				System.out.print(department.getDeptName() + "\t");
				System.out.print(department.getUnitId() + "\t");
				System.out.print(department.getStartDate() + "\n");
			});
		}
		
		insertVO.setDeptId("KME");
		insertVO.setDeptName("테스트3");
			
		if(ddao.insert(insertVO)) {
			List<DepartmentVO> list = ddao.getList();
			list.forEach( (department) -> {
				System.out.print(department.getDeptId() + "\t");
				System.out.print(department.getDeptName() + "\t");
				System.out.print(department.getUnitId() + "\t");
				System.out.print(department.getStartDate() + "\n");
			});
		}
		
		ddao.close();
		
	}
}
