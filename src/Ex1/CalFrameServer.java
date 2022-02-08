package Ex1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalFrameServer extends JFrame implements ActionListener{
	private JTextField jtfClientPort;
	private JTextArea jta;
	private JButton jb;
	Server s;
	public CalFrameServer() {
		Container ct = getContentPane();
		setSize(600, 400);
		ct.setLayout(new BorderLayout());
		JPanel jpNorth=new JPanel();
		jpNorth.setLayout(new BorderLayout());
		JLabel jlClientPort=new JLabel("Client Port",JLabel.CENTER);
		jtfClientPort=new JTextField(20);
		jtfClientPort.setText("9999");
		jpNorth.add(jlClientPort,BorderLayout.NORTH);
		jpNorth.add(jtfClientPort,BorderLayout.CENTER);
		jta=new JTextArea();
		jb=new JButton("���");
		jb.addActionListener(this);
		
		ct.add(jpNorth,BorderLayout.NORTH);
		ct.add(jta,BorderLayout.CENTER);
		ct.add(jb,BorderLayout.SOUTH);
		
		setTitle("�޷� ��ȯ�� Server");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand()=="���") {
			try {
				s=new Server(Integer.parseInt(jtfClientPort.getText()),jta); //���� ��ü ����
			} catch (Exception e) {
				e.printStackTrace();
			} 
			s.start(); //������ ����
		}
	}
}
