package TicTacToe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TicTacToeFrame extends JFrame implements ActionListener {
	JButton[][] buttons;
	JTextArea jta;
	
	public TicTacToeFrame() {
		setTitle("Tic Tac Toe");
		setSize(300, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container ct = getContentPane();
		ct.setLayout(new BorderLayout());
		
		JPanel jpnl = new JPanel(new GridLayout(3, 3, 5, 5));
		buttons = new JButton[3][3];
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				buttons[i][j] = new JButton();
				buttons[i][j].setBackground(Color.black);
				buttons[i][j].setOpaque(true);
				buttons[i][j].addActionListener(this);
				jpnl.add(buttons[i][j]);
			}
		}
		ct.add(jpnl, BorderLayout.CENTER);
		
		jta = new JTextArea();
		ct.add(jta, BorderLayout.SOUTH);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(JButton[] line : buttons) {
			for(JButton btn : line) {
				if(btn.hasFocus() && btn.isEnabled()) {
					btn.setText("O");
					btn.setEnabled(false);
				}
			}
		}
		
		int cnt = 0;
		while(true) {
			Random rd = new Random();
			int rdnRow = rd.nextInt(3);
			int rdnCol = rd.nextInt(3);
			if(buttons[rdnRow][rdnCol].isEnabled()) {
				buttons[rdnRow][rdnCol].setText("X");
				buttons[rdnRow][rdnCol].setEnabled(false);
				break;
			}
			cnt += 1;
			if(cnt == 8) break;
		}
		
		boolean userWin = false;
		boolean compWin = false;
		int cntUser = 0;
		int cntComp = 0;
		for(int i = 0; i < 3; i++) {
			if(buttons[i][i].getText() == "O") cntUser += 1;
			if(buttons[i][i].getText() == "X") cntComp += 1;
		}
		if(cntUser == 3) userWin = true;
		else if (cntComp == 3) compWin = true;
		
		cntUser = 0;
		cntComp = 0;
		for(int i = 0; i < 3; i++) {
			if(buttons[i][2 - i].getText() == "O") cntUser += 1;
			if(buttons[i][2 - i].getText() == "X") cntComp += 1;
		}
		if(cntUser == 3) userWin = true;
		else if (cntComp == 3) compWin = true;
		
		for(int i = 0; i < 3; i++) {
			cntUser = 0;
			cntComp = 0;
			for(int j = 0; j < 3; j++) {
				if(buttons[i][j].getText() == "O") cntUser += 1;
				if(buttons[i][j].getText() == "X") cntComp += 1;
			}
		}
		if(cntUser == 3) userWin = true;
		else if (cntComp == 3) compWin = true;
		
		for(int i = 0; i < 3; i++) {
			cntUser = 0;
			cntComp = 0;
			for(int j = 0; j < 3; j++) {
				if(buttons[j][i].getText() == "O") {
					cntUser += 1;
					if(cntUser == 3) userWin = true;
				}
				if(buttons[j][i].getText() == "X") {
					cntComp += 1;
					if (cntComp == 3) compWin = true;
				}
			}
		}
		
		boolean flag = false;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(buttons[i][j].isEnabled()) {
					flag = true;
				}
			}
		}
		
		if(userWin || compWin || !flag) result(userWin, compWin);
	}
	
	void result(boolean userWin, boolean compWin) {
		if(userWin) jta.setText("³ªÀÇ ½Â¸®!");
		else if (compWin) jta.setText("ÄÄÇ»ÅÍÀÇ ½Â¸®!");
		else jta.setText("ºñ°å½À´Ï´Ù");
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(buttons[i][j].isEnabled()) {
					buttons[i][j].setText("-");
					buttons[i][j].setEnabled(false);
				}
			}
		}
	}
}
