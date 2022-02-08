package T19_1_End_1;

public class Exam01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("랜덤 숫자(0~9) 10개");
		MaxNumCreater mnc = new MaxNumCreater();
		mnc.randomArray();
		System.out.println("를 생성하였습니다.");
		
		System.out.println("랜덤 숫자 10개를 조합한 가장 큰 숫자는");
		mnc.createMaxNum();
		mnc.print();
		System.out.println("입니다.");
	}

}
