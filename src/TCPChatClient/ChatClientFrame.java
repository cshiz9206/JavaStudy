package TCPChatClient;

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

public class ChatClientFrame extends JFrame implements ActionListener {
	JTextField jtfChat;
	JTextField jtfServIP;
	JTextField jtfServPort;
	JTextArea jtaChat;
	JButton jbContect;
	JButton jbSend;
	TcpClient tc;
	
	boolean tcGenerated = false;
	
	public ChatClientFrame() {
		setTitle("TCP 채팅 클라이언트측");
		setSize(300, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container ct = getContentPane();
		ct.setLayout(new BorderLayout());
		
		JPanel jpNorth = new JPanel(new GridLayout(2, 3));
		JPanel jptmp = new JPanel();
		JLabel jlServIP = new JLabel("Server IP");
		jptmp.add(jlServIP);
		JPanel jptmp2 = new JPanel();
		JLabel jlServPort = new JLabel("Server Port");
		jptmp2.add(jlServPort);
		jbContect = new JButton("접속");
		jbContect.addActionListener(this);
		jtfServIP = new JTextField(5);
		jtfServPort = new JTextField(5);
		jpNorth.add(jptmp);
		jpNorth.add(jptmp2);
		jpNorth.add(new JLabel());
		jpNorth.add(jtfServIP);
		jpNorth.add(jtfServPort);
		jpNorth.add(jbContect);
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
		if(e.getActionCommand().contentEquals(jbContect.getText())) {
			// 읽는 thread 시작
			tc = new TcpClient(jtaChat, jtfServIP, jtfServPort);
			tcGenerated = true;
			tc.start();
		}
		else {
			// sendMsg
			if(jtfChat.getText() != null) {
				jtaChat.append("나 : " + jtfChat.getText() + "\n");
				if(tcGenerated) tc.sendMsg("Client : " + jtfChat.getText() + "\n");
			}
			jtfChat.setText("");
		}
	}
}
