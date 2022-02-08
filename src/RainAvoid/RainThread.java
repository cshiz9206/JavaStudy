package RainAvoid;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RainThread extends Thread {
	JPanel jpnl;
	JLabel jlbCh;
	JLabel jlbRain;
	Random rd = new Random();
	static boolean isDead = false;
	
	public RainThread(JPanel jpnl, JLabel jlbCh) {
		this.jpnl = jpnl;
		this.jlbCh = jlbCh;
		
		ImageIcon rain = new ImageIcon("C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_Á¤½ÂÇö\\JAVA_edu_Á¤½ÂÇö\\src\\RainAvoid\\rain.png");
		jlbRain = new JLabel();
		jlbRain.setIcon(rain);
		jlbRain.setSize(rain.getIconWidth(), rain.getIconHeight());
	}
	
	public void run() {
		int rdn = rd.nextInt(500);
		jlbRain.setLocation(rdn, 0);
		jpnl.add(jlbRain);
		while(true) {
			if(isDead) {
				jpnl.remove(jlbRain);
				break;
			}
			
			try {
				sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			jlbRain.setLocation(rdn, jlbRain.getY() + (rd.nextInt(5) + 1));
			
			boolean inx = (jlbCh.getX() <= jlbRain.getX()) && (jlbCh.getX() + jlbCh.getWidth() >= jlbRain.getX() + jlbRain.getWidth());
			boolean iny = jlbCh.getY() <= jlbRain.getY() + jlbRain.getHeight();
			if(inx && iny) isDead = true;
			
			if((jlbRain.getY() + jlbRain.getHeight()) >= 650) {
				jpnl.remove(jlbRain);
				break;
			}
		}
	}
}
