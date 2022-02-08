package SearchWord;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringFinder sf = new StringFinder();
		sf.menu();
	}

}

// StringBuffer.capacity() : 버퍼?
// concat으로 하면 outofboundsexception에 걸리고, stringbuffer를 쓰면 걸리지 않음
// 단어 검색 function 존재 : 