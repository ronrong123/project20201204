package test20201204;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.DoubleConsumer;
import java.util.stream.Stream;

public class StreamExample5 {

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

		System.out.println("40부서 사원.>>>>");
		OptionalDouble avg = list.stream().filter(t -> t.getDepartmentId() == 40).mapToInt(s -> s.getSalary())
				.average();
		System.out.println("평균: " + avg.orElse(0.0));
		avg.orElse(0.0);
		
//		avg.ifPresent(new DoubleConsumer() {
//			// ifPresent: avg라는 결과값에 실제 값이있으면
//			@Override
//			public void accept(double value) {
//				System.out.println("급여평균: " + avg.getAsDouble());
//			}
//		});

	}

}
