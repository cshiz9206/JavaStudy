package T18_2_01_End_1_Client;

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

public class ReservProgFrame extends JFrame {
	public ReservProgFrame() {
		setTitle("김범수 콘서트 예약 프로그램");
		setSize(350, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container ct = getContentPane();
		ct.setLayout(new BorderLayout());
		
		JPanel jpnlG = new JPanel(new GridLayout(2, 4));
		jpnlG.add(new JLabel("Client Port"));
		jpnlG.add(new JLabel("Server IP"));
		jpnlG.add(new JLabel("Server Port"));
		jpnlG.add(new JLabel(""));
		JTextField jtfClientPort = new JTextField();
		JTextField jtfServerIP = new JTextField();
		JTextField jtfServerPort = new JTextField();
		jpnlG.add(jtfClientPort);
		jpnlG.add(jtfServerIP);
		jpnlG.add(jtfServerPort);
		JButton btnSet = new JButton("설정");
		jpnlG.add(btnSet);
		
		ct.add(jpnlG, BorderLayout.NORTH);
		
		JTextArea ticketSoldLog = new JTextArea();
		JScrollPane sp = new JScrollPane(ticketSoldLog);
		
		ct.add(sp, BorderLayout.CENTER);
		
		JButton btnStart = new JButton("구매 시작");
		ct.add(btnStart, BorderLayout.SOUTH);
		
		JTextField[] UdpInf = {jtfClientPort, jtfServerIP, jtfServerPort};
		ButtonAction buttonAction = new ButtonAction(UdpInf, ticketSoldLog);
		//ButtonAction2 buttonAction = new ButtonAction2(UdpInf, ticketSoldLog);
		btnSet.addActionListener(buttonAction);
		btnStart.addActionListener(buttonAction);
		
		setVisible(true);
	}
}
