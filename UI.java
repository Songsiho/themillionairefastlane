package consoleUI01;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;

/**1. �Է� - �����ȣ, �̸� 
 * 2. ���� - �����ȣ �Է� -> �̸�
 * 3. getall - �Ʒ���
 * 4. search  - �����ȣ �Է� -> �̸�
 * 5. exit - ���� ���� Y/N -> out.txt�� ����*/

public class UI {
	private Collection<Employee> list;
	private BufferedReader br;
	
	public UI(Collection<Employee> list) throws IOException{
		br=new BufferedReader(new InputStreamReader(System.in));//�������� ư��

		this.list=list;

		menu(); //�޴� ������
	}

	//���α׷� ���۰� ����
	private void menu() throws IOException {

		while(true){
			try{
				String title="1. �Է�, 2. ����, 3. get all 4.search 5. Exit ";
				menuCheck(inputData(title));
			}catch(IOException e){
				e.getStackTrace();
			}catch(EmployeeNumberLengthException e){
				System.out.println("�����ȣ�� 8��");
			}
		}
	}

	private void menuCheck(String menuflag) throws IOException, EmployeeNumberLengthException {
		switch(menuflag){
		//�Է�
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
			System.out.println("�޴��� ��������");
			break;
		}

	}

	private void programExit() throws IOException {
		//System.out.println("���� �Ͻðڽ��ϱ�? Y/N");
		if(inputData("���� ���� : Y/N").equalsIgnoreCase("y")){
			filesave();
		}
		System.out.println("���α׷��� �����մϴ�");
		System.exit(0);
	}

	private void filesave() {
		System.out.println("������ ����Ǿ����");

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
		list.add(new Employee(inputData("�̸�"),inputData("�����ȣ")));
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
		System.out.println("���α׷� ���������� ����");
	}
}
