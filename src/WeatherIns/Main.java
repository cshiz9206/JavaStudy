package WeatherIns;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int[] hs = { 2, 5, 8, 11, 14, 17, 20, 23 };
		
		// 시 입력
		int h = s.nextInt();
		// 분 입력
		int m = s.nextInt();
		
		int nearh = 0;
		
		// 입력한 시간보다 작으면서 가장 가까운 기준 시(hs) 찾기
		for (int i : hs)
			if (h - i >= 0 && h - i < 3)
				nearh = i;
		
		// 입력된 시간의 '분'이 10분을 넘기지 않았을 때 이전 기준시 선택
		if (m < 10) nearh -= 3;

		if (nearh - 3 < 0) nearh = 23;
		
		System.out.print(nearh + " " + 10);
	}

}
