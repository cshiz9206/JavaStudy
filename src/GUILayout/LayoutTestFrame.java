package GUILayout;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LayoutTestFrame extends JFrame {
	public LayoutTestFrame() {
		setTitle("Layout test");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container ct = getContentPane();
		ct.setLayout(new GridLayout(3, 1));
		
		JButton[] btns = new JButton[9];
		for(int i = 0; i < 9; i++) btns[i] = new JButton(String.valueOf(i));
	
		JPanel jpnl = new JPanel();
		jpnl.add(btns[0]);
		jpnl.add(btns[1]);
		jpnl.add(btns[2]);
		ct.add(jpnl, BorderLayout.NORTH);
		
		JPanel jpnl1 = new JPanel(new GridLayout(1, 3));
		jpnl1.add(btns[3]);
		jpnl1.add(btns[4]);
		jpnl1.add(btns[5]);
		ct.add(jpnl1);
		
		JPanel jpnl2 = new JPanel(new BorderLayout());
		jpnl2.add(btns[6], BorderLayout.WEST);
		jpnl2.add(btns[7], BorderLayout.CENTER);
		jpnl2.add(btns[8], BorderLayout.EAST);
		ct.add(jpnl2);
		
		setVisible(true);
	}
}
