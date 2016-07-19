package consoleUI01;
//사원번호 8자만, 이름 2자 이상, 
public class Employee {
	private String employeeNumber;
	private String name;

	public Employee(String employeeNumber, String name) throws EmployeeNumberLengthException {
		setEmployeeNumber(employeeNumber);
		setName(name);
	}
	
	public String getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(String employeeNumber) throws EmployeeNumberLengthException {
		if(employeeNumber==null || employeeNumber.length()!=8)//되는 것이 명확하면 되는 것으로 
			throw new EmployeeNumberLengthException("8자만");
		this.employeeNumber = employeeNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name==null || name.length()<2)
			throw new RuntimeException("이름은 2자 이상");
		this.name = name;
	}
	@Override
	public String toString() {
		return "employeeNumber=" + employeeNumber + ", name=" + name;
	}

}
