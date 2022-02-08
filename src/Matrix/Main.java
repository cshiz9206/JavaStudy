package Matrix;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		int row = 2;
		int col = 2;
		
		// A 积己
		int[][] matrix1 = new int[row][col];
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				matrix1[i][j] = s.nextInt();
		
		// B 积己
		int[][] matrix2 = new int[row][col];
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				matrix2[i][j] = s.nextInt();
		
		// A + B
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(matrix1[i][j] + matrix2[i][j] + " ");
			}
		}
		
		System.out.println();
		
		// A - B
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(matrix1[i][j] - matrix2[i][j] + " ");
			}
		}
		
		System.out.println();
		
		// A * B
		int[][] mul_matrix = new int[row][col];
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				for (int n = 0; n < col; n++)
					mul_matrix[i][j] += matrix1[i][n] * matrix2[n][j];
		
		// A * B 搬苞 免仿
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				System.out.print(mul_matrix[i][j] + " ");
	}

}
