package BuildingForest;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		// 빌딩 개수 입력
		int size = s.nextInt();
		
		// 빌딩들 높이 입력
		int[] arr = new int[size];
		for (int i = 0; i < size; i++)
			arr[i] = s.nextInt();
		
		// 크기 비교 및 min, max 저장
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
