package OXQuiz;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIO {
	FileOutputStream out;
	
	public FileIO() {
		try {
			out = new FileOutputStream("Game_result.txt");
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
	
	public void write_file(String str) {
		try {
			out.write(str.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}