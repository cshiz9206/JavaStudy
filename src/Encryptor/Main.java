package Encryptor;

import java.io.IOException;

// 1��1 ��Ī ��ȣ��� ������ Ȱ��(index Ȱ��)
// string�� �迭�� ���� ����Ͽ� ��ȣȭ
// ��ȣȭ ǥ�� string���� �����Ͽ� ���

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Encryptor encryptor = new Encryptor("C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_������\\JAVA_edu_������\\src\\Encryptor\\obama.txt", "C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_������\\JAVA_edu_������\\src\\Encryptor\\encrypted.txt");
		encryptor.enc();
	}

}