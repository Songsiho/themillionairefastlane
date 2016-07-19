package consoleUI01;
/**사용자 정의 예외 
 * 1. xxxException
 * 2. Exception 계열의 클래스를 상속
 * 3. 생성자만 정의하면 된다.*/
public class EmployeeNumberLengthException extends Exception {
	public EmployeeNumberLengthException(String string) {
		super(string);
	}
}
