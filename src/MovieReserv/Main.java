package MovieReserv;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		boolean[][] isArrSeat = new boolean[2][5];
		
		System.out.println("@@ ��ȭ ���� ���α׷� @@");
		while(true) {
			System.out.println("1. �¼� Ȯ��(0 : ���డ��, X : ����Ϸ�)");
			System.out.println("2. �¼� ����");
			System.out.println("3. ����");
			System.out.print("�޴��� �����Ͻÿ� :");
			int menu_num = s.nextInt();
			
			System.out.println();
			
			switch(menu_num) {
				case 1:
					// �¼� ���� ��Ȳ(2���� �迭) ���
					for(int i = 0; i < isArrSeat.length; i++) {
						for(int j = 0; j < isArrSeat[i].length; j++) {
							if(isArrSeat[i][j]) System.out.print('X');
							else System.out.print('O');
						}
						System.out.println();
					}
					break;
					
				case 2:
					// ����
					System.out.print("������ ���� �Է��Ͻÿ� :");
					int reserv_row = s.nextInt() - 1;
					System.out.print(reserv_row + "���� ���� �Է��Ͻÿ� : ");
					int reserv_col = s.nextInt() - 1;
					
					isArrSeat[reserv_row][reserv_col] = true;
					break;
					
				case 3:
					System.out.print("���α׷��� �����մϴ�.");
					return;
			}
			System.out.println();
		}
	}

}
