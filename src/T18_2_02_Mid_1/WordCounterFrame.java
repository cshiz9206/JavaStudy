package T18_2_02_Mid_1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WordCounterFrame extends JFrame {
	public WordCounterFrame() {
		setTitle("�ܾ��� ���� ����");
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container ct = getContentPane();
		ct.setLayout(new BorderLayout());
		
		JPanel jpnlG1 = new JPanel(new GridLayout(1, 2, 5, 5));
		JTextArea jta = new JTextArea();
		JList jl = new JList(new DefaultListModel());
		jpnlG1.add(jta);
		jpnlG1.add(jl);
		
		JPanel jpnlG2 = new JPanel(new GridLayout(2, 2));
		JTextField jtf = new JTextField();
		JButton btn1 = new JButton("���� �ҷ�����");
		JButton btn2 = new JButton("�ܾ ���� ����");
		JButton btn3 = new JButton("��� ���Ϸ� ��������");
		jpnlG2.add(jtf);
		jpnlG2.add(btn1);
		jpnlG2.add(btn2);
		jpnlG2.add(btn3);
		
		ct.add(jpnlG1, BorderLayout.CENTER);
		ct.add(jpnlG2, BorderLayout.SOUTH);
		
		setVisible(true);
		
		ButtonAction ba = new ButtonAction(jtf, jta, jl);
		btn1.addActionListener(ba);
		btn2.addActionListener(ba);
		btn3.addActionListener(ba);
	}
}
