package GradeProgram;

public class Management {
	FileIO io = new FileIO();
	
	public Management() {
		String[] students = {"철수", "영희", "길동", "지수"};
		String[] subjects = {"국어", "영어", "수학", "과학"};
		io.println("성적 프로그램입니다.");
		io.println("학생별 성적을 읽어옵니다.");
		String[][] students_grade = inputdata(students, subjects);
		printdata(students, subjects, students_grade);
	}
	
	public String[][] inputdata(String[] name, String[] subject) {
		String[][] data = new String[name.length][subject.length];
		for(int i = 0; i < name.length; i++) {
			int[] student_grades = io.read_score(name[i] + ".txt");
			for(int j = 0; j < subject.length; j++) {
				data[i][j] = String.valueOf(student_grades[j]);
			}
			io.println("로딩 완료 : " + name[i]);
		}
		return data;
	}
	
	public void printdata(String[] name, String[] subject, String[][] data) {
		io.println("");
		io.println("모든 성적을 불러왔습니다.");
		for(int i = 0; i < subject.length; i++) {
			if(i == 0) io.print("이름");
			io.print("\t" + subject[i]);
		}
		io.println("");
		for(int i = 0; i < name.length; i++) {
			io.print(name[i]);
			for(int j = 0; j < subject.length; j++) {
				io.print("\t" + data[i][j]);
			}
			io.println("");
		}
	}
}
