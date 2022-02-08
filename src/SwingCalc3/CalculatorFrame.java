package SwingCalc3;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class CalculatorFrame extends JFrame implements ActionListener {
	protected JButton[] btns;
	protected JTextField inTf;
	protected JList jl;
	protected DefaultListModel dlm;
	
	public CalculatorFrame(String title, int w, int h) {
		setTitle(title);
		setSize(w, h);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container ct = getContentPane();
		ct.setLayout(new BorderLayout());
		
		// 상단(표시영역)
		JPanel jplO = new JPanel();
		jplO.setLayout(new BorderLayout());
		
		jl = new JList(new DefaultListModel());
		dlm = (DefaultListModel)jl.getModel();
		jplO.add(new JScrollPane(jl), BorderLayout.CENTER);
		
		inTf = new JTextField();
		jplO.add(inTf, BorderLayout.SOUTH);
		
		ct.add(jplO); // ct의 CENTER까지 차지하기 위해 위치 설정x
		//
		
		// 하단(계산영역)
		JPanel jpBtns = new JPanel();
		jpBtns.setLayout(new GridLayout(4, 4, 5, 5));
		String[] calcElements = {"=", "←", "÷", "×", "7", "8", "9", "－", "4", "5", "6", "+", "1", "2", "3", "0"};
		btns = new JButton[16];
		for(int i = 0; i < calcElements.length; i++) {
			btns[i] = new JButton(calcElements[i]);
			jpBtns.add(btns[i]);
		}
		for(int i = 0; i < btns.length; i++) {
			btns[i].addActionListener(this);
		}
		
		ct.add(jpBtns, BorderLayout.SOUTH);
		//

		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		if(Character.isDigit(arg0.getActionCommand().charAt(0))) { // 누른 버튼의 종류가 숫자이면
			inTf.setText(inTf.getText() + arg0.getActionCommand());
		}
		else {
			try {
				if(arg0.getActionCommand() == "=") {
					dlm.addElement(inTf.getText() + " = " + calculate(inTf.getText()) + "\n");
					logSave(inTf.getText() + " = " + calculate(inTf.getText()) + "\n");
					inTf.setText(null);
				}
				else if(arg0.getActionCommand() == "←") {
					if(Character.isDigit(inTf.getText().charAt(inTf.getText().length() - 1))) 
						inTf.setText(inTf.getText().substring(0, inTf.getText().length() - 1));
					else inTf.setText(inTf.getText().substring(0, inTf.getText().length() - 3)); // 공백포함 3글자 지우기
				}
				else {
					inTf.setText(inTf.getText() + " " + arg0.getActionCommand() + " ");
				}
			}
			catch(Exception e) {
				dlm.addElement(inTf.getText() + " = NaN\n");
				logSave(inTf.getText() + " = NaN\n");
				inTf.setText(null);
			}
		}
	}
	
	private double calculate(String equation) throws Exception { // 예외처리 여기서 하기 어려우므로 호출한 메소드로 넘김
		double result = 0;
		double num1;
		double num2;
		char operator;
		
		String[] elements = equation.split(" ");
		if(elements.length == 1) {
			num1 = Integer.parseInt(String.valueOf(elements[0]));
			return num1;
		}
		else {
			num1 = Integer.parseInt(String.valueOf(elements[0]));
			num2 = Integer.parseInt(String.valueOf(elements[2]));
			operator = elements[1].charAt(0);
		}
		
		if(operator == '+') result = num1 + num2;
		else if(operator == '－') result = num1 - num2;
		else if(operator == '×') result = num1 * num2;
		else if(operator == '÷') {
			if(num2 == 0) throw new IllegalArgumentException();
			else result = num1 / num2;
		}
		
		return result;
	}
	
	private void logSave(String log) {
		try {
			FileWriter fw = new FileWriter("calc_history.txt", true);
			fw.write(log);
			fw.close();
		}
		catch(Exception e) {
			System.out.println("파일 열기 실패");
		}
	}
}
