package T19_2_Mid_2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SlotMachineFrame extends JFrame implements ActionListener{
	int balance = 0;
	JTextField jtfFee;
	JButton btnPut, btnLever;
	Random rd = new Random();
	int[] reel1, reel2, reel3;
	JLabel[] jlbNumb;
	JLabel jlbBalance;
	JLabel jlbWin;
	
	public SlotMachineFrame() {
		setTitle("½½·Ô ¸Ó½Å");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container ct = getContentPane();
		ct.setLayout(new BorderLayout());
		
		jlbBalance = new JLabel("ÀÜ¾× : 0¿ø");
		jlbBalance.setHorizontalAlignment(JLabel.CENTER);
		jlbBalance.setFont(new Font("±Ã¼­", Font.BOLD, 20));
		ct.add(jlbBalance, BorderLayout.NORTH);
		
		JPanel jpnlB = new JPanel(new BorderLayout());
		JPanel jpnlG = new JPanel(new GridLayout(3, 3));
		jlbNumb = new JLabel[9];
		for(int i = 0; i < jlbNumb.length; i++) {
			jlbNumb[i] = new JLabel("?");
			jlbNumb[i].setHorizontalAlignment(JLabel.CENTER);
			jpnlG.add(jlbNumb[i]);
		}
		jpnlB.add(jpnlG, BorderLayout.CENTER);
		btnLever = new JButton();
		btnLever.setEnabled(false);
		btnLever.setBorderPainted(false);
		btnLever.setContentAreaFilled(false);
		btnLever.setIcon(new ImageIcon("C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_Á¤½ÂÇö\\JAVA_edu_Á¤½ÂÇö\\src\\T19_2_Mid_2\\lever.jpg"));
		btnLever.addActionListener(this);
		jpnlB.add(btnLever, BorderLayout.EAST);
		ct.add(jpnlB, BorderLayout.CENTER);
		
		JPanel jpnlG2 = new JPanel(new GridLayout(2, 3));
		JLabel jlbFee = new JLabel("³ÖÀ» ±Ý¾×");
		jlbFee.setHorizontalAlignment(JLabel.RIGHT);
		jtfFee = new JTextField();
		btnPut = new JButton("³Ö±â");
		btnPut.addActionListener(this);
		jlbWin = new JLabel("´çÃ·±Ý : 0¿ø");
		jlbWin.setFont(new Font("±Ã¼­", Font.BOLD, 20));
		jpnlG2.add(jlbFee);
		jpnlG2.add(jtfFee);
		jpnlG2.add(btnPut);
		jpnlG2.add(new JLabel(""));
		jpnlG2.add(jlbWin);
		jpnlG2.add(new JLabel(""));
		ct.add(jpnlG2, BorderLayout.SOUTH);
		
		setVisible(true);
		
		reel1 = setReel();
		reel2 = setReel();
		reel3 = setReel();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int win = 0;
		if(e.getActionCommand().contentEquals("³Ö±â")) {
			balance += Integer.parseInt(jtfFee.getText());
			jlbBalance.setText("ÀÜ¾× : " + balance + "¿ø");
			if(balance >= 500) {
				btnPut.setEnabled(false);
				btnLever.setIcon(new ImageIcon("C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_Á¤½ÂÇö\\JAVA_edu_Á¤½ÂÇö\\src\\T19_2_Mid_2\\lever_pulled.jpg"));
				btnLever.setEnabled(true);
			}
		}
		else {
			balance -= 500;
			jlbBalance.setText("ÀÜ¾× : " + balance + "¿ø");
			
			wheelReel();
			
			if(jlbNumb[3].getText().contentEquals(jlbNumb[4].getText()) && jlbNumb[4].getText().contentEquals(jlbNumb[5].getText())) {
				win = 5000;
			}
			if(Integer.parseInt(jlbNumb[3].getText()) + 1 == Integer.parseInt(jlbNumb[4].getText()) 
					&& Integer.parseInt(jlbNumb[4].getText()) + 1 == Integer.parseInt(jlbNumb[5].getText())) {
				win = 10000;
			}
			balance += win;
			jlbWin.setText("´çÃ·±Ý : " + win + "¿ø");
			jlbBalance.setText("ÀÜ¾× : " + balance + "¿ø");
			
			if(balance < 500) {
				btnLever.setEnabled(false);
				btnLever.setIcon(new ImageIcon("C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_Á¤½ÂÇö\\JAVA_edu_Á¤½ÂÇö\\src\\T19_2_Mid_2\\lever.jpg"));
				btnPut.setEnabled(true);
			}
		}
	}
	
	int[] setReel() {
		int[] reel = new int[9];
		for(int i = 0; i < reel.length; i++) {
			reel[i] = i + 1;
		}
		
		return reel;
	}
	
	void wheelReel() {
		int rdn1 = rd.nextInt(9);
		int rdn2 = rd.nextInt(9);
		int rdn3 = rd.nextInt(9);
		int j = 0;
		for(int i = 0; i < jlbNumb.length; i++) {
			if(i % 3 == 0) {
				jlbNumb[i].setText(String.valueOf(reel1[rdn1]));
				rdn1 += 1;
				if(rdn1 >= 9) rdn1 = rdn1 % 9;
			}
			if((i - 1) % 3 == 0) {
				jlbNumb[i].setText(String.valueOf(reel2[rdn2]));
				rdn2 += 1;
				if(rdn2 >= 9) rdn2 = rdn2 % 9;
			}
			if((i - 2) % 3 == 0) {
				jlbNumb[i].setText(String.valueOf(reel3[rdn3]));
				rdn3 += 1;
				if(rdn3 >= 9) rdn3 = rdn3 % 9;
			}
		}
	}
}
