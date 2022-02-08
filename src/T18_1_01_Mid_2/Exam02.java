package T18_1_01_Mid_2;

import java.util.Arrays;
import java.util.Random;

public class Exam02 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exam02 ex = new Exam02();
		
		int[][] arr = new int[4][];
		Random rd = new Random();
		int[] arr2 = new int[10];
		int tmp = 0;
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = new int[i + 1];
		}
		
		System.out.println("****배열 생성****");
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = rd.nextInt(10);
				arr2[tmp] = arr[i][j];
				tmp += 1;
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println();
		System.out.println("****배열 정렬 후****");
		arr2 = ex.sort(arr2);
		tmp = 0;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = arr2[tmp];
				tmp += 1;
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	int[] sort(int[] arr2) {
		int tmp;
		for(int i = 0; i < arr2.length; i++) {
			for(int j = 0; j < arr2.length; j++) {
				if(arr2[i] < arr2[j]) {
					tmp = arr2[i];
					arr2[i] = arr2[j];
					arr2[j] = tmp;
				}
			}
		}
		return arr2;
	}
}
