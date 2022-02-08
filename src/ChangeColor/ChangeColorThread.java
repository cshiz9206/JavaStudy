package ChangeColor;

import java.awt.Color;
import java.awt.Container;
import java.util.Random;

public class ChangeColorThread extends Thread {
	Container ct;
	int r, g, b;
	Color bkColor;
	
	public ChangeColorThread(Container ct, int r, int g, int b) {
		this.ct = ct;
		this.r = r;
		this.g = g;
		this.b = b;
		
		bkColor = new Color(r, g, b);
		ct.setBackground(bkColor);
	}
	
	public void run() {
		while(true) {
			try {
				sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Random rd = new Random();
			int rdn = rd.nextInt(5);
			
			r -= rdn;
			g -= rdn;
			b -= rdn;
			if(r <= 0) r = 0;
			if(g <= 0) g = 0;
			if(b <= 0) b = 0;
			if(r <= 0 & g <= 0 & b <= 0) break;
			
			bkColor = new Color(r, g, b);
			ct.setBackground(bkColor);
		}
	}
}
