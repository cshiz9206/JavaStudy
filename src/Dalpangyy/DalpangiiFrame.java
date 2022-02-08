package Dalpangyy;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DalpangiiFrame extends JFrame {
	public DalpangiiFrame() {
		setSize(750, 750);
		setTitle("달팽이 버튼");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container ct = getContentPane();
		JPanel jpnl = new JPanel(new GridLayout(1, 2));
		ct.add(jpnl);
		
		JPanel tmp = new JPanel();
		
		for(int i = 0; i < 15; i++) {
			if( i % 4 == 0 ) {
				jpnl.add(new JButton(String.valueOf(i + 1)));
				tmp = new JPanel(new GridLayout(2, 1));
				jpnl.add(tmp);
			}
			else if((i - 1) % 4 == 0) {
				jpnl.add(new JButton(String.valueOf(i + 1)));
				tmp = new JPanel(new GridLayout(1, 2));
				jpnl.add(tmp);
			}
			else if((i - 2) % 4 == 0) {
				tmp = new JPanel(new GridLayout(2, 1));
				jpnl.add(tmp);
				jpnl.add(new JButton(String.valueOf(i + 1)));
			}
			else if((i - 3) % 4 == 0) {
				tmp = new JPanel(new GridLayout(1, 2));
				jpnl.add(tmp);
				jpnl.add(new JButton(String.valueOf(i + 1)));
			}
			jpnl = tmp;
		}
		
		setVisible(true);
	}
}
