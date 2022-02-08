package T18_2_02_Mid_2;

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

public class BaseballGFrame extends JFrame implements ActionListener{
	BaseballGame bbg;
	JTextField jtf1, jtf2, jtf3;
	JTextArea jta;
	JLabel jlb;
	int cntMax = 8;
	
	public BaseballGFrame() {
		setTitle("숫자 야구 게임");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container ct = getContentPane();
		ct.setLayout(new BorderLayout());
		
		JPanel jpnlB = new JPanel(new BorderLayout());
		jta = new JTextArea();
		jpnlB.add(jta, BorderLayout.CENTER);
		jlb = new JLabel();
		jpnlB.add(jlb, BorderLayout.SOUTH);
		
		JPanel jpnlG = new JPanel(new GridLayout(1, 4));
		jtf1 = new JTextField();
		jtf2 = new JTextField();
		jtf3 = new JTextField();
		jpnlG.add(jtf1);
		jpnlG.add(jtf2);
		jpnlG.add(jtf3);
		JButton btn = new JButton("Throw");
		btn.addActionListener(this);
		jpnlG.add(btn);
		
		ct.add(jpnlB, BorderLayout.CENTER);
		ct.add(jpnlG, BorderLayout.SOUTH);
		
		bbg = new BaseballGame();
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int[] guass = {Integer.parseInt(jtf1.getText()), Integer.parseInt(jtf2.getText()), Integer.parseInt(jtf3.getText())};
		int[] result = bbg.judge(guass);
		
		if((result[0] == 0) && (result[1] == 0)) jta.append(guass[0] + " " + guass[1] + " " + guass[2] + "\t -> out\n");
		else jta.append(guass[0] + " " + guass[1] + " " + guass[2] + "\t -> " + result[0] + " Strike " + result[1] + " Ball\n");
		
		if(result[0] == 3) jlb.setText("정답입니다!");
		else {
			cntMax -= 1;
			if(cntMax == 0) jlb.setText("실패입니다!");
			else jlb.setText("남은 시도횟수 : " + cntMax + "회");
		}
	}
}
