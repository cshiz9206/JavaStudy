package T18_2_01_Mid_1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RecordManageFrame extends JFrame{
	DefaultListModel dlm;
	JTextField jtfId, jtfKo, jtfMa, jtfEng;
	JLabel jlbResult;
	
	public RecordManageFrame() {
		setSize(400, 300);
		setTitle("성적 처리 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container ct = getContentPane();
		ct.setLayout(new BorderLayout());
		
		JPanel jpnl1 = new JPanel(new BorderLayout());
		JPanel jpnl2 = new JPanel(new GridLayout(2, 5));
		JLabel jlbSub1 = new JLabel("학번");
		jlbSub1.setHorizontalAlignment(JLabel.CENTER);
		jpnl2.add(jlbSub1);
		JLabel jlbSub2 = new JLabel("국어");
		jlbSub2.setHorizontalAlignment(JLabel.CENTER);
		jpnl2.add(jlbSub2);
		JLabel jlbSub3 = new JLabel("수학");
		jlbSub3.setHorizontalAlignment(JLabel.CENTER);
		jpnl2.add(jlbSub3);
		JLabel jlbSub4 = new JLabel("영어");
		jlbSub4.setHorizontalAlignment(JLabel.CENTER);
		jpnl2.add(jlbSub4);
		jpnl2.add(new JLabel(""));
		jtfId = new JTextField();
		jtfKo = new JTextField();
		jtfMa = new JTextField();
		jtfEng = new JTextField();
		JButton jbtn = new JButton("추가");
		
		jpnl2.add(jtfId);
		jpnl2.add(jtfKo);
		jpnl2.add(jtfMa);
		jpnl2.add(jtfEng);
		jpnl2.add(jbtn);
		jpnl1.add(jpnl2, BorderLayout.CENTER);
		
		JPanel jpnl3 = new JPanel(new GridLayout(1, 2));
		JButton jbtnCalc = new JButton("평균 계산");
		JButton jbtnSave = new JButton("파일로 저장");
		jpnl3.add(jbtnCalc);
		jpnl3.add(jbtnSave);
		jpnl1.add(jpnl3, BorderLayout.SOUTH);
		
		ct.add(jpnl1, BorderLayout.NORTH);
		
		JList jl = new JList(new DefaultListModel());
		dlm = (DefaultListModel)jl.getModel();
		ct.add(jl, BorderLayout.CENTER);
		
		jlbResult = new JLabel();
		ct.add(jlbResult, BorderLayout.SOUTH);
		
		ButtonAction ba = new ButtonAction(dlm, jtfId, jtfKo, jtfMa, jtfEng, jlbResult);
		jbtn.addActionListener(ba);
		jbtnCalc.addActionListener(ba);
		jbtnSave.addActionListener(ba);
		
		setVisible(true);
	}
}
