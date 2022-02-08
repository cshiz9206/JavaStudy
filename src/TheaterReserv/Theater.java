package TheaterReserv;

public abstract class Theater {
	boolean[][] seat = new boolean[3][5];
	
	abstract void printWelcome();
	
	// 매개변수로 입력된 좌석 예약
	abstract void reserveSeat(char row, int col);
	
	// 모든 좌석 현황 출력
	abstract void checkSeat();
}
