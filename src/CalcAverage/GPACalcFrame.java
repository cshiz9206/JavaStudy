package CalcAverage;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GPACalcFrame extends JFrame implements ActionListener {
	JTextField tfSubj;
	JTextField tfCredit;
	JTextField tfGrade;
	JTextArea ta;
	
	float sum = 0;
	int sumCredit = 0;
	JLabel avg;
	
	public GPACalcFrame(String title, int w, int h) {
		setTitle(title);
		setSize(w, h);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container ct = getContentPane();
		ct.setLayout(new BorderLayout());
		
		ta = new JTextArea(14, 0);
		ta.setEditable(false);
		ct.add(ta, BorderLayout.NORTH);
		
		JPanel pnl1 = new JPanel();
		pnl1.setLayout(new GridLayout(3, 4, 5, 5));
		pnl1.add(new JLabel("과목명"));
		pnl1.add(new JLabel("학점"));
		pnl1.add(new JLabel("평점"));
		
		pnl1.add(new JLabel(""));
		
		tfSubj = new JTextField();
		tfCredit = new JTextField();
		tfGrade = new JTextField();
		pnl1.add(tfSubj);
		pnl1.add(tfCredit);
		pnl1.add(tfGrade);
		
		JButton btn = new JButton("추가");
		btn.addActionListener(this);
		pnl1.add(btn);
		
		pnl1.add(new JLabel(""));
		pnl1.add(new JLabel(""));
		
		pnl1.add(new JLabel("평점평균"));
		
		avg = new JLabel();
		avg.setHorizontalAlignment(JLabel.CENTER);
		pnl1.add(avg);
		
		ct.add(pnl1);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// 라인 출력
		String subj = tfSubj.getText();
		String credit = tfCredit.getText();
		String grade = tfGrade.getText();
		
		ta.append(subj + " " + credit + " " + grade + "\n");
		sumCredit += Float.parseFloat(credit);
		
		// 평균 계산 및 출력
		sum += Float.parseFloat(grade) * Float.parseFloat(credit);
		avg.setText(String.valueOf(sum / sumCredit));
	}
}
