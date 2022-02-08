package CalcGrade;

// line을 카운트 -> 과목수
// line을 배열로 split -> 마지막 index 숫자 추출

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		GPACalc gc = new GPACalc();
		gc.readSbjGrade("C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_정승현\\JAVA_edu_정승현\\src\\CalcGrade\\1st_sem.txt");
		
		gc.printContent();
		gc.printGpa();
	}
}

// page 97