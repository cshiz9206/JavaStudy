package T20_2_End_2;

import java.awt.Point;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MoneyThread extends JLabel implements Runnable {
	int speed;
	int moneyX;
	int yMax;
	JPanel jpnlScreen;
	
	public MoneyThread(int moneyX, int yMax, JPanel jpnlScreen) {
		this.moneyX = moneyX;
		this.yMax = yMax;
		this.jpnlScreen = jpnlScreen;
		
		ImageIcon ii = new ImageIcon("C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_Á¤½ÂÇö\\JAVA_edu_Á¤½ÂÇö\\src\\T20_2_End_2\\Money.png");
		setIcon(ii);
		setSize(ii.getIconWidth(), ii.getIconHeight());
		setLocation(moneyX, 40);
		
		Random rd = new Random();
		speed = rd.nextInt(4) + 1;
		
		jpnlScreen.add(this);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			if((getY() + getHeight()) >= (yMax - 100)) {
				jpnlScreen.remove(this);
				jpnlScreen.updateUI();
				break;
			}
			if((getX() + getWidth() / 2) <= (Character.getXLocate() + Character.getCharacterWidth()) &&
					(getX() + getWidth() / 2) >= Character.getXLocate() &&
					Character.getYLocate() <= (getY() + getHeight())) {
				jpnlScreen.remove(this);
				jpnlScreen.updateUI();
				Character.addScore();
				break;
			}
			if(TimeThread.isEnd) {
				jpnlScreen.remove(this);
				jpnlScreen.updateUI();
				break;
			}
			setLocation(moneyX, getY() + speed);
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
