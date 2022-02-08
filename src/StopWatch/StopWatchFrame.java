package StopWatch;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StopWatchFrame extends JFrame implements ActionListener {
	JButton btnStop;
	JButton btnLap;
	
	JLabel totalTime;
	JLabel lapTime;
	
	DefaultTableModel dtm;
	JTable jtb;
	
	int cnt = 1;
	
	TotalClockThread totalClock;
	LapClockThread lapClock;
	
	public StopWatchFrame() {
		setTitle("�����ġ");
		setSize(500, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container ct = getContentPane();
		ct.setLayout(new BorderLayout());
		
		JPanel jpnFlow = new JPanel();
		JPanel jpn = new JPanel(new GridLayout(4, 1));

		JLabel totalHead = new JLabel("[�� �ð�]");
		totalHead.setHorizontalAlignment(JLabel.CENTER);
		totalHead.setFont(new Font("���", Font.PLAIN, 50));
		totalTime = new JLabel("-");
		totalTime.setHorizontalAlignment(JLabel.CENTER);
		totalTime.setFont(new Font("���", Font.PLAIN, 50));
		
		JLabel lapHead = new JLabel("[�� �ð�]");
		lapHead.setHorizontalAlignment(JLabel.CENTER);
		lapHead.setFont(new Font("���", Font.PLAIN, 50));
		lapTime = new JLabel("-");
		lapTime.setHorizontalAlignment(JLabel.CENTER);
		lapTime.setFont(new Font("���", Font.PLAIN, 50));
		
		jpn.add(totalHead);
		jpn.add(totalTime);
		jpn.add(lapHead);
		jpn.add(lapTime);
		jpnFlow.add(jpn);
		
		ct.add(jpnFlow, BorderLayout.NORTH);
		
		// ���̺� ����
		String[] header = {"��", "�� ����ð�", "�ѽð�"};
		dtm = new DefaultTableModel(header, 0);
		jtb = new JTable(dtm);
		JScrollPane jsp = new JScrollPane(jtb);
		
		ct.add(jsp, BorderLayout.CENTER);
		
		// ��ư
		JPanel btns = new JPanel(new GridLayout(1, 2));
		btnLap = new JButton("��");
		btnLap.addActionListener(this);
		btnLap.setEnabled(false);
		btnStop = new JButton("����");
		btnStop.addActionListener(this);
		btns.add(btnLap);
		btns.add(btnStop);
		ct.add(btns, BorderLayout.SOUTH);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().contentEquals("����")) {
			totalClock.interrupt();
			lapClock.interrupt();
			
			btnStop.setText("����");
			btnLap.setEnabled(false);
			
			totalTime.setText("-");
			lapTime.setText("-");
			totalClock.setTime();
			//totalClock.setTime(0, 0, 0);
		}
		else if(e.getActionCommand().contentEquals("����")) {
			dtm.setRowCount(0);
			btnStop.setText("����");
			btnLap.setEnabled(true);
			totalClock = new TotalClockThread(totalTime);
			lapClock = new LapClockThread(lapTime);
			totalClock.start();
			lapClock.start();
		}
		else {
			String[] timeLog = {String.valueOf(cnt), lapTime.getText(), totalTime.getText()};
			dtm.addRow(timeLog);
			cnt += 1;
			
			lapClock.setTime();
			//lapClock.setTime(0,0,0);
		}
	}
}
