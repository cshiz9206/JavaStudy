package test;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.Calendar;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Font[] fonts = e.getAllFonts(); 
		for (Font font : fonts) { System.out.println(font.getFontName()); }
	}

}

// 레이블 블록