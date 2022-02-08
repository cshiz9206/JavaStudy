package SwingCalc2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import SwingCalc.CalcFrame;

public class CalcFrameEx extends CalcFrame implements ActionListener {
	boolean digitBefore = true;
	
	public CalcFrameEx(String title, int w, int h) {
		super(title, w, h);
		
		// 버튼마다 이벤트 처리 설정
		for(int i = 0; i < btns.length; i++) {
			btns[i].addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		if(Character.isDigit(arg0.getActionCommand().charAt(0))) { // 누른 버튼의 종류가 숫자이면
			inTf.setText(inTf.getText() + arg0.getActionCommand());
			digitBefore = true;
		}
		else {
			try {
				if(arg0.getActionCommand() == "=") {
					ta.append(inTf.getText() + " = " + calculate(inTf.getText()) + "\n");
					inTf.setText(null);
				}
				else if(arg0.getActionCommand() == "←") {
					if(digitBefore) inTf.setText(inTf.getText().substring(0, inTf.getText().length() - 1));
					else inTf.setText(inTf.getText().substring(0, inTf.getText().length() - 3)); // 공백포함 3글자 지우기
				}
				else {
					inTf.setText(inTf.getText() + " " + arg0.getActionCommand() + " ");
				}
				digitBefore = false;
			}
			catch(Exception e) {
				ta.append(inTf.getText() + " = NaN\n");
				inTf.setText(null);
			}
		}
		
	}
	
	private double calculate(String equation) throws Exception {
		double result = 0;
		
		String[] elements = equation.split(" ");
		double num1 = Integer.parseInt(String.valueOf(elements[0]));
		double num2 = Integer.parseInt(String.valueOf(elements[2]));
		char operator = elements[1].charAt(0);
		
		if(operator == '+') result = num1 + num2;
		else if(operator == '－') result = num1 - num2;
		else if(operator == '×') result = num1 * num2;
		else if(operator == '÷') {
			if(num2 == 0) throw new IllegalArgumentException();
			else result = num1 / num2;
		}
		
		return result;
	}
}
