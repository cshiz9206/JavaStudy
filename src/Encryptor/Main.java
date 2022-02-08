package Encryptor;

import java.io.IOException;

// 1대1 대칭 암호라는 성질을 활용(index 활용)
// string이 배열인 점을 사용하여 암호화
// 암호화 표를 string으로 저장하여 사용

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Encryptor encryptor = new Encryptor("C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_정승현\\JAVA_edu_정승현\\src\\Encryptor\\obama.txt", "C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_정승현\\JAVA_edu_정승현\\src\\Encryptor\\encrypted.txt");
		encryptor.enc();
	}

}