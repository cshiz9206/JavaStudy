package T18_2_02_End_2;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PigThread extends JLabel implements Runnable {
	int xMax, xPos, speed, dir;
	JPanel jpnl;
	Random rd;
	JButton btn;
	static boolean isDead = false;
	
	public PigThread(JPanel jpnl, JButton btn) {
		this.jpnl = jpnl;
		this.btn = btn;
		ImageIcon ii = new ImageIcon("C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_Á¤½ÂÇö\\JAVA_edu_Á¤½ÂÇö\\src\\T18_2_02_End_2\\pig.png");
		setIcon(ii);
		setSize(100, 50);
		
		xPos = 200;
		setLocation(xPos, 0);
		
		jpnl.add(this);
		rd = new Random();
		
		xMax = jpnl.getWidth();
		dir = 1;
	}
	
	public void run() {
		while(true) {
			if((DartThread.yPos <= getHeight()) && (DartThread.xPos <= (xPos + getWidth())) && (DartThread.xPos >= xPos)) {
				isDead = true;
				ImageIcon ii = new ImageIcon("C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_Á¤½ÂÇö\\JAVA_edu_Á¤½ÂÇö\\src\\T18_2_02_End_2\\pigDamaged.png");
				setIcon(ii);
				setSize(100, 50);
				btn.setEnabled(false);
				break;
			}
			if(xPos + getWidth() >= xMax) {
				setLocation(xMax - getWidth(), 0);
				dir *= -1;
			}
			if(xPos <= 0) {
				setLocation(0, 0);
				dir *= -1;
			}
			
			speed = rd.nextInt(30) + 20;
			xPos = getX() + (speed * dir);
			setLocation(xPos, 0);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
