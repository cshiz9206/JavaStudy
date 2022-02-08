package T18_2_01_End_2;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ButtonAction implements ActionListener {
	JButton[] jbtns;
	JTextField jtfInfo;
	JPanel jpnlG;
	Container ct;
	boolean isStarted = false;
	
	public ButtonAction(JButton[] jbtns, JTextField jtfInfo, JPanel jpnlG, Container ct) {
		this.jbtns = jbtns;
		this.jtfInfo = jtfInfo;
		this.jpnlG = jpnlG;
		this.ct = ct;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getActionCommand().contentEquals("시작")) {
			for(JButton btn : jbtns) {
				ImageIcon ii = new ImageIcon("C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_정승현\\JAVA_edu_정승현\\src\\T18_2_01_End_2\\blank.png");
				btn.setIcon(ii);
			}
			jtfInfo.setText("게임 시작");
			
			GridAction ga = new GridAction(jbtns, jtfInfo, jpnlG, ct);
			for(int i = 0; i < jbtns.length; i++) {
				jbtns[i].addActionListener(ga);
			}
		}
	}

}
