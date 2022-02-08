package ConvBin;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		int size = s.nextInt();
		int[] bin = new int[size];
		for (int i = 0; i < size; i++)
			bin[i] = s.nextInt();
		
		int sum = 0;
		for (int i = 0; i < size; i++)
			sum += bin[i] * Math.pow(2, (size - 1) - i);
		
		System.out.print(sum);
	}

}
