package PourWater;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PourWaterFrame extends JFrame implements ActionListener {
	WaterTankEx tank;
	final int MAXW = 10000;
	final int DRAINW = 100;
	int cnt = 0;
	JTextArea jtaLossLog;
	JTextArea jtaAddLog;
	JTextField jtfWater;
	JLabel jlWaterTitle;
	JProgressBar prgbar;
	JButton jdAddHole;
	
	public PourWaterFrame() {
		
		setTitle("�� ���� ���� �� �ױ� - swing");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container ct = getContentPane();
		ct.setLayout(new BorderLayout(10, 10));
		
		// ������ �α׿���
		JPanel jpLossLog = new JPanel(new BorderLayout(5, 5));
		
		JPanel jpLossTitle = new JPanel();
		JLabel jlLossTitle = new JLabel("�� ����");
		jpLossTitle.add(jlLossTitle);
		jpLossLog.add(jpLossTitle, BorderLayout.NORTH);
		
		jtaLossLog = new JTextArea();
		jpLossLog.add(new JScrollPane(jtaLossLog), BorderLayout.CENTER);
		
		jdAddHole = new JButton("���� �߰� (���� 0��)");
		jdAddHole.addActionListener(this);
		jpLossLog.add(jdAddHole, BorderLayout.SOUTH);
		
		// �� ����
		JPanel jpWaterState = new JPanel(new BorderLayout(5, 5));
		
		JPanel jpWaterTitle = new JPanel();
		jlWaterTitle = new JLabel(String.valueOf(MAXW));
		jpWaterTitle.add(jlWaterTitle);
		jpWaterState.add(jpWaterTitle, BorderLayout.NORTH);
		
		prgbar = new JProgressBar(JProgressBar.VERTICAL);
		prgbar.setMaximum(MAXW);
		prgbar.setMinimum(0);
		prgbar.setValue(MAXW);
		jpWaterState.add(prgbar, BorderLayout.CENTER);
		
		jtfWater = new JTextField();
		jpWaterState.add(jtfWater, BorderLayout.SOUTH);
		
		// ������ �α׿���
		JPanel jpAddLog = new JPanel(new BorderLayout(5, 5));
		
		JPanel jpAddTitle = new JPanel();
		JLabel jlAddTitle = new JLabel("�� ����");
		jpAddTitle.add(jlAddTitle);
		jpAddLog.add(jpAddTitle, BorderLayout.NORTH);
		
		jtaAddLog = new JTextArea();
		jpAddLog.add(new JScrollPane(jtaAddLog), BorderLayout.CENTER);
		
		JButton jbPour = new JButton("�� �ױ�");
		jbPour.addActionListener(this);
		jpAddLog.add(jbPour, BorderLayout.SOUTH);
		
		ct.add(jpLossLog, BorderLayout.WEST);
		ct.add(jpWaterState, BorderLayout.CENTER);
		ct.add(jpAddLog, BorderLayout.EAST);
		
		// tank ����
		tank = new WaterTankEx(MAXW, jtaLossLog, prgbar, jlWaterTitle);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		if(arg0.getActionCommand().equals("�� �ױ�")) {
			int pourAmount = Integer.parseInt(jtfWater.getText());
			if(tank.isOver(pourAmount)) tank.pour(tank.getWaterMax()); // �ִ� �뷮���� �� ������ �ִ� �뷮 ��ŭ�� �����
			else tank.pour(pourAmount);
			
			jtaAddLog.setText(jtaAddLog.getText() + "�� ���� : " + pourAmount + "ml\n");
			
			prgbar.setValue(tank.getWater());
			
			jlWaterTitle.setText(String.valueOf(tank.getWater()));
		}
		else {
			cnt += 1;
			WaterHoleThread whte = new WaterHoleThreadEx(cnt, tank, DRAINW);
			jdAddHole.setText("���� �߰� (���� " + cnt + "��)");
			whte.start();
		}
	}
}
