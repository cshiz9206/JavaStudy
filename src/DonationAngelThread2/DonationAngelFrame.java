package DonationAngelThread2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class DonationAngelFrame extends JFrame implements ActionListener {
	//int total;
	static final int goal = 100000000;
	
	JButton jbtn;
	
	JProgressBar[] jpgDonators;
	JProgressBar jpgTotal;
	
	public DonationAngelFrame() {
		setTitle("기부금 프로그램");
		setSize(500, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container ct = getContentPane();
		ct.setLayout(new BorderLayout());
		
		JPanel jpnlCenter = new JPanel(new GridLayout(11, 1));
		JPanel[] jpnlDonators = new JPanel[10];
		JLabel[] jlbDonators = new JLabel[10];
		int[] donates = new int[10];
		jpgDonators = new JProgressBar[10];
		for(int i = 0; i < 10; i++) {
			jpnlDonators[i] = new JPanel(new BorderLayout());
			JLabel jlbTmp = new JLabel((i + 1) + "번째 성공자");
			jlbTmp.setHorizontalAlignment(JLabel.CENTER);
			jlbDonators[i] = jlbTmp;
			JProgressBar tmp = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100000000);
			tmp.setStringPainted(true);
			tmp.setString(donates[i] + "원 기부!");
			jpgDonators[i] = tmp;
			
			jpnlDonators[i].add(jpgDonators[i], BorderLayout.CENTER);
			jpnlDonators[i].add(jlbDonators[i], BorderLayout.SOUTH);
			jpnlCenter.add(jpnlDonators[i]);
		}
		
		JPanel jpnlTotal = new JPanel(new BorderLayout());
		jpgTotal = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100000000);
		jpgTotal.setStringPainted(true);
		jpgTotal.setString("총 " + 0 + "원 적립!");
		//jpgTotal.set
		JLabel jlbTotal = new JLabel("상금 총액");
		jlbTotal.setHorizontalAlignment(JLabel.CENTER);
		jpnlTotal.add(jpgTotal, BorderLayout.CENTER);
		jpnlTotal.add(jlbTotal, BorderLayout.SOUTH);
		jpnlCenter.add(jpnlTotal);
		
		ct.add(jpnlCenter, BorderLayout.CENTER);
		
		jbtn = new JButton("기부 시작!");
		jbtn.addActionListener(this);
		ct.add(jbtn, BorderLayout.SOUTH);
		
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		jbtn.setEnabled(false);
		
		DonatorThread[] dts = new DonatorThread[10];
		for(int i = 0; i < 10; i++) {
			dts[i] = new DonatorThread(jpgDonators[i]);
			dts[i].setPriority(i + 1);
			dts[i].start();
		}
		
		new TotalThread(jpgTotal, dts).start();
	}
}
