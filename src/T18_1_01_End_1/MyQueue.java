package T18_1_01_End_1;

public class MyQueue {
	int[] q = new int[10];
	int i = 0;
	
	public void push(int num) {
		for(int i = 9; i >= 1; i--) {
			q[i] = q[i - 1];
		}
		q[0] = num;
	}
	
	public void printQ() {
		for(int i = 0; i < q.length; i++) {
			System.out.println("queue[" + i + "] : " + q[i]);
		}
	}
}
