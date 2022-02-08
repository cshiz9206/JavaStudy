package T18_2_01_Mid_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ButtonAction implements ActionListener {
	DefaultListModel dlm;
	JTextField jtfId, jtfKo, jtfMa, jtfEng;
	JLabel jlbResult;
	
	Scores scores;
	FileIO fio;
	
	public ButtonAction(DefaultListModel dlm, JTextField jtfId, JTextField jtfKo, JTextField jtfMa, JTextField jtfEng, JLabel jlbResult) {
		this.dlm = dlm; this.jtfId = jtfId; this.jtfKo = jtfKo; this.jtfMa = jtfMa; this.jtfEng = jtfEng; this.jlbResult = jlbResult;
		
		scores = new Scores();
		fio = new FileIO();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ArrayList<String> scoresInv = new ArrayList<>(Arrays.asList(jtfId.getText(), jtfKo.getText(), jtfMa.getText(), jtfEng.getText()));
		if(e.getActionCommand().contentEquals("�߰�")) {
			scores.addScoresInv(scoresInv);
			dlm.addElement("�й� : " + scoresInv.get(0) + ", ���� : " + scoresInv.get(1) + ", ���� : " + scoresInv.get(2) + 
					", ���� : " + scoresInv.get(3) + ", ��� : " + calcAvg(scoresInv));
		}
		if(e.getActionCommand().contentEquals("��� ���")) {
			String total = scores.calcTotalAvg();
			jlbResult.setText(total);
		}
		if(e.getActionCommand().contentEquals("���Ϸ� ����")) {
			String context = "";
			for(int i = 0; i < dlm.size(); i++) {
				context += dlm.get(i) + "\n";
			}
			fio.write(context + jlbResult.getText());
		}
		
		jtfId.setText("");
		jtfKo.setText("");
		jtfMa.setText("");
		jtfEng.setText("");
	}
	
	protected String calcAvg(ArrayList scoresInv) {
		int sum = 0;
		for(int i = 1; i < scoresInv.size(); i++) sum += Integer.parseInt((String) scoresInv.get(i));
		return String.format("%.2f", (float)sum / (float)(scoresInv.size() - 1));
	}
}
