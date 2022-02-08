package SearchWord;

import java.util.Scanner;

public class StringFinder {
	Scanner sc;
	StringBuffer post = new StringBuffer("Be thankful for what you have; you'll end up having more. If you concentrate on what you don't have, you will never, ever have enough.");
	
	void menu() {
		sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("1. 본문 출력, 2. 단어 검색, 3. 종료");
			System.out.print("메뉴 입력 : ");
			int tmp = sc.nextInt();
			if(tmp == 1) {
				System.out.println(post);
				System.out.println("총 길이 : " + post.length());
				System.out.println();
			}
			else if(tmp == 2) {
				System.out.print("찾을 문자를 입력하세요 : ");
				find();
			}
			else {
				System.out.println("종료합니다.");
				break;
			}
		}
	}
	
	void find() {
		sc = new Scanner(System.in);
		String word = sc.next();
		StringBuffer tmp = new StringBuffer(); // 결과 출력을 위한 변수
		//String tmp2 = new String();
		
		tmp.append(word + "는 ");  //tmp2.concat(word + "는 ");
		// substring 사용시 outofboundsexception 발생 막기 위해 (post 길이 - 단어 길이) 만큼만 검색함
		for(int i = 0; i < post.length() - word.length() + 1; i++) { 
			if(word.equals(post.substring(i, i + word.length()))){
				tmp.append((i + 1) + ", ");  //tmp2.concat((i + 1) + ", ");
			}
		}
		System.out.println(tmp.substring(0, tmp.length() - 2) + "번 째 위치에 있습니다.");
	}
}
