package T18_2_01_End_2;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GridAction implements ActionListener {
	JButton[] jbtns;
	JTextField jtfInfo;
	Random rd;
	TicTacToeControl game;
	JPanel jpnlG;
	Container ct;
	
	public GridAction(JButton[] jbtns, JTextField jtfInfo, JPanel jpnlG, Container ct) {
		this.jbtns = jbtns;
		this.jtfInfo = jtfInfo;
		this.jpnlG = jpnlG;
		this.ct = ct;
		rd = new Random();
		game = new TicTacToeControl(jbtns);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(JButton btn : jbtns) {
			if(btn.getModel().isRollover() && btn.isFocusable()) {
				btn.setIcon(new ImageIcon("C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_정승현\\JAVA_edu_정승현\\src\\T18_2_01_End_2\\circle.png"));
				btn.setFocusable(false);
			}
		}
		ct.repaint();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		while(true) {
			int rdn = rd.nextInt(9);
			if(jbtns[rdn].isFocusable()) {
				jbtns[rdn].setIcon(new ImageIcon("C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_정승현\\JAVA_edu_정승현\\src\\T18_2_01_End_2\\rectangle.png"));
				jbtns[rdn].setFocusable(false);
				break;
			}
		}
		
		if(game.judge() == 0) jtfInfo.setText("승자는 사용자입니다!");
		if(game.judge() == 1) jtfInfo.setText("승자는 컴퓨터입니다!");
	}
}
