package consoleUI01;
//�����ȣ 8�ڸ�, �̸� 2�� �̻�, 
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
		if(employeeNumber==null || employeeNumber.length()!=8)//�Ǵ� ���� ��Ȯ�ϸ� �Ǵ� ������ 
			throw new EmployeeNumberLengthException("8�ڸ�");
		this.employeeNumber = employeeNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name==null || name.length()<2)
			throw new RuntimeException("�̸��� 2�� �̻�");
		this.name = name;
	}
	@Override
	public String toString() {
		return "employeeNumber=" + employeeNumber + ", name=" + name;
	}

}
