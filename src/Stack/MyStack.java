package Stack;

public class MyStack {
	int[] iaData = new int[5];
	int stkptr = -1; // 첫 데이터의 번호 : 0 / 끝 데이터 번호 : 4(length - 1)
	
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
			System.out.println("스택이 비어있습니다.");
			return;
		}
		System.out.println("popped : " + iaData[stkptr]);
		stkptr -= 1;
	}
}