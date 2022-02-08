import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class ChangeColor extends JFrame {
	public ChangeColor() {
		setTitle("스레드 - 색상변경");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 600);
		
		Container ct = getContentPane();
		ct.setLayout(new BorderLayout());
		
		JTextField jtf = new JTextField();
		ct.add(jtf, BorderLayout.NORTH);
		
		JPanel jpnl = new JPanel(new GridLayout(2, 3));
		JLabel jlbR = new JLabel("R");
		JLabel jlbG = new JLabel("G");
		JLabel jlbB = new JLabel("B");
		jlbR.setAlignmentX(WIDTH);
		jlbG.setAlignmentX(WIDTH);
		jlbB.setAlignmentX(WIDTH);
		
		JTextField jtfR = new JTextField();
		JTextField jtfG = new JTextField();
		JTextField jtfB = new JTextField();
		
		jpnl.add(jlbR);
		jpnl.add(jlbG);
		jpnl.add(jlbB);
		jpnl.add(jtfR);
		jpnl.add(jtfG);
		jpnl.add(jtfB);
		
		ct.add(jpnl, BorderLayout.CENTER);
		
		JButton btn = new JButton("색 변경");
		Color bkColor = new Color(100, 100, 100);
		btn.setBackground(bkColor);
		
		ct.add(btn, BorderLayout.SOUTH);
		
		setVisible(true);
	}
}
