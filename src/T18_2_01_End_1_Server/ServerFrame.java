package T18_2_01_End_1_Server;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ServerFrame extends JFrame {
	public ServerFrame() {
		setTitle("김범수 콘서트 예약 시스템 서버");
		setSize(350, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container ct = getContentPane();
		ct.setLayout(new BorderLayout());
		
		JPanel jpnlG = new JPanel(new GridLayout(2, 4));
		jpnlG.add(new JLabel("Server Port"));
		jpnlG.add(new JLabel("Client IP"));
		jpnlG.add(new JLabel("Client Port"));
		jpnlG.add(new JLabel(""));
		JTextField jtfServerPort = new JTextField();
		JTextField jtfClientIP = new JTextField();
		JTextField jtfClientPort = new JTextField();
		jpnlG.add(jtfServerPort);
		jpnlG.add(jtfClientIP);
		jpnlG.add(jtfClientPort);
		JButton btnSet = new JButton("설정");
		jpnlG.add(btnSet);
		
		ct.add(jpnlG, BorderLayout.NORTH);
		
		JTextArea ticketSoldLog = new JTextArea();
		JScrollPane sp = new JScrollPane(ticketSoldLog);
		
		ct.add(sp, BorderLayout.CENTER);
		
		JTextField[] UdpInf = {jtfServerPort, jtfClientIP, jtfClientPort};
		ButtonAction buttonAction = new ButtonAction(UdpInf, ticketSoldLog);
		btnSet.addActionListener(buttonAction);
		
		setVisible(true);
	}
}
