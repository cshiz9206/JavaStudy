package T20_2_End_3_Client;

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
	String[] index = {"신체지수", "감성지수", "지성지수", "지각지수"};
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
		
		jlbIndexes = new JLabel[index.length];
		jpbs = new JProgressBar[index.length];
		JPanel jpnlG2 = new JPanel(new GridLayout(1, 4, 5, 5));
		for(int i = 0; i < jpbs.length; i++) {
			JPanel jpnlB = new JPanel(new BorderLayout());
			jpbs[i] = new JProgressBar(JProgressBar.VERTICAL, -100, 100);
			jpbs[i].setValue(0);
			
			JLabel jlbTitle = new JLabel(index[i]);
			jlbTitle.setHorizontalAlignment(JLabel.CENTER);
			jlbIndexes[i] = jlbTitle;
			
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
		JButton btnCalc = new JButton("계 산");
		btnCalc.addActionListener(this);
		
		jpnlB2.add(inputTitle, BorderLayout.NORTH);
		jpnlB2.add(jpnlG3, BorderLayout.CENTER);
		jpnlB2.add(btnCalc, BorderLayout.SOUTH);
		
		ct.add(jpnlG, BorderLayout.NORTH);
		ct.add(jpnlG2, BorderLayout.CENTER);
		ct.add(jpnlB2, BorderLayout.SOUTH);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getActionCommand().contentEquals("통신 설정")) {
			client = new Client(jtfIP.getText(), Integer.parseInt(jtfPort.getText()), jpbs, jlbIndexes, index);
			client.start();
		}
		if(arg0.getActionCommand().contentEquals("계 산")) {
			client.sendMsg(jtfYear.getText() + "," + jtfMonth.getText() + "," + jtfDate.getText());
		}
	}
}
