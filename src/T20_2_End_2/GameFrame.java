package T20_2_End_2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameFrame extends JFrame implements ActionListener, KeyListener {
	Character chr; Container ct; JPanel jpnlScreen;
	JLabel jlbHead; JButton btnStart;
	
	public GameFrame() {
		setTitle("SHOW ME THE MONEY"); setSize(500, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ct = getContentPane();
		ct.setLayout(new BorderLayout());
		ct.setBackground(Color.white);
		ct.addKeyListener(this);
		ct.setFocusable(true);
		
		jlbHead = new JLabel("Get Ready!");
		jlbHead.setHorizontalAlignment(JLabel.CENTER);
		jlbHead.setFont(new Font("굴림", Font.BOLD, 25));
		ct.add(jlbHead, BorderLayout.NORTH);
		
		jpnlScreen = new JPanel();
		jpnlScreen.setLayout(null);
		jpnlScreen.setBackground(Color.white);
		chr = new Character(ct.getWidth());
		jpnlScreen.add(chr);
		ct.add(jpnlScreen, BorderLayout.CENTER);
		
		btnStart = new JButton("게임 시작!");
		btnStart.addActionListener(this);
		ct.add(btnStart, BorderLayout.SOUTH);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new TimeThread(jlbHead).start();
		new CreateMoneyThread(this.getWidth(), this.getHeight(), jpnlScreen).start();
		btnStart.setEnabled(false);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyCode() == KeyEvent.VK_LEFT) {
			chr.moveLeft();
		}
		if(arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
			chr.moveRight();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
