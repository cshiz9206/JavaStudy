package WordCounter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIO {
	FileOutputStream out;
	FileInputStream in;
	
	public FileIO() {
		try {
			in = new FileInputStream("ori_str.txt");
			out = new FileOutputStream("wordfind_result.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void print(String str) {
		System.out.print(str);
		write_file(str);
	}
	
	public void println(String str) {
		System.out.println(str);
		write_file(str + "\n");
	}
	
	public String read_file() {
		int i = 0;
		String context = "";
		try {
			while((i = in.read()) != -1) {
				context += (char)i;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return context;
	}
	
	public void write_file(String str) {
		try {
			out.write(str.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}