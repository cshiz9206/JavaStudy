package CatGame;

import javax.swing.JLabel;

public class CatThread extends Thread{
	JLabel cat, mouse;
	
	public CatThread(JLabel cat, JLabel mouse) {
		this.mouse = mouse;
		this.cat = cat;
	}
	
	public void run() {
		
		while(true) {
			try {
				sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int directionX = 0;
			int directionY = 0;
			
			if(mouse.getX() - cat.getX() > 0) directionX = 1;
			if(mouse.getX() - cat.getX() < 0) directionX = -1;
			if(mouse.getY() - cat.getY() > 0) directionY = 1;
			if(mouse.getY() - cat.getY() < 0) directionY = -1;
			if(cat.getX() == mouse.getX() && cat.getY() == mouse.getY()) {
				directionX = 0; directionY = 0;
			}
			
//			
//			double x = mouse.getX() - cat.getX();
//			double y = mouse.getY() - cat.getY();
//			double theta = Math.atan((y / Math.abs(Math.pow(x, 2) + Math.pow(y, 2))) / (x / Math.abs(Math.pow(x, 2) + Math.pow(y, 2))));
//			System.out.println(theta);
//			cat.setLocation((int)(cat.getX() + Math.cos(theta)), (int)(cat.getY() + Math.sin(theta)));
			cat.setLocation(cat.getX() + directionX, cat.getY() + directionY);
		}
	}
}
