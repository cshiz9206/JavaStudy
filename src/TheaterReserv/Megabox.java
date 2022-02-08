package TheaterReserv;

public class Megabox extends Theater {

	@Override
	void printWelcome() {
		// TODO Auto-generated method stub
		System.out.println("ȯ���մϴ�. �ް��ڽ��Դϴ�.");
	}

	@Override
	void reserveSeat(char row, int col) {
		// TODO Auto-generated method stub
		// ASCII ����(row : 65 ~ 67)
		seat[row % 5][col - 1] = true;
		System.out.println(row + "�� " + col + "������ ���� �Ǿ����ϴ�.");
	}

	@Override
	void checkSeat() {
		// TODO Auto-generated method stub
		char row = 'A';
		
		// ����ȣ ���
		System.out.print(" ");
		for (int i = 1; i < seat[0].length + 1; i++) System.out.print(" " + i);
		System.out.println();
		
		for (int i = 0; i < seat.length; i++) {
			// �� ���� ���
			System.out.print(row);
			// �� �¼� ���
			for (int j = 0; j < seat[i].length; j++) {
				if(seat[i][j]) System.out.print(" " + 1);
				else if(!seat[i][j]) System.out.print(" " + 0);
			}
			row += 1;
			System.out.println();
		}
	}
	
}
