package DragonBall;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class DragonBallFrame extends JFrame implements ActionListener {
	JRadioButton rbEnergy;
	JRadioButton rbShield;
	JRadioButton rbAttack;
	
	JLabel actionComp;
	JLabel actionUser;
	JLabel lifeCompLb;
	JLabel lifeUserLb;
	
	JTextArea ta;
	
	int compEnergyCnt = 0;
	int compLifeCnt = 3;
	int userEnergyCnt = 0;
	int userLifeCnt = 3;
	
	public DragonBallFrame(String title, int w, int h) {
		setTitle(title);
		setSize(w, h);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container ct = getContentPane();
		ct.setLayout(new BorderLayout(0, 10));

		// 상단 시작
		JPanel pnlState = new JPanel();
		pnlState.setLayout(new GridLayout(1, 2));
		
		// 좌(computer) : BorderLayout에 위치시키고, GridLayout에 추가
		JPanel comp = new JPanel();
		comp.setLayout(new BorderLayout());
		
		JLabel jlbComp = new JLabel("Computer");
		jlbComp.setHorizontalAlignment(JLabel.CENTER);
		actionComp = new JLabel("--");
		actionComp.setFont(new Font("궁서", Font.BOLD, 50));
		actionComp.setHorizontalAlignment(JLabel.CENTER);
		lifeCompLb = new JLabel("♥♥♥");
		lifeCompLb.setFont(new Font("궁서", Font.BOLD, 20));
		lifeCompLb.setHorizontalAlignment(JLabel.CENTER);
		comp.add(jlbComp, BorderLayout.NORTH);
		comp.add(actionComp, BorderLayout.CENTER);
		comp.add(lifeCompLb, BorderLayout.SOUTH);
		pnlState.add(comp);
		
		// 우(user) : BorderLayout에 위치시키고, GridLayout에 추가
		JPanel user = new JPanel();
		user.setLayout(new BorderLayout());
		
		JLabel jlbUser = new JLabel("User");
		jlbUser.setHorizontalAlignment(JLabel.CENTER);
		actionUser = new JLabel("--");
		actionUser.setFont(new Font("궁서", Font.BOLD, 50));
		actionUser.setHorizontalAlignment(JLabel.CENTER);
		lifeUserLb = new JLabel("♥♥♥");
		lifeUserLb.setFont(new Font("궁서", Font.BOLD, 20));
		lifeUserLb.setHorizontalAlignment(JLabel.CENTER);
		user.add(jlbUser, BorderLayout.NORTH);
		user.add(actionUser, BorderLayout.CENTER);
		user.add(lifeUserLb, BorderLayout.SOUTH);
		pnlState.add(user);
		ct.add(pnlState, BorderLayout.NORTH);

		// 하단 시작
		JPanel pnlBottom = new JPanel(new BorderLayout(0, 10));
		JPanel pnlAction = new JPanel();
		pnlAction.setLayout(new GridLayout(1, 4, 20, 20));
		rbEnergy = new JRadioButton("기");
		rbShield = new JRadioButton("막기");
		rbAttack = new JRadioButton("파");
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbEnergy);
		bg.add(rbShield);
		bg.add(rbAttack);
		pnlAction.add(rbEnergy);
		pnlAction.add(rbShield);
		pnlAction.add(rbAttack);
		
		JButton btn = new JButton("Go!");
		btn.addActionListener(this);
		pnlAction.add(btn);
		pnlBottom.add(pnlAction, BorderLayout.NORTH);
		
		ta = new JTextArea();
		ta.setEditable(false);
		pnlBottom.add(ta, BorderLayout.CENTER);
		ct.add(pnlBottom, BorderLayout.CENTER);
		
		setVisible(true);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Random rd = new Random();
		int rdn = rd.nextInt(3); // 0 : 기, 1 : 막기, 2 : 파
		
		if(rbEnergy.isSelected() && rdn == 0) {
			actionUser.setText(rbEnergy.getText());
			actionComp.setText(rbEnergy.getText());
			compEnergyCnt += 1;
			userEnergyCnt += 1;
		}
		if(rbEnergy.isSelected() && rdn == 1) {
			actionUser.setText(rbEnergy.getText());
			actionComp.setText(rbShield.getText());
			userEnergyCnt += 1;
		}
		if(rbEnergy.isSelected() && rdn == 2) {
			actionUser.setText(rbEnergy.getText());
			actionComp.setText(rbAttack.getText());
			if(compEnergyCnt > 0) { // 공격자의 기가 모여있을 때만
				userLifeCnt -= 1;
				compEnergyCnt -= 1;
			}
			userEnergyCnt += 1;
		}
		
		if(rbShield.isSelected() && rdn == 0) {
			actionUser.setText(rbShield.getText());
			actionComp.setText(rbEnergy.getText());
			compEnergyCnt += 1;
		}
		if(rbShield.isSelected() && rdn == 1) {
			actionUser.setText(rbShield.getText());
			actionComp.setText(rbShield.getText());
		}
		if(rbShield.isSelected() && rdn == 2) {
			actionUser.setText(rbShield.getText());
			actionComp.setText(rbAttack.getText());
			if(compEnergyCnt > 0) {
				compEnergyCnt -= 1;
			}
		}
		
		if(rbAttack.isSelected() && rdn == 0) {
			actionUser.setText(rbAttack.getText());
			actionComp.setText(rbEnergy.getText());
			if(userEnergyCnt > 0) {
				compLifeCnt -= 1;
				userEnergyCnt -= 1;
			}
			compEnergyCnt += 1;
		}
		if(rbAttack.isSelected() && rdn == 1) {
			actionUser.setText(rbAttack.getText());
			actionComp.setText(rbShield.getText());
			if(userEnergyCnt > 0) {
				userEnergyCnt -= 1;
			}
		}
		if(rbAttack.isSelected() && rdn == 2) {
			actionUser.setText(rbAttack.getText());
			actionComp.setText(rbAttack.getText());
			if((compEnergyCnt > 0) && (userEnergyCnt > 0)) {
				userLifeCnt -= 1;
				userEnergyCnt -= 1;
				compLifeCnt -= 1;
				compEnergyCnt -= 1;
			}
			else if((compEnergyCnt <= 0) && (userEnergyCnt > 0)) {
				userEnergyCnt -= 1;
				compLifeCnt -= 1;
			}
			else if((compEnergyCnt > 0) && (userEnergyCnt <= 0)) {
				compEnergyCnt -= 1;
				userLifeCnt -= 1;
			}
		}
		
		setLife(lifeUserLb, userLifeCnt);
		setLife(lifeCompLb, compLifeCnt);
		ta.append("Computer> action: " + actionComp.getText() + ", life: " + compLifeCnt + "\t" + 
		"User> action: " + actionUser.getText() + ", life:" + userLifeCnt + "\n");
	}
	
	public void setLife(JLabel lifeLb, int lifeCnt) {
		String tmpLife = "";
		for(int i = 0; i < 3; i++) {
			if(lifeCnt - i > 0) tmpLife += "♥";
			else tmpLife += "♡";
		}
		
		lifeLb.setText(tmpLife);
	}
}
