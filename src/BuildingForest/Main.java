package BuildingForest;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		// ���� ���� �Է�
		int size = s.nextInt();
		
		// ������ ���� �Է�
		int[] arr = new int[size];
		for (int i = 0; i < size; i++)
			arr[i] = s.nextInt();
		
		// ũ�� �� �� min, max ����
		int min = 1000;
		int max = 0;
		for (int i : arr) {
			if (max < i)
				max = i;
			if (min > i)
				min = i;
		}
		
		System.out.print(max + " " + min);
	}

}
