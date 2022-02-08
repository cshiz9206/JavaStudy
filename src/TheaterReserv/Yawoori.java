package TheaterReserv;

public class Yawoori extends Theater {

	@Override
	void printWelcome() {
		// TODO Auto-generated method stub
		System.out.println("환영합니다. 야우리입니다.");
	}

	@Override
	void reserveSeat(char row, int col) {
		// TODO Auto-generated method stub
//		int rowNum = 0;
//		if (row == 'A') rowNum = 0;
//		else if(row == 'B') rowNum = 1;
//		else if(row == 'C') rowNum = 2;
		seat[row % 5][col - 1] = true;
		System.out.println(row + "열 " + col + "번으로 예약 되었습니다.");
	}

	@Override
	void checkSeat() {
		// TODO Auto-generated method stub
		char row = 'A';
		
		System.out.print(" ");
		for (int i = 1; i < seat[0].length + 1; i++) System.out.print(" " + i);
		System.out.println();
		
		for (int i = 0; i < seat.length; i++) {
			System.out.print(row);
			for (int j = 0; j < seat[i].length; j++) {
				if(seat[i][j]) System.out.print(" " + 1);
				else if(!seat[i][j]) System.out.print(" " + 0);
			}
			row += 1;
			System.out.println();
		}
	}

}

// 배열 구성, 표시
