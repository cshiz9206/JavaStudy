package CalcGrade;

// line�� ī��Ʈ -> �����
// line�� �迭�� split -> ������ index ���� ����

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		GPACalc gc = new GPACalc();
		gc.readSbjGrade("C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_������\\JAVA_edu_������\\src\\CalcGrade\\1st_sem.txt");
		
		gc.printContent();
		gc.printGpa();
	}
}

// page 97