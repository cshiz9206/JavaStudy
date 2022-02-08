package SwingCalc;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CalcFrame extends JFrame {
	protected JButton[] btns;
	protected JTextField inTf;
	protected JTextArea ta;
	
	public CalcFrame(String title, int w, int h) {
		setTitle(title);
		setSize(w, h);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container ct = getContentPane();
		ct.setLayout(new BorderLayout(0, 5));
		
		// 상단
		ta = new JTextArea(12, 0);
		ta.setEditable(false);
		ct.add(ta, BorderLayout.CENTER);
		//
		
		// 하단
		JPanel jplO = new JPanel();
		jplO.setLayout(new BorderLayout(0, 10));
		
		inTf = new JTextField();
		jplO.add(inTf, BorderLayout.NORTH);
		
		JPanel jpBtns = new JPanel();
		jpBtns.setLayout(new GridLayout(4, 4, 5, 5));
		String[] calcElements = {"=", "←", "÷", "×", "7", "8", "9", "－", "4", "5", "6", "+", "1", "2", "3", "0"};
		btns = new JButton[16];
		for(int i = 0; i < calcElements.length; i++) {
			btns[i] = new JButton(calcElements[i]);
			jpBtns.add(btns[i]);
		}
		jplO.add(jpBtns, BorderLayout.CENTER);
		
		ct.add(jplO, BorderLayout.SOUTH);
		//

		setVisible(true);
	}
}
