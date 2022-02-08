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
		// �Է¹��� string�� byte �迭�� ��ȯ�ϰ� ���
		try {
			ops.write(str.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
