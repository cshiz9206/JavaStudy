package T19_1_End_1;

public class Exam01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("���� ����(0~9) 10��");
		MaxNumCreater mnc = new MaxNumCreater();
		mnc.randomArray();
		System.out.println("�� �����Ͽ����ϴ�.");
		
		System.out.println("���� ���� 10���� ������ ���� ū ���ڴ�");
		mnc.createMaxNum();
		mnc.print();
		System.out.println("�Դϴ�.");
	}

}
