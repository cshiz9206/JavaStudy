package TheaterReserv;

public abstract class Theater {
	boolean[][] seat = new boolean[3][5];
	
	abstract void printWelcome();
	
	// �Ű������� �Էµ� �¼� ����
	abstract void reserveSeat(char row, int col);
	
	// ��� �¼� ��Ȳ ���
	abstract void checkSeat();
}
