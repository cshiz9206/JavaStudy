package Encryptor;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Encryptor {
	protected StringBuffer sbContent;
	protected String infile;
	protected String outfile;
	protected String nonencrypted;
	protected String encrypted;
	
	public Encryptor(String infile, String outfile) {
		sbContent = new StringBuffer("abcegilostz48(391|0572"); // ��ȣȭ ǥ�� string���� ����
		this.infile = infile;
		this.outfile = outfile;
		nonencrypted = "";
		encrypted = "";
	}
	
	protected void fileRead() throws IOException {
		int i;
		FileReader fr = new FileReader(infile);
		while((i = fr.read()) != -1) { // read : ���� ������ -1 ��ȯ
			nonencrypted += (char) i;
		}
	}
	
	protected void fileWrite() throws IOException {
		FileWriter fw = new FileWriter(outfile);
		fw.write(encrypted);
		fw.close();
	}
	
	protected void encryptContent() {
		for(int i = 0; i < nonencrypted.length(); i++) {
			String tmp = String.valueOf(Character.toLowerCase(nonencrypted.charAt(i)));
			if(sbContent.toString().contains(tmp)) { // ���� ������ ���ڸ� ��ȣȭ ǥ���� �����ϴ°�
				int pos = sbContent.indexOf(tmp); // ��ȣȭ ǥ������ ���� ������ ���� ��ġ
				
				// ��ȣȭ ǥ���� ���� ������ ���ڿ� ��Ī�Ǵ� ��ȣ ����
				encrypted += sbContent.charAt((int)(sbContent.length() / 2) + pos); 
			}
			else
				encrypted += nonencrypted.charAt(i); // �������� ���� �� ���� ������ ���� �״�� ���
		}
	}
	
	public void enc() throws IOException {
		fileRead();
		encryptContent();
		fileWrite();
	}
}
