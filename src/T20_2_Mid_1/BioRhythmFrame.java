package T20_2_Mid_1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class BioRhythmFrame extends JFrame implements ActionListener {
	JTextField jtfBirth, jtfStart, jtfEnd;
	JButton btnSet, btnLoad;
	JTable tb;
	DefaultTableModel dtm;
	FileIO io;
	
	public BioRhythmFrame() {
		setTitle("���̿� ����");
		setSize(500, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container ct = getContentPane();
		ct.setLayout(new BorderLayout());
		
		JPanel jpnlG0 = new JPanel(new GridLayout(2, 1));
		JPanel jpnlG = new JPanel(new GridLayout(3, 2));
		JLabel jlbBirth = new JLabel("�������(yyyy-mm-dd)");
		jlbBirth.setHorizontalAlignment(JLabel.CENTER);
		JLabel jlbStart = new JLabel("��� ���� ����(yyyy-mm-dd)");
		jlbStart.setHorizontalAlignment(JLabel.CENTER);
		JLabel jlbEnd = new JLabel("��� �� ����(yyyy-mm-dd)");
		jlbEnd.setHorizontalAlignment(JLabel.CENTER);
		jtfBirth = new JTextField();
		jtfStart = new JTextField();
		jtfEnd = new JTextField();
		jpnlG.add(jlbBirth);
		jpnlG.add(jtfBirth);
		jpnlG.add(jlbStart);
		jpnlG.add(jtfStart);
		jpnlG.add(jlbEnd);
		jpnlG.add(jtfEnd);
		jpnlG0.add(jpnlG);
		
		String[] columns = {"��¥", "��ü����", "��������", "��������", "��������"};
		dtm = new DefaultTableModel(columns, 0);
		tb = new JTable(dtm);
		JScrollPane sp = new JScrollPane(tb);
		jpnlG0.add(sp);
		
		ct.add(jpnlG0, BorderLayout.CENTER);
		
		JPanel jpnlG2 = new JPanel(new GridLayout(1, 2));
		btnSet = new JButton("���̿����� �ʱⰪ ����");
		btnSet.addActionListener(this);
		btnLoad = new JButton("���̺� �ε��ϱ�");
		btnLoad.setEnabled(false);
		btnLoad.addActionListener(this);
		jpnlG2.add(btnSet);
		jpnlG2.add(btnLoad);
		ct.add(jpnlG2, BorderLayout.SOUTH);
		
		setVisible(true);
		
		io = new FileIO();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().contentEquals("���̿����� �ʱⰪ ����")) {
			btnLoad.setEnabled(true);
			btnSet.setEnabled(false);
			
			String[] startStr = jtfStart.getText().split("-");
			String[] endStr = jtfEnd.getText().split("-");
			
			LocalDate start, end;
			start = LocalDate.of(Integer.parseInt(startStr[0]), Integer.parseInt(startStr[1]), Integer.parseInt(startStr[2]));
			end = LocalDate.of(Integer.parseInt(endStr[0]), Integer.parseInt(endStr[1]), Integer.parseInt(endStr[2]));
			long time = ChronoUnit.DAYS.between(start, end);
			
			startStr = jtfBirth.getText().split("-");
			endStr = jtfStart.getText().split("-");
			start = LocalDate.of(Integer.parseInt(startStr[0]), Integer.parseInt(startStr[1]), Integer.parseInt(startStr[2]));
			end = LocalDate.of(Integer.parseInt(endStr[0]), Integer.parseInt(endStr[1]), Integer.parseInt(endStr[2]));
			for(int i = 0; i <= time; i++) {
				LocalDate endTmp = end.plusDays(i);
				long t = ChronoUnit.DAYS.between(start, endTmp);
				
				double body = Math.sin(2 * Math.PI * t / 23) * 100;
				double sens = Math.sin(2 * Math.PI * t / 28) * 100;
				double intel = Math.sin(2 * Math.PI * t / 33) * 100;
				double percept = Math.sin(2 * Math.PI * t / 38) * 100;
				
				io.write(endTmp, body, sens, intel, percept);
			}
		}
		if(e.getActionCommand().contentEquals("���̺� �ε��ϱ�")) {
			btnLoad.setEnabled(false);
			String context = io.read();
			String[] row = context.split("\n");
			for(int i = 0; i < row.length; i++) {
				dtm.addRow(row[i].split(","));
			}
		}
	}
}
