package MovieReserv;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		boolean[][] isArrSeat = new boolean[2][5];
		
		System.out.println("@@ 영화 예약 프로그램 @@");
		while(true) {
			System.out.println("1. 좌석 확인(0 : 예약가능, X : 예약완료)");
			System.out.println("2. 좌석 예약");
			System.out.println("3. 종료");
			System.out.print("메뉴를 선택하시오 :");
			int menu_num = s.nextInt();
			
			System.out.println();
			
			switch(menu_num) {
				case 1:
					// 좌석 예약 현황(2차원 배열) 출력
					for(int i = 0; i < isArrSeat.length; i++) {
						for(int j = 0; j < isArrSeat[i].length; j++) {
							if(isArrSeat[i][j]) System.out.print('X');
							else System.out.print('O');
						}
						System.out.println();
					}
					break;
					
				case 2:
					// 예약
					System.out.print("예약할 행을 입력하시오 :");
					int reserv_row = s.nextInt() - 1;
					System.out.print(reserv_row + "행의 열을 입력하시오 : ");
					int reserv_col = s.nextInt() - 1;
					
					isArrSeat[reserv_row][reserv_col] = true;
					break;
					
				case 3:
					System.out.print("프로그램을 종료합니다.");
					return;
			}
			System.out.println();
		}
	}

}
