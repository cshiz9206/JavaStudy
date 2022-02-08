package Lotto;

// Lottery 클래스만 사용
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lottery lottery = new Lottery();
		System.out.println("***** 로또 추첨기 *****");
		lottery.createBall();
		lottery.select();
		lottery.printRank();
	}
}
