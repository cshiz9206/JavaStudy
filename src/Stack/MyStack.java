package Stack;

public class MyStack {
	int[] iaData = new int[5];
	int stkptr = -1; // ù �������� ��ȣ : 0 / �� ������ ��ȣ : 4(length - 1)
	
	void push(int n) {
		if(stkptr == iaData.length - 1) {
			System.out.println("overflow");
			return;
		}
		stkptr += 1;
		iaData[stkptr] = n;
		System.out.println("pushed : " + iaData[stkptr]);
	}
	
	void pop() {
		if(stkptr < 0) { 
			System.out.println("������ ����ֽ��ϴ�.");
			return;
		}
		System.out.println("popped : " + iaData[stkptr]);
		stkptr -= 1;
	}
}