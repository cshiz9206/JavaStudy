package Jjangu;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JjanguLabel extends JLabel implements Runnable {
	Random r;
	int xSize; int ySize;
	int xMax; int yMax;
	int xPos; int yPos;
	int xSpeed; int ySpeed;
	
	int xDir = 1; int yDir = -1;
	
	public JjanguLabel(int jpWidth, int jpHeight) {
		ImageIcon ii = new ImageIcon("C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_Á¤½ÂÇö\\JAVA_edu_Á¤½ÂÇö\\src\\Jjangu\\Jjangu.PNG");
		setIcon(ii);
		xSize = ii.getIconWidth();
		ySize = ii.getIconHeight();
		setSize(xSize, ySize); // setSize(int, int)
		
		r = new Random();
		xMax = jpWidth;
		yMax = jpHeight;
		xPos = r.nextInt(xMax - xSize);
		yPos = r.nextInt(yMax - ySize);
		xSpeed = r.nextInt(4) + 1;
		ySpeed = r.nextInt(4) + 1;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			move();
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void move() {
		if(xPos + xSize >= xMax | xPos <= 0) xDir *= -1;
		if(yPos + ySize >= yMax | yPos <= 0) yDir *= -1;
		
		xPos += (xDir * xSpeed);
		yPos += (yDir * ySpeed);
		setLocation(xPos, yPos);
	}
}
