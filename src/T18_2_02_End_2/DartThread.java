package T18_2_02_End_2;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DartThread extends JLabel implements Runnable {
	int speed;
	static int xPos = 250;
	static int yPos = 350;
	JPanel jpnl;
	ImageIcon ii;
	
	public DartThread(JPanel jpnl) {
		this.jpnl = jpnl;
		ii = new ImageIcon("C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_Á¤½ÂÇö\\JAVA_edu_Á¤½ÂÇö\\src\\T18_2_02_End_2\\arrow.png");
		setIcon(ii);
		setSize(30, 50);

		setLocation(xPos, yPos);
		
		speed = 30;
	}
	
	public void run() {
		yPos = 350;
		setLocation(xPos, yPos);
		jpnl.add(this);
		while(true) {
			if(PigThread.isDead || yPos <= 0) {
				setVisible(false);
				xPos = 250; yPos = 350;
				remove(this);
				break;
			}
			
			yPos = getY() - speed;
			setLocation(xPos, yPos);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
