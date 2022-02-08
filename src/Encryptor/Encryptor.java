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
		sbContent = new StringBuffer("abcegilostz48(391|0572"); // 암호화 표를 string으로 저장
		this.infile = infile;
		this.outfile = outfile;
		nonencrypted = "";
		encrypted = "";
	}
	
	protected void fileRead() throws IOException {
		int i;
		FileReader fr = new FileReader(infile);
		while((i = fr.read()) != -1) { // read : 파일 끝에서 -1 반환
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
			if(sbContent.toString().contains(tmp)) { // 파일 내용의 문자를 암호화 표에서 포함하는가
				int pos = sbContent.indexOf(tmp); // 암호화 표에서의 파일 내용의 문자 위치
				
				// 암호화 표에서 파일 내용의 문자와 대칭되는 암호 문자
				encrypted += sbContent.charAt((int)(sbContent.length() / 2) + pos); 
			}
			else
				encrypted += nonencrypted.charAt(i); // 포함하지 않을 시 파일 내용의 문자 그대로 사용
		}
	}
	
	public void enc() throws IOException {
		fileRead();
		encryptContent();
		fileWrite();
	}
}
