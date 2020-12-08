package test20201204;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EmpDAO {

	static Connection conn = null;
	static PreparedStatement pstmt;
	static ResultSet rs;
	static String sql;

	/*
	 * 1) salary : 10000이상인 사원 출력 (사원번호, 이름, 메일, 급여) 50:선적부서 2) 선적부서: 급여합계(평균)
	 * 3)급여(5000~10000)_사원번호, 이름, 메일, 급여
	 */

	public static void main(String[] args) {
		conn = DAO.getConnection();
		sql = "select * from emp1";
		List<EmployeeVO> list = new ArrayList<>();

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				EmployeeVO vo = new EmployeeVO();
				vo.setEmployeeId(rs.getInt("employee_id"));
				vo.setLastName(rs.getString("last_name"));
				vo.setFirstName(rs.getString("first_name"));
				vo.setEmail(rs.getString("email"));
				vo.setJobId(rs.getString("job_id"));
				vo.setHireDate(rs.getString("hire_date"));
				vo.setSalary(rs.getInt("salary"));
				vo.setDepartmentId(rs.getInt("department_id"));
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Stream<EmployeeVO> stream = list.stream();
		System.out.println("1) salary가 10000이상인 사원. >>>");
//			stream.filter(t -> t.getSalary() > 10000).forEach(s -> s.showEmpInfo());
		stream.filter(new Predicate<EmployeeVO>() {
			public boolean test(EmployeeVO t) {
				return t.getSalary() > 10000;
			}
		}).forEach(s -> s.showEmpInfo());
		System.out.println("\n" + "2) 선적부서 >>>");
		list.stream().filter(t -> t.getDepartmentId() == 50).forEach(s -> s.showEmpInfo());
		System.out.println("선적부서 급여합계");
		int sum = list.stream().filter(new Predicate<EmployeeVO>() {
			@Override
			public boolean test(EmployeeVO t) {
				return t.getDepartmentId() == 50;
			}
		}).mapToInt(new ToIntFunction<EmployeeVO>() {
			@Override
			public int applyAsInt(EmployeeVO value) {
				return value.getSalary();
			}
		}).sum();
		System.out.println(sum);
		System.out.println("선적부서 급여평균");
		double avg = list.stream()
				.filter(t -> t.getDepartmentId() == 50)
				.mapToInt(s -> s.getSalary()).average()
				.getAsDouble();
		System.out.println(avg);

		System.out.println("\n" + "3) 급여(5000~10000)_사원번호, 이름, 메일, 급여 >>>>");
		list.stream().filter(t -> t.getSalary() >= 5000 && t.getSalary() <= 10000).forEach(s -> s.showEmpInfo());

		System.out.println("\n" + "4) salary 많은 사람 >>>>");
		list.stream().sorted().forEach(s -> s.showEmpInfo());

		
		
		
	}

}
