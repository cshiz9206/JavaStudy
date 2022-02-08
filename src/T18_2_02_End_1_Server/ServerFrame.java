package T18_2_02_End_1_Server;

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

public class ServerFrame extends JFrame implements ActionListener {
	JTextField jtfSPort, jtfCIP, jtfCPort;
	JTextArea jta;
	
	public ServerFrame() {
		setTitle("김범수 콘서트 예약 시스템 서버");
		setSize(400, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container ct = getContentPane();
		ct.setLayout(new BorderLayout());
		
		JPanel jpnlG = new JPanel(new GridLayout(2, 4));
		jpnlG.add(new JLabel("Server Port"));
		jpnlG.add(new JLabel("Client IP"));
		jpnlG.add(new JLabel("Client Port"));
		jpnlG.add(new JLabel(""));
		jtfSPort = new JTextField();
		jtfCIP = new JTextField();
		jtfCPort = new JTextField();
		jpnlG.add(jtfSPort);
		jpnlG.add(jtfCIP);
		jpnlG.add(jtfCPort);
		JButton btn = new JButton("설정");
		btn.addActionListener(this);
		jpnlG.add(btn);
		ct.add(jpnlG, BorderLayout.NORTH);
		
		jta = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta);
		ct.add(jsp, BorderLayout.CENTER);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new ServerThread(jta, jtfSPort, jtfCIP, jtfCPort).start();
	}
}
