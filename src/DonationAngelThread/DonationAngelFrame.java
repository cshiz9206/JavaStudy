package DonationAngelThread;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class DonationAngelFrame extends JFrame implements ActionListener {
	DonationCenter dc;
	DefaultListModel dlmReceiptLog;
	DefaultListModel dlmDonateLog;
	JLabel jlb;
	Container ct;
	JPanel jpLog;
	Donator dnr;
	Recipient rcp;
	JScrollPane jsp2;
	JButton jbStart;
	
	public DonationAngelFrame() {
		setTitle("���õ�� - v2.0");
		setSize(450, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ct = getContentPane();
		ct.setLayout(new BorderLayout(10, 10));
		
		jlb = new JLabel("Start ��ư�� ���� ���õ�簡 �Ǿ����!");
		ct.add(jlb, BorderLayout.NORTH);
		
		JList jlReceiptLog = new JList(new DefaultListModel());
		dlmReceiptLog = (DefaultListModel) jlReceiptLog.getModel();
		JScrollPane jsp1 = new JScrollPane(jlReceiptLog);
		
		JList jlDonateLog = new JList(new DefaultListModel());
		dlmDonateLog = (DefaultListModel) jlDonateLog.getModel();
		jsp2 = new JScrollPane(jlDonateLog);
		
		jpLog = new JPanel(new GridLayout(1, 2, 10, 10));
		jpLog.add(jsp2);
		jpLog.add(jsp1);
		ct.add(jpLog, BorderLayout.CENTER);
		
		jbStart = new JButton("start");
		jbStart.addActionListener(this);
		ct.add(jbStart, BorderLayout.SOUTH);
		
		dc = new DonationCenter();
		dc.setGoal(900000);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		jbStart.setEnabled(false);
		
		dnr = new Donator(dc, dlmDonateLog, jlb);
		rcp = new Recipient(dc, dlmReceiptLog);
		
		dnr.start();
		rcp.start();
	}
}
