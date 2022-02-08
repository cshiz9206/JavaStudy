package WeatherIns;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int[] hs = { 2, 5, 8, 11, 14, 17, 20, 23 };
		
		// �� �Է�
		int h = s.nextInt();
		// �� �Է�
		int m = s.nextInt();
		
		int nearh = 0;
		
		// �Է��� �ð����� �����鼭 ���� ����� ���� ��(hs) ã��
		for (int i : hs)
			if (h - i >= 0 && h - i < 3)
				nearh = i;
		
		// �Էµ� �ð��� '��'�� 10���� �ѱ��� �ʾ��� �� ���� ���ؽ� ����
		if (m < 10) nearh -= 3;

		if (nearh - 3 < 0) nearh = 23;
		
		System.out.print(nearh + " " + 10);
	}

}
