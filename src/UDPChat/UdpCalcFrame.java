package UDPChat;

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

import TCPChatClient.TcpClient;

public class UdpCalcFrame extends JFrame implements ActionListener {
	JTextField jtfChat, jtfMyP, jtfYourP, jtfYourIP;
	JTextArea jtaChat;
	JButton jbSetting, jbSend;
	UdpComm uc;
	
	public UdpCalcFrame() {
		setTitle("UDP 채팅");
		setSize(300, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container ct = getContentPane();
		ct.setLayout(new BorderLayout());
		
		JPanel jpNorth = new JPanel(new GridLayout(2, 4));
		JPanel jptmp = new JPanel();
		JLabel jlMyP = new JLabel("My Port");
		jptmp.add(jlMyP);
		JPanel jptmp2 = new JPanel();
		JLabel jlYourP = new JLabel("Your Port");
		jptmp2.add(jlYourP);
		JPanel jptmp3 = new JPanel();
		JLabel jlYourIP = new JLabel("Your IP");
		jptmp3.add(jlYourIP);
		
		jbSetting = new JButton("설정");
		jbSetting.addActionListener(this);
		jtfMyP = new JTextField(5);
		jtfYourP = new JTextField(5);
		jtfYourIP = new JTextField(5);
		jpNorth.add(jptmp);
		jpNorth.add(jptmp2);
		jpNorth.add(jptmp3);
		jpNorth.add(new JLabel());
		jpNorth.add(jtfMyP);
		jpNorth.add(jtfYourP);
		jpNorth.add(jtfYourIP);
		jpNorth.add(jbSetting);
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
		if(e.getActionCommand().contentEquals(jbSetting.getText())) {
			uc = new UdpComm(jtaChat, jtfYourIP.getText(), jtfYourP.getText(), jtfMyP.getText());
			uc.start();
		}
		else {
			jtaChat.append("나 : " + jtfChat.getText() + "\n");
			uc.sendMsg(jtfChat.getText());
			jtfChat.setText("");
		}
	}
}