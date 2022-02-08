package Ex1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalFrameClient extends JFrame implements ActionListener {
	private JTextField jtfServerIP;
	private JTextField jtfServerPort;
	private JTextArea jta;
	private JTextField jtfInput;
	private JButton jbSend;
	private JButton jbReceive;
	Client c;

	public CalFrameClient() {
		Container ct = getContentPane();
		setSize(600, 400);
		ct.setLayout(new BorderLayout());

		JPanel jpNorth = new JPanel();
		jpNorth.setLayout(new GridLayout(2, 2));
		JLabel jlServerIP = new JLabel("Server IP", JLabel.CENTER);
		JLabel jlServerPort = new JLabel("Server Port", JLabel.CENTER);
		jtfServerIP = new JTextField(20);
		jtfServerIP.setText("127.0.0.1");
		jtfServerPort = new JTextField(20);
		jtfServerPort.setText("9999");
		jpNorth.add(jlServerIP);
		jpNorth.add(jlServerPort);
		jpNorth.add(jtfServerIP);
		jpNorth.add(jtfServerPort);

		JPanel jpSouth = new JPanel();
		jpSouth.setLayout(new GridLayout(1, 3));
		jtfInput = new JTextField(20);
		jbSend = new JButton("����");
		jbSend.addActionListener(this);
		jbReceive = new JButton("����");
		jbReceive.setEnabled(false);
		jbReceive.addActionListener(this);
		jpSouth.add(jtfInput);
		jpSouth.add(jbSend);
		jpSouth.add(jbReceive);

		jta = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta);

		ct.add(jpNorth, BorderLayout.NORTH);
		ct.add(jsp, BorderLayout.CENTER);
		ct.add(jpSouth, BorderLayout.SOUTH);

		setTitle("�޷� ��ȯ�� Client");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getActionCommand() == "����") {
			try {
				String serverIP = jtfServerIP.getText();
				int port = Integer.parseInt(jtfServerPort.getText());
				c = new Client(serverIP, port, jta, jbSend, jbReceive); //Ŭ���̾�Ʈ ��ü ����
				c.sendYearMonth(jtfInput.getText()); //��,���� �������� ����
			} catch (Exception e) {
				e.printStackTrace();
			}
			jbSend.setEnabled(false);
			jbReceive.setEnabled(true);
		} else {
			c.start(); //���� ����
			jbSend.setEnabled(true);
			jbReceive.setEnabled(false);
		}
	}
}
