package BlockJoyStick;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JoyStickFrame extends JFrame implements KeyListener {
	JPanel[] pnls;
	int tmp = 0;
	
	public JoyStickFrame() {
		setTitle("블록 조이스틱");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container ct = getContentPane();
		ct.setLayout(new GridLayout(3,3,5,5));
		ct.addKeyListener(this);
		ct.setFocusable(true);
		
		pnls = new JPanel[9];
		for(int i = 0; i < 9; i++) {
			pnls[i] = new JPanel();
			pnls[i].setBackground(Color.BLACK);
			pnls[i].setOpaque(true);
			ct.add(pnls[i]);
		}
		
		setVisible(true);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyCode() == KeyEvent.VK_LEFT) {
			pnls[3].setBackground(Color.RED);
		}
		if(arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
			pnls[5].setBackground(Color.RED);
		}
		if(arg0.getKeyCode() == KeyEvent.VK_UP) {
			pnls[1].setBackground(Color.RED);
		}
		if(arg0.getKeyCode() == KeyEvent.VK_DOWN) {
			pnls[7].setBackground(Color.RED);
		}
		
		if((pnls[3].getBackground() == Color.RED) && (pnls[1].getBackground() == Color.RED)) {
			pnls[3].setBackground(Color.BLACK);
			pnls[1].setBackground(Color.BLACK);
			pnls[0].setBackground(Color.RED);
		}
		if((pnls[1].getBackground() == Color.RED) && (pnls[5].getBackground() == Color.RED)) {
			pnls[5].setBackground(Color.BLACK);
			pnls[1].setBackground(Color.BLACK);
			pnls[2].setBackground(Color.RED);
		}
		if((pnls[5].getBackground() == Color.RED) && (pnls[7].getBackground() == Color.RED)) {
			pnls[5].setBackground(Color.BLACK);
			pnls[7].setBackground(Color.BLACK);
			pnls[8].setBackground(Color.RED);
		}
		if((pnls[3].getBackground() == Color.RED) && (pnls[7].getBackground() == Color.RED)) {
			pnls[3].setBackground(Color.BLACK);
			pnls[7].setBackground(Color.BLACK);
			pnls[6].setBackground(Color.RED);
		}
		if((pnls[1].getBackground() == Color.RED) && (pnls[7].getBackground() == Color.RED)) {
			pnls[1].setBackground(Color.BLACK);
			pnls[7].setBackground(Color.BLACK);
			pnls[4].setBackground(Color.RED);
		}
		if((pnls[3].getBackground() == Color.RED) && (pnls[5].getBackground() == Color.RED)) {
			pnls[3].setBackground(Color.BLACK);
			pnls[5].setBackground(Color.BLACK);
			pnls[4].setBackground(Color.RED);
		}
		if((pnls[1].getBackground() == Color.RED) && (pnls[3].getBackground() == Color.RED) && (pnls[7].getBackground() == Color.RED) && (pnls[5].getBackground() == Color.RED)) {
			pnls[1].setBackground(Color.BLACK);
			pnls[3].setBackground(Color.BLACK);
			pnls[5].setBackground(Color.BLACK);
			pnls[7].setBackground(Color.BLACK);
			pnls[4].setBackground(Color.RED);
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		for(JPanel tmp : pnls) tmp.setBackground(Color.BLACK);
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
