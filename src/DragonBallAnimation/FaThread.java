package DragonBallAnimation;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class FaThread extends Thread {
	JPanel jp;
	JLabel jlFa;
	
	int xMax;
	int xPos;
	int xSpeed;
	
	public FaThread(JPanel jp, JLabel jlFa) {
		this.jp = jp;
		this.jlFa = jlFa;
		
		xMax = jp.getWidth();
		xPos = 100;
		xSpeed = 3;
	}
	
	public void run() {
		jp.add(jlFa);
		
		while(true) {
			xPos += xSpeed;
			jlFa.setLocation(xPos, jlFa.getHeight());
			jp.updateUI();
			
			if(xPos >= xMax) // 화면 조금 넘어서 끝
				break;
			
			try {
				sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
