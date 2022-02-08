package T19_2_End_2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PourWaterFrame extends JFrame implements ActionListener, KeyListener {
	Container ct;
	JButton btnStart;
	JTextArea jtaDrain, jtaPour;
	JLabel jlbAmount;
	JProgressBar jpb;
	WaterTank tank;
	
	public PourWaterFrame() {
		setSize(600, 300);
		setTitle("밑 빠진 독에 물 붓기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ct = getContentPane();
		ct.setLayout(new BorderLayout());
		ct.addKeyListener(this);
		ct.setFocusable(true);
		
		JPanel jpnlG = new JPanel(new GridLayout(1, 3));
		JPanel jpnlB = new JPanel(new BorderLayout());
		JLabel jlbDrain = new JLabel("물 빠짐");
		jtaDrain = new JTextArea();
		jtaDrain.setEditable(false);
		JScrollPane jspDrain = new JScrollPane(jtaDrain);
		jpnlB.add(jlbDrain, BorderLayout.NORTH);
		jpnlB.add(jspDrain, BorderLayout.CENTER);
		JPanel jpnlB2 = new JPanel(new BorderLayout());
		jlbAmount = new JLabel("1000");
		jpb = new JProgressBar(JProgressBar.VERTICAL);
		jpb.setMinimum(0);
		jpb.setMaximum(2000);
		jpb.setValue(1000);
		jpnlB2.add(jlbAmount, BorderLayout.NORTH);
		jpnlB2.add(jpb, BorderLayout.CENTER);
		JPanel jpnlB3 = new JPanel(new BorderLayout());
		JLabel jlbPour = new JLabel("물 부음");
		jtaPour = new JTextArea();
		jtaPour.setEditable(false);
		JScrollPane jspPour = new JScrollPane(jtaPour);
		jpnlB3.add(jlbPour, BorderLayout.NORTH);
		jpnlB3.add(jspPour, BorderLayout.CENTER);
		jpnlG.add(jpnlB);
		jpnlG.add(jpnlB2);
		jpnlG.add(jpnlB3);
		
		ct.add(jpnlG, BorderLayout.CENTER);
		
		btnStart = new JButton("시작");
		btnStart.addActionListener(this);
		ct.add(btnStart, BorderLayout.SOUTH);
		
		tank = new WaterTank(jpb, jlbAmount);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		btnStart.setEnabled(false);
		new WaterHoleThread(tank, jtaDrain).start();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			tank.pour(100);
			jtaPour.append("100ml 부음\n");
		}
		
		if(tank.isFull) {
			jtaPour.append("미션 성공");
			ct.setFocusable(false);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
