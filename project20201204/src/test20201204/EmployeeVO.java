package test20201204;

public class EmployeeVO implements Comparable<EmployeeVO> {

	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String hireDate;
	private String jobId;
	private int salary;
	private int departmentId;

	// 생성자: lastName, email, jobId, hireDate

	public EmployeeVO() {
	}

	public EmployeeVO(String lastName, String email, String hireDate, String jobId, int departmentId) {
		super();
		this.lastName = lastName;
		this.email = email;
		this.hireDate = hireDate;
		this.jobId = jobId;
		this.departmentId = departmentId;
	}
	
	

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void showEmpInfo() {
		System.out.println(
				"사원번호: " + employeeId + ", firstName: " + firstName + ", lastName: " + lastName + ", email: " + email + ", salary: " +salary +", departmentId: " + departmentId);
	}

	@Override
	public int compareTo(EmployeeVO o) {
		// TODO Auto-generated method stub
		if(this.getFirstName() != null)
		return this.getFirstName().compareTo(o.getFirstName());
		else return 0;
	}
	



}
