package T20_2_End_4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class BioRhythmClientFrame extends JFrame implements ActionListener {
	JTextField jtfIP, jtfPort;
	JTextField jtfYear, jtfMonth, jtfDate;
	JLabel[] jlbIndexes;
	JProgressBar[] jpbs;
	Client client;
	
	public BioRhythmClientFrame() {
		setTitle("TCP Biorhythm 클라이언트");
		setSize(400, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container ct = getContentPane();
		ct.setLayout(new BorderLayout());
		
		JPanel jpnlG = new JPanel(new GridLayout(2, 3));
		JLabel jlbIP = new JLabel("Server IP");
		jlbIP.setHorizontalAlignment(JLabel.CENTER);
		JLabel jlbPort = new JLabel("Server Port");
		jlbPort.setHorizontalAlignment(JLabel.CENTER);
		jtfIP = new JTextField();
		jtfPort = new JTextField();
		JButton btnSet = new JButton("통신 설정");
		btnSet.addActionListener(this);
		jpnlG.add(jlbIP);
		jpnlG.add(jlbPort);
		jpnlG.add(new JLabel());
		jpnlG.add(jtfIP);
		jpnlG.add(jtfPort);
		jpnlG.add(btnSet);
		
		jpbs = new JProgressBar[10];
		JPanel jpnlG2 = new JPanel(new GridLayout(10, 1, 5, 5));
		for(int i = 0; i < jpbs.length; i++) {
			JPanel jpnlB = new JPanel(new BorderLayout());
			jpbs[i] = new JProgressBar(-100, 100);
			jpbs[i].setValue(0);
			jpbs[i].setStringPainted(true);
			
			JLabel jlbTitle = new JLabel("오늘로부터 " + i + "일 후");
			jlbTitle.setHorizontalAlignment(JLabel.CENTER);
			
			jpnlB.add(jpbs[i], BorderLayout.CENTER);
			jpnlB.add(jlbTitle, BorderLayout.SOUTH);
			jpnlG2.add(jpnlB);
		}
		
		JPanel jpnlB2 = new JPanel(new BorderLayout());
		JPanel jpnlG3 = new JPanel(new GridLayout(2, 3));
		JLabel jlbYear = new JLabel("연도");
		jlbYear.setHorizontalAlignment(JLabel.CENTER);
		JLabel jlbMonth = new JLabel("월");
		jlbMonth.setHorizontalAlignment(JLabel.CENTER);
		JLabel jlbDate = new JLabel("일");
		jlbDate.setHorizontalAlignment(JLabel.CENTER);
		jtfYear = new JTextField();
		jtfMonth = new JTextField();
		jtfDate = new JTextField();
		jpnlG3.add(jlbYear);
		jpnlG3.add(jlbMonth);
		jpnlG3.add(jlbDate);
		jpnlG3.add(jtfYear);
		jpnlG3.add(jtfMonth);
		jpnlG3.add(jtfDate);
		
		JLabel inputTitle = new JLabel("생년월일 입력");
		inputTitle.setBackground(Color.LIGHT_GRAY);
		inputTitle.setOpaque(true);
		inputTitle.setHorizontalAlignment(JLabel.CENTER);
		
		JPanel jpnlG4 = new JPanel(new GridLayout(1, 4));
		JButton btnBody = new JButton("신체지수");
		btnBody.addActionListener(this);
		JButton btnSens = new JButton("감성지수");
		btnSens.addActionListener(this);
		JButton btnJisung = new JButton("지성지수");
		btnJisung.addActionListener(this);
		JButton btnJigak = new JButton("지각지수");
		btnJigak.addActionListener(this);
		jpnlG4.add(btnBody);
		jpnlG4.add(btnSens);
		jpnlG4.add(btnJisung);
		jpnlG4.add(btnJigak);
		
		jpnlB2.add(inputTitle, BorderLayout.NORTH);
		jpnlB2.add(jpnlG3, BorderLayout.CENTER);
		jpnlB2.add(jpnlG4, BorderLayout.SOUTH);
		
		ct.add(jpnlG, BorderLayout.NORTH);
		ct.add(jpnlG2, BorderLayout.CENTER);
		ct.add(jpnlB2, BorderLayout.SOUTH);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getActionCommand().contentEquals("통신 설정")) {
			client = new Client(jtfIP.getText(), Integer.parseInt(jtfPort.getText()), jpbs);
			client.start();
		}
		else {
			client.sendMsg(arg0.getActionCommand() + "," + jtfYear.getText() + "," + jtfMonth.getText() + "," + jtfDate.getText());
		}
	}
}
