package GradeProgram;

public class Management {
	FileIO io = new FileIO();
	
	public Management() {
		String[] students = {"ö��", "����", "�浿", "����"};
		String[] subjects = {"����", "����", "����", "����"};
		io.println("���� ���α׷��Դϴ�.");
		io.println("�л��� ������ �о�ɴϴ�.");
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
			io.println("�ε� �Ϸ� : " + name[i]);
		}
		return data;
	}
	
	public void printdata(String[] name, String[] subject, String[][] data) {
		io.println("");
		io.println("��� ������ �ҷ��Խ��ϴ�.");
		for(int i = 0; i < subject.length; i++) {
			if(i == 0) io.print("�̸�");
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
