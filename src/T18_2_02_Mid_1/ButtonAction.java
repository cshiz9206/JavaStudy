package T18_2_02_Mid_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ButtonAction implements ActionListener {
	JTextField jtf;
	JTextArea jta;
	JList jl;
	FileIO io;
	WordCounter wc;
	String context;
	String str;
	
	public ButtonAction(JTextField jtf, JTextArea jta, JList jl) {
		this.jtf = jtf;
		this.jta = jta;
		this.jl = jl;
		io = new FileIO();
		wc = new WordCounter(jl);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().contentEquals("파일 불러오기")) {
			context = io.read(jtf.getText());
			jta.append(context);
		}
		if(e.getActionCommand().contentEquals("단어별 개수 세기")) {
			wc.wordCount(context);
			str = wc.toString();
		}
		if(e.getActionCommand().contentEquals("결과 파일로 내보내기")) {
			io.printf(str);
		}
	}

}
