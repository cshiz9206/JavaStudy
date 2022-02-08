package Jjangu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AnnoyingJjanguFrame extends JFrame implements ActionListener {
	JPanel jp;
	int cnt = 0;
	JButton btn;
	
	public AnnoyingJjanguFrame() {
		setTitle("정신 사나운 짱구");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container ct = getContentPane();
		ct.setLayout(new BorderLayout());
		
		jp = new JPanel();
		jp.setLayout(null);
		jp.setBackground(Color.WHITE);
		ct.add(jp, BorderLayout.CENTER);
		
		btn = new JButton("짱구 만들기 (현재 0개)");
		btn.addActionListener(this);
		ct.add(btn, BorderLayout.SOUTH);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JjanguLabel jj = new JjanguLabel(jp.getWidth(), jp.getHeight());
		jp.add(jj);
		
		cnt += 1;
		btn.setText("짱구 만들기 (현재 " + cnt + "개)");
		
		new Thread((Runnable)jj).start();
	}
}
