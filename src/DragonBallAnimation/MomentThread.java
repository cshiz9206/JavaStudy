package DragonBallAnimation;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MomentThread extends Thread {
	JPanel jp;
	JLabel jlNormal;
	JLabel jlState;
	
	public MomentThread(JPanel jp, JLabel jlNormal, JLabel jlState) {
		this.jp = jp;
		this.jlNormal = jlNormal;
		this.jlState = jlState;
	}
	
	public void run() {
		jp.remove(jlNormal);
		//jlNormal.setVisible(false);
		jp.updateUI();
		
		jp.add(jlState);
		jp.updateUI();
		
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jp.remove(jlState);
		jp.updateUI();
		
		jp.add(jlNormal);
		jp.updateUI();
	}
}
