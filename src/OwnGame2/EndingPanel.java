package OwnGame2;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EndingPanel extends JPanel implements ActionListener {
	JTextField jtf;
	String userName;
	ScoreBoard db;
	
	public EndingPanel(int ctWidth, int ctHeight, ScoreBoard db) {
		setBounds(0, 0, 500, 500);
		System.out.println(ctWidth + " " + ctHeight);
		//setUndecorated(true);
		setBackground(Color.WHITE);
		setLayout(new FlowLayout());
		
		jtf = new JTextField(10);
		jtf.setBackground(new Color(255, 255, 255, 100));
		add(jtf);
		
		JButton btn = new JButton("Save");
		btn.setBackground(new Color(250, 250, 250, 80));
		btn.addActionListener(this);
		add(btn);
		
		setVisible(true);
		
		this.db = db;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		userName = jtf.getText();
		Bar.userName = userName;
		db.insertBoard(Bar.userName, Bar.score);
		db.dataUpdate();
		notify();
	}
}
