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
		setSize(600, 400); setTitle("달력 변환기 Client"); 
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
		btnSend = new JButton("전송");
		btnSend.addActionListener(this);
		btnReceive = new JButton("수신");
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
		if(e.getActionCommand().contentEquals("전송")) {
			// Socket 객체 생성하여 Server와 연결 후 JTextField의 년, 월을 Server로 전송(년, 월은 yyyy-mm 형태로 전송), 
			// 전송 버튼 비활성화, 수신 버튼 활성화
			client = new ClientThread(jtfSIP.getText(), Integer.parseInt(jtfSPort.getText()), jta);
			client.start();
			client.sendMsg(jtf.getText());
			btnSend.setEnabled(false);
			btnReceive.setEnabled(true);
		}
		if(e.getActionCommand().contentEquals("수신")) {
			// 수신 버튼 클릭 시 Server로부터 반환된 달력을 JTextArea에 출력, Socket 연결 해제, 수신 버튼 비활성화, 전송 버튼 활성화
			
			btnSend.setEnabled(true);
			btnReceive.setEnabled(false);
		}
	}
}
