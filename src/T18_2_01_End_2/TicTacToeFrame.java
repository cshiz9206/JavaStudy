package T18_2_01_End_2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TicTacToeFrame extends JFrame {
	public TicTacToeFrame() {
		setTitle("Tic Tac Toe");
		setSize(300, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container ct = getContentPane();
		ct.setLayout(new BorderLayout());
		
		JButton jbtnStart = new JButton("����");
		JPanel jpnlG = new JPanel(new GridLayout(3, 3));
		JButton[] jbtns = new JButton[9];
		for(int i = 0; i < jbtns.length; i++) {
			jbtns[i] = new JButton();
			jpnlG.add(jbtns[i]);
		}
		JTextField jtfInfo = new JTextField("'����'��ư�� ���� �����ϼ���!");
		jtfInfo.setEditable(false);
		
		ct.add(jbtnStart, BorderLayout.NORTH);
		ct.add(jpnlG, BorderLayout.CENTER);
		ct.add(jtfInfo, BorderLayout.SOUTH);
		
		// ��ư �׼� ����
		jbtnStart.addActionListener(new ButtonAction(jbtns, jtfInfo, jpnlG, ct));
		
		setVisible(true);
	}
}
