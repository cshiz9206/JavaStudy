package T19_2_End_1_Server;

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

public class CalFrameServer extends JFrame implements ActionListener {
	JTextField jtfCPort;
	JTextArea jta;
	
	public CalFrameServer() {
		setSize(600, 400);
		setTitle("달력 변환기 Server");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container ct = getContentPane();
		ct.setLayout(new BorderLayout());
		
		JPanel jpnlG = new JPanel(new GridLayout(2, 1));
		JPanel jpnlF = new JPanel();
		JLabel jlbCP = new JLabel("Client Port");
		jlbCP.setHorizontalAlignment(JLabel.CENTER);
		jpnlG.add(jlbCP);
		jtfCPort = new JTextField(20);
		jpnlG.add(jtfCPort);
		jpnlF.add(jpnlG);
		ct.add(jpnlF, BorderLayout.NORTH);
		
		jta = new JTextArea();
		JScrollPane sp = new JScrollPane(jta);
		ct.add(sp, BorderLayout.CENTER);
		
		JButton btnConn = new JButton("통신");
		btnConn.addActionListener(this);
		ct.add(btnConn, BorderLayout.SOUTH);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// 달력을 제작하여 Client에게 전송 후 연결 해제
		ServerThread server = new ServerThread(Integer.parseInt(jtfCPort.getText()), jta);
		server.start();
	}
}
