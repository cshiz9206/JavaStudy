package T18_2_01_Mid_2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class BalanceFrame extends JFrame implements ActionListener {
	JButton jbtnLeftR, jbtnCenterL, jbtnCenterR, jbtnRightL, jbtnBal;
	JList[] lists;
	DefaultListModel[] dlms;
	JTextArea jtaLog;
	int[] weights;
	
	public BalanceFrame() {
		weights = new int[8];
		for(int i = 0; i < weights.length; i++) weights[i] = 1;
		Random rd = new Random();
		int rdn = rd.nextInt(8);
		weights[rdn] = 10;
		
		setTitle("천칭 저울");
		setSize(400, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container ct = getContentPane();
		ct.setLayout(new GridLayout(2, 1, 10, 10));
		
		JPanel jpnlB1 = new JPanel(new BorderLayout(10, 10));
		JPanel jpnlG1 = new JPanel(new GridLayout(1, 3, 5, 5));
		lists = new JList[3];
		dlms = new DefaultListModel[3];
		for(int i = 0; i < lists.length; i++) {
			lists[i] = new JList(new DefaultListModel());
			dlms[i] = (DefaultListModel)lists[i].getModel();
			jpnlG1.add(lists[i]);
		}
		for(int i = 1; i < 9; i++) dlms[1].addElement(i);
		
		JPanel jpnlG2 = new JPanel(new GridLayout(1, 4, 5, 5));
		JPanel jpnlF = new JPanel(new FlowLayout());
		jbtnLeftR = new JButton("▶");
		jbtnCenterL = new JButton("◀");
		jbtnCenterR = new JButton("▶");
		jbtnRightL = new JButton("◀");
		jbtnLeftR.addActionListener(this);
		jbtnCenterL.addActionListener(this);
		jbtnCenterR.addActionListener(this);
		jbtnRightL.addActionListener(this);
		jpnlG2.add(jbtnLeftR);
		jpnlG2.add(jbtnCenterL);
		jpnlG2.add(jbtnCenterR);
		jpnlG2.add(jbtnRightL);
		jpnlF.add(jpnlG2);
		
		jpnlB1.add(jpnlG1, BorderLayout.CENTER);
		jpnlB1.add(jpnlF, BorderLayout.SOUTH);
		ct.add(jpnlB1);
		
		JPanel jpnlB2 = new JPanel(new BorderLayout(10, 10));
		jbtnBal = new JButton("양쪽 무게 비교하기");
		jbtnBal.addActionListener(this);
		jpnlB2.add(jbtnBal, BorderLayout.NORTH);
		jtaLog = new JTextArea();
		jpnlB2.add(jtaLog, BorderLayout.CENTER);
		ct.add(jpnlB2);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(jbtnLeftR.getModel().isRollover()) {
			dlms[1].addElement(lists[0].getSelectedValue());
			dlms[0].removeElement(lists[0].getSelectedValue());
		}
		else if(jbtnCenterL.getModel().isRollover()) {
			dlms[0].addElement(lists[1].getSelectedValue());
			dlms[1].removeElement(lists[1].getSelectedValue());
		}
		else if(jbtnCenterR.getModel().isRollover()) {
			dlms[2].addElement(lists[1].getSelectedValue());
			dlms[1].removeElement(lists[1].getSelectedValue());
		}
		else if(jbtnRightL.getModel().isRollover()) {
			dlms[1].addElement(lists[2].getSelectedValue());
			dlms[2].removeElement(lists[2].getSelectedValue());
		}
		else if(jbtnBal.getModel().isRollover()) {
			String log = "";
			for(int i = 0; i < dlms[0].getSize(); i++) {
				if(i == 0) log += dlms[0].get(i);
				else log += ", " + dlms[0].get(i);
			}
			log += " / ";
			for(int i = 0; i < dlms[2].getSize(); i++) {
				if(i == 0) log += dlms[2].get(i);
				else log += ", " + dlms[2].get(i);
			}
			int result = balance();
			if(result == 0) log += " -> 왼쪽이 무겁습니다.\n";
			else if(result == 2) log += " -> 오른쪽이 무겁습니다.\n";
			else log += " -> 동일합니다.\n";
			
			if((dlms[0].getSize() == 1) && (dlms[2].getSize() == 1)) {
				log += "정답은 " + dlms[result].get(0) + "번 입니다!";
			}
			
			jtaLog.append(log);
		}
	}
	
	public int balance() {
		int leftSum = 0;
		for(int i = 0; i < dlms[0].getSize(); i++) leftSum += weights[(int) dlms[0].get(i) - 1];
		
		int rightSum = 0;
		for(int i = 0; i < dlms[2].getSize(); i++) rightSum += weights[(int) dlms[2].get(i) - 1];
		
		if(leftSum > rightSum) return 0;
		else if(leftSum < rightSum) return 2;
		else return 1;
	}
}
