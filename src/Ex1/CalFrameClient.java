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
		jbSend = new JButton("전송");
		jbSend.addActionListener(this);
		jbReceive = new JButton("수신");
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

		setTitle("달력 변환기 Client");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getActionCommand() == "전송") {
			try {
				String serverIP = jtfServerIP.getText();
				int port = Integer.parseInt(jtfServerPort.getText());
				c = new Client(serverIP, port, jta, jbSend, jbReceive); //클라이언트 객체 생성
				c.sendYearMonth(jtfInput.getText()); //연,월을 서버에게 전송
			} catch (Exception e) {
				e.printStackTrace();
			}
			jbSend.setEnabled(false);
			jbReceive.setEnabled(true);
		} else {
			c.start(); //수신 시작
			jbSend.setEnabled(true);
			jbReceive.setEnabled(false);
		}
	}
}
