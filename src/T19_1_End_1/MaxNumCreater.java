package T19_1_End_1;

import java.util.Random;

public class MaxNumCreater {
	int[] arrNum;
	Random rd;
	
	public MaxNumCreater() {
		rd = new Random();
		arrNum = new int[10];
	}
	
	void randomArray() {
		for(int i = 0; i < arrNum.length; i++) {
			arrNum[i] = rd.nextInt(10);
			System.out.print(arrNum[i]);
		}
	}
	
	void createMaxNum() {
		int tmp;
		for(int i = 0; i < arrNum.length; i++) {
			for(int j = 0; j < arrNum.length;j++) {
				if(arrNum[i] > arrNum[j]) {
					tmp = arrNum[j];
					arrNum[j] = arrNum[i];
					arrNum[i] = tmp;
				}
			}
		}
	}
	
	void print() {
		for(int i = 0; i < arrNum.length; i++) {
			System.out.print(arrNum[i]);
		}
	}
}
