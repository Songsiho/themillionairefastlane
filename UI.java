package consoleUI01;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;

/**1. 입력 - 사원번호, 이름 
 * 2. 수정 - 사원번호 입력 -> 이름
 * 3. getall - 아래로
 * 4. search  - 사원번호 입력 -> 이름
 * 5. exit - 종료 저장 Y/N -> out.txt에 저장*/

public class UI {
	private Collection<Employee> list;
	private BufferedReader br;
	
	public UI(Collection<Employee> list) throws IOException{
		br=new BufferedReader(new InputStreamReader(System.in));//수도꼭지 튼다

		this.list=list;

		menu(); //메뉴 돌리기
	}

	//프로그램 시작과 종료
	private void menu() throws IOException {

		while(true){
			try{
				String title="1. 입력, 2. 수정, 3. get all 4.search 5. Exit ";
				menuCheck(inputData(title));
			}catch(IOException e){
				e.getStackTrace();
			}catch(EmployeeNumberLengthException e){
				System.out.println("사원번호는 8자");
			}
		}
	}

	private void menuCheck(String menuflag) throws IOException, EmployeeNumberLengthException {
		switch(menuflag){
		//입력
		case "1":
			addEmployee();
			break;
		case "2":
			updateEmployee();
			break;
		case "3":
			getAllEmployee();
			break;
		case "4":
			searchEmployee();
			break;
		case "5":
			programExit();
			break;
		default:
			System.out.println("메뉴는 오번까지");
			break;
		}

	}

	private void programExit() throws IOException {
		//System.out.println("저장 하시겠습니까? Y/N");
		if(inputData("저장 여부 : Y/N").equalsIgnoreCase("y")){
			filesave();
		}
		System.out.println("프로그램을 종료합니다");
		System.exit(0);
	}

	private void filesave() {
		System.out.println("파일이 저장되었어요");

	}

	private void searchEmployee() {
		// TODO Auto-generated method stub

	}

	private void getAllEmployee() {
		System.out.println(list);
	}

	private void updateEmployee() {
		// TODO Auto-generated method stub

	}

	private void addEmployee() throws EmployeeNumberLengthException, IOException {
		// TODO Auto-generated method stub
		list.add(new Employee(inputData("이름"),inputData("사원번호")));
	}

	private String inputData(String title) throws IOException{
		System.out.println(title);
		return br.readLine();
	}

	public UI() throws IOException {
		this(new ArrayList<Employee>());
	}

	public static void main(String[] args) throws IOException {
		new UI();
		System.out.println("프로그램 안정적으로 종료");
	}
}
