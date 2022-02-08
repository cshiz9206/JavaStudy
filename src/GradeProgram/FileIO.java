package GradeProgram;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIO {
	FileOutputStream out;
	
	public FileIO() {
		try {
			out = new FileOutputStream("total_score.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int[] read_score(String name) {
		int[] grades = new int[4];
		
		try {
			FileInputStream in = new FileInputStream(name);
			int i = 0;
			String context = "";
			while((i = in.read()) != -1) {
				context += (char) i;
			}
			
			String[] line = context.split("\n");
			for(int j = 0; j < line.length; j++) {
				String[] word = line[j].split(" : ");
				grades[j] = Integer.parseInt(word[1].trim());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return grades;
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
