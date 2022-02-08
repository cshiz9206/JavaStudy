package T19_2_End_1_Client;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CalFrameClient extends JFrame implements ActionListener {
	ClientThread client; JButton btnReceive, btnSend; JTextArea jta;
	JTextField jtf, jtfSIP, jtfSPort;
	
	public CalFrameClient() {
		setSize(600, 400); setTitle("�޷� ��ȯ�� Client"); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container ct = getContentPane();
		ct.setLayout(new BorderLayout());
		
		JPanel jpnlG = new JPanel(new GridLayout(2, 2));
		JLabel jlbSIP = new JLabel("Server IP");
		jlbSIP.setHorizontalAlignment(JLabel.CENTER);
		jpnlG.add(jlbSIP);
		JLabel jlbSPort = new JLabel("Server Port");
		jlbSPort.setHorizontalAlignment(JLabel.CENTER);
		jpnlG.add(jlbSPort);
		jtfSIP = new JTextField();
		jpnlG.add(jtfSIP);
		jtfSPort = new JTextField();
		jpnlG.add(jtfSPort);
		ct.add(jpnlG, BorderLayout.NORTH);
		
		jta = new JTextArea();
		JScrollPane sp = new JScrollPane(jta);
		ct.add(sp, BorderLayout.CENTER);
		
		JPanel jpnlG2 = new JPanel(new GridLayout(1, 3));
		jtf = new JTextField();
		btnSend = new JButton("����");
		btnSend.addActionListener(this);
		btnReceive = new JButton("����");
		btnReceive.addActionListener(this);
		btnReceive.setEnabled(false);
		jpnlG2.add(jtf);
		jpnlG2.add(btnSend);
		jpnlG2.add(btnReceive);
		ct.add(jpnlG2, BorderLayout.SOUTH);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().contentEquals("����")) {
			// Socket ��ü �����Ͽ� Server�� ���� �� JTextField�� ��, ���� Server�� ����(��, ���� yyyy-mm ���·� ����), 
			// ���� ��ư ��Ȱ��ȭ, ���� ��ư Ȱ��ȭ
			client = new ClientThread(jtfSIP.getText(), Integer.parseInt(jtfSPort.getText()), jta);
			client.start();
			client.sendMsg(jtf.getText());
			btnSend.setEnabled(false);
			btnReceive.setEnabled(true);
		}
		if(e.getActionCommand().contentEquals("����")) {
			// ���� ��ư Ŭ�� �� Server�κ��� ��ȯ�� �޷��� JTextArea�� ���, Socket ���� ����, ���� ��ư ��Ȱ��ȭ, ���� ��ư Ȱ��ȭ
			
			btnSend.setEnabled(true);
			btnReceive.setEnabled(false);
		}
	}
}
