package SearchWord;

import java.util.Scanner;

public class StringFinder {
	Scanner sc;
	StringBuffer post = new StringBuffer("Be thankful for what you have; you'll end up having more. If you concentrate on what you don't have, you will never, ever have enough.");
	
	void menu() {
		sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("1. ���� ���, 2. �ܾ� �˻�, 3. ����");
			System.out.print("�޴� �Է� : ");
			int tmp = sc.nextInt();
			if(tmp == 1) {
				System.out.println(post);
				System.out.println("�� ���� : " + post.length());
				System.out.println();
			}
			else if(tmp == 2) {
				System.out.print("ã�� ���ڸ� �Է��ϼ��� : ");
				find();
			}
			else {
				System.out.println("�����մϴ�.");
				break;
			}
		}
	}
	
	void find() {
		sc = new Scanner(System.in);
		String word = sc.next();
		StringBuffer tmp = new StringBuffer(); // ��� ����� ���� ����
		//String tmp2 = new String();
		
		tmp.append(word + "�� ");  //tmp2.concat(word + "�� ");
		// substring ���� outofboundsexception �߻� ���� ���� (post ���� - �ܾ� ����) ��ŭ�� �˻���
		for(int i = 0; i < post.length() - word.length() + 1; i++) { 
			if(word.equals(post.substring(i, i + word.length()))){
				tmp.append((i + 1) + ", ");  //tmp2.concat((i + 1) + ", ");
			}
		}
		System.out.println(tmp.substring(0, tmp.length() - 2) + "�� ° ��ġ�� �ֽ��ϴ�.");
	}
}
