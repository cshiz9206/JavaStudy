package T18_1_01_End_1;

public class Exam01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue q = new MyQueue();
		
		for(int i = 1; i < 11; i++) {
			System.out.print("������ ���� : " + i + "\n");
			q.push(i);
		}
		
		System.out.println("> ���� ť ������ ��Ȳ");
		q.printQ();
		
		for(int i = 11; i < 14; i++) {
			System.out.print("������ ���� : " + i + "\n");
			q.push(i);
		}
		
		System.out.println("> ���� ť ������ ��Ȳ");
		q.printQ();
	}

}
