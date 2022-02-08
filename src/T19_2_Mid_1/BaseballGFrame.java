package T19_2_Mid_1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BaseballGFrame extends JFrame implements ActionListener {
	JButton start, throwBall;
	BaseballGame game;
	FileIO io;
	JTextField first, twice, third;
	JLabel[] jlbStrikes, jlbBalls;
	JLabel tryCount;
	String str = "";
	
	public BaseballGFrame() {
		setTitle("숫자 야구 게임");
		setSize(300, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container ct = getContentPane();
		ct.setLayout(new BorderLayout());
		start = new JButton("시작");
		start.addActionListener(this);
		throwBall = new JButton("던지기");
		throwBall.addActionListener(this);
		throwBall.setEnabled(false);
		ct.add(start, BorderLayout.NORTH);
		ct.add(throwBall, BorderLayout.SOUTH);
		
		JPanel jpnlG = new JPanel(new GridLayout(2, 4));
		JLabel jlbStrike = new JLabel("S");
		jlbStrike.setFont(new Font("궁서", Font.BOLD, 30));
		jpnlG.add(jlbStrike);
		
		jlbStrikes = new JLabel[3];
		for(int i = 0; i < jlbStrikes.length; i++) {
			jlbStrikes[i] = new JLabel();
			jlbStrikes[i].setIcon(new ImageIcon("C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_정승현\\JAVA_edu_정승현\\src\\T19_2_Mid_1\\black.jpg"));
			jpnlG.add(jlbStrikes[i]);
		}
		
		JLabel jlbBall = new JLabel("B");
		jlbBall.setFont(new Font("궁서", Font.BOLD, 30));
		jpnlG.add(jlbBall);
		
		jlbBalls = new JLabel[3];
		for(int i = 0; i < jlbBalls.length; i++) {
			jlbBalls[i] = new JLabel();
			jlbBalls[i].setIcon(new ImageIcon("C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_정승현\\JAVA_edu_정승현\\src\\T19_2_Mid_1\\black.jpg"));
			jpnlG.add(jlbBalls[i]);
		}
		
		JPanel jpnlG2 = new JPanel(new GridLayout(2, 3));
		JLabel jlbFirst = new JLabel("첫 번째 숫자");
		jlbFirst.setHorizontalAlignment(JLabel.CENTER);
		jpnlG2.add(jlbFirst);
		JLabel jlbTwice = new JLabel("두 번째 숫자");
		jlbTwice.setHorizontalAlignment(JLabel.CENTER);
		jpnlG2.add(jlbTwice);
		JLabel jlbThird = new JLabel("세 번째 숫자");
		jlbThird.setHorizontalAlignment(JLabel.CENTER);
		jpnlG2.add(jlbThird);
		first = new JTextField();
		twice = new JTextField();
		third = new JTextField();
		jpnlG2.add(first);
		jpnlG2.add(twice);
		jpnlG2.add(third);
		
		JPanel jpnlG3 = new JPanel(new GridLayout(2, 1));
		tryCount = new JLabel();
		tryCount.setHorizontalAlignment(JLabel.CENTER);
		tryCount.setFont(new Font("궁서", Font.BOLD, 30));
		jpnlG3.add(tryCount);
		jpnlG3.add(jpnlG);
		
		JPanel jpnlB2 = new JPanel(new BorderLayout());
		jpnlB2.add(jpnlG3, BorderLayout.CENTER);
		jpnlB2.add(jpnlG2, BorderLayout.SOUTH);
		
		ct.add(jpnlB2, BorderLayout.CENTER);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == start) {
			throwBall.setEnabled(true);
			start.setEnabled(false);
			
			game = new BaseballGame();
			str += "정답 : ";
			for(int tmp : game.answer) str += tmp + " ";
			str += "\n";
		}
		else {
			int[] guass = {Integer.parseInt(first.getText()), Integer.parseInt(twice.getText()), Integer.parseInt(third.getText())};
			int[] result = game.judge(guass);
			int strike = result[0];
			int ball = result[1];
			
			for(int i = 0; i < jlbStrikes.length; i++) {
				jlbStrikes[i].setIcon(new ImageIcon("C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_정승현\\JAVA_edu_정승현\\src\\T19_2_Mid_1\\black.jpg"));
			}
			for(int i = 0; i < jlbBalls.length; i++) {
				jlbBalls[i].setIcon(new ImageIcon("C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_정승현\\JAVA_edu_정승현\\src\\T19_2_Mid_1\\black.jpg"));
			}
			for(int i = 0; i < strike; i++) {
				jlbStrikes[i].setIcon(new ImageIcon("C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_정승현\\JAVA_edu_정승현\\src\\T19_2_Mid_1\\blue.jpg"));
			}
			for(int i = 0; i < ball; i++) {
				jlbBalls[i].setIcon(new ImageIcon("C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_정승현\\JAVA_edu_정승현\\src\\T19_2_Mid_1\\red.jpg"));
			}
			
			if(strike == 0) str += game.count + "회 : " + ball + "볼\n";
			else if(ball == 0) str += game.count + "회 : " + strike + "스트라이크\n";
			else str += game.count + "회 : " + strike + "스트라이크, " + ball + "볼\n";
			
			tryCount.setText(String.valueOf(game.count));
			
			if(strike == 3) {
				throwBall.setEnabled(false);
				start.setEnabled(false);
				io = new FileIO();
				io.printf(str);
			}
		}
	}
}
