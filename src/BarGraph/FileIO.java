package BarGraph;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIO {
	FileOutputStream ops;
	
	public FileIO() {
		try {
			ops = new FileOutputStream("Bar_graph.txt");
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
		// 입력받은 string을 byte 배열로 변환하고 출력
		try {
			ops.write(str.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
