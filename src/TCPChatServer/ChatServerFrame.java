package TCPChatServer;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatServerFrame extends JFrame implements ActionListener {
	JTextField jtfChat;
	JTextField jtfServPort;
	
	JTextArea jtaChat;
	
	JButton jbGeneration;
	JButton jbSend;
	
	TcpServer ts;
	boolean tsGenerated = false;
	
	public ChatServerFrame() {
		setTitle("TCP 채팅 서버측");
		setSize(300, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container ct = getContentPane();
		ct.setLayout(new BorderLayout());
		
		JPanel jpNorth = new JPanel(new GridLayout(2, 2));
		JPanel jptmp = new JPanel();
		JLabel jlServPort = new JLabel("Server Port");
		jptmp.add(jlServPort);
		jbGeneration = new JButton("생성");
		jbGeneration.addActionListener(this);
		jtfServPort = new JTextField(5);
		jpNorth.add(jptmp);
		jpNorth.add(new JLabel());
		jpNorth.add(jtfServPort);
		jpNorth.add(jbGeneration);
		ct.add(jpNorth, BorderLayout.NORTH);
		
		jtaChat = new JTextArea();
		ct.add(jtaChat, BorderLayout.CENTER);
		
		JPanel jpSouth = new JPanel(new BorderLayout());
		JLabel jlChat = new JLabel("채팅");
		jtfChat = new JTextField(10);
		jbSend = new JButton("보내기");
		jbSend.addActionListener(this);
		jpSouth.add(jlChat, BorderLayout.WEST);
		jpSouth.add(jtfChat, BorderLayout.CENTER);
		jpSouth.add(jbSend, BorderLayout.EAST);
		ct.add(jpSouth, BorderLayout.SOUTH);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().contentEquals(jbGeneration.getText())) {
			// 서버 객체 생성 / 연결 기다림
			ts = new TcpServer(Integer.parseInt(jtfServPort.getText()), jtaChat);
			tsGenerated = true;
			ts.start();
		}
		else {
			// 클라이언트로 메시지 전송
			jtaChat.append("Server : " + jtfChat.getText() + "\n");
			if(tsGenerated) ts.sendMsg("Server : " + jtfChat.getText() + "\n");
			jtfChat.setText("");
		}
	}
}
