package DragonBallAnimation;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DragonballAnimationFrame extends JFrame implements ActionListener {
	JPanel jp;
	JLabel jlNormal;
	JLabel jlReady;
	JLabel jlShield;
	JLabel jlAttack;
	JLabel jlFa;
	
	JButton btnReady;
	JButton btnShield;
	JButton btnAttack;
	
	public DragonballAnimationFrame() {
		setSize(600, 400);
		setTitle("�巡�ﺼ �� ��� �ִϸ��̼�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container ct = getContentPane();
		ct.setLayout(new BorderLayout());
		
		jp = new JPanel();
		jp.setLayout(null);
		ct.add(jp, BorderLayout.CENTER);
		
		JPanel jpBtns = new JPanel(new GridLayout(1, 3));
		btnReady = new JButton("�� ������");
		btnShield = new JButton("����");
		btnAttack = new JButton("�� ���");
		btnReady.addActionListener(this);
		btnShield.addActionListener(this);
		btnAttack.addActionListener(this);
		jpBtns.add(btnReady);
		jpBtns.add(btnShield);
		jpBtns.add(btnAttack);
		ct.add(jpBtns, BorderLayout.SOUTH);
		
		jlNormal = new JLabel(new ImageIcon("C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_������\\JAVA_edu_������\\src\\DragonBallAnimation\\chNormal.PNG"));
		jlReady = new JLabel(new ImageIcon("C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_������\\JAVA_edu_������\\src\\DragonBallAnimation\\chReady.PNG"));
		jlShield = new JLabel(new ImageIcon("C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_������\\JAVA_edu_������\\src\\DragonBallAnimation\\chShield.PNG"));
		jlAttack = new JLabel(new ImageIcon("C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_������\\JAVA_edu_������\\src\\DragonBallAnimation\\chAttack.PNG"));
		jlFa = new JLabel(new ImageIcon("C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_������\\JAVA_edu_������\\src\\DragonBallAnimation\\Fa.PNG"));
		
		jlNormal.setSize(100, 400);
		jlReady.setSize(300, 400);
		jlShield.setSize(300, 400);
		jlAttack.setSize(100, 400);
		jlFa.setSize(80, 106);
		
		jp.add(jlNormal);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Thread mt;
		
		if(arg0.getActionCommand().contentEquals(btnReady.getText())) {
			mt = new MomentThread(jp, jlNormal, jlReady);
			mt.start();
		}
		else if(arg0.getActionCommand().contentEquals(btnShield.getText())) {
			mt = new MomentThread(jp, jlNormal, jlShield);
			mt.start();
		}
		else if(arg0.getActionCommand().contentEquals(btnAttack.getText())) {
			mt = new MomentThread(jp, jlNormal, jlAttack);
			mt.start();
			new FaThread(jp, jlFa).start();
		}
	}
}

// ������ ���� : 1. label Ŭ�������� setIcon, 2. label ��ü ������ ImageIcon ��ü�� ���ڷ�
