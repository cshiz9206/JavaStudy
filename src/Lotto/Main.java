package Lotto;

// Lottery Ŭ������ ���
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lottery lottery = new Lottery();
		System.out.println("***** �ζ� ��÷�� *****");
		lottery.createBall();
		lottery.select();
		lottery.printRank();
	}
}
