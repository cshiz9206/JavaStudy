package ChangeColor;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class ChangeColorFrame extends JFrame implements ActionListener {
	JTextField jtfR;
	JTextField jtfG;
	JTextField jtfB;
	
	Container ct;
	
	public ChangeColorFrame() {
		setTitle("스레드 - 색상변경");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 600);
		
		ct = getContentPane();
		ct.setLayout(new BorderLayout());

		JPanel jpnl2 = new JPanel(new BorderLayout());
		JPanel jpnl = new JPanel(new GridLayout(2, 3));
		JLabel jlbR = new JLabel("R");
		JLabel jlbG = new JLabel("G");
		JLabel jlbB = new JLabel("B");
		jlbR.setHorizontalAlignment(JLabel.CENTER);
		jlbG.setHorizontalAlignment(JLabel.CENTER);
		jlbB.setHorizontalAlignment(JLabel.CENTER);
		
		jtfR = new JTextField();
		jtfG = new JTextField();
		jtfB = new JTextField();
		
		jpnl.add(jlbR);
		jpnl.add(jlbG);
		jpnl.add(jlbB);
		jpnl.add(jtfR);
		jpnl.add(jtfG);
		jpnl.add(jtfB);
		
		jpnl2.add(jpnl, BorderLayout.CENTER);
		
		JButton btn = new JButton("색 변경");
		btn.addActionListener(this);
		
		jpnl2.add(btn, BorderLayout.SOUTH);
		
		ct.add(jpnl2, BorderLayout.SOUTH);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(Integer.parseInt(jtfR.getText()) <= 255 & Integer.parseInt(jtfG.getText()) <= 255 & Integer.parseInt(jtfB.getText()) <= 255) { 
			new ChangeColorThread(ct, Integer.parseInt(jtfR.getText()), Integer.parseInt(jtfG.getText()), Integer.parseInt(jtfB.getText())).start();
		}
	}
}
