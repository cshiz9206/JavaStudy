package T18_2_01_End_2;

import javax.swing.JButton;

public class TicTacToeControl {
	JButton[] jbtns;
	JButton[][] btns;
	
	public TicTacToeControl(JButton[] jbtns) {
		this.jbtns = jbtns;
		
		btns = new JButton[3][3];
		int n = 0;
		for(int i = 0; i < btns.length; i++) {
			for(int j = 0; j < btns.length; j++) {
				btns[i][j] = jbtns[n];
				n++;
			}
		}
	}
	
	public int judge() {
		boolean userWin = false;
		boolean compWin = false;
		for(int i = 0; i < btns.length; i++) {
			int userCnt = 0;
			int compCnt = 0;
			for(int j = 0; j < btns.length; j++) {
				if(btns[i][j].getIcon().toString().contains("circle")) userCnt += 1;
				if(btns[i][j].getIcon().toString().contains("rectangle")) compCnt += 1;
			}
			if(userCnt == 3) userWin = true;
			if(compCnt == 3) compWin = true;
		}
		
		for(int i = 0; i < btns.length; i++) {
			int userCnt = 0;
			int compCnt = 0;
			for(int j = 0; j < btns.length; j++) {
				if(btns[j][i].getIcon().toString().contains("circle")) userCnt += 1;
				if(btns[j][i].getIcon().toString().contains("rectangle")) compCnt += 1;
			}
			if(userCnt == 3) userWin = true;
			if(compCnt == 3) compWin = true;
		}
		
		int userCnt = 0;
		int compCnt = 0;
		for(int i = 0; i < btns.length; i++) {
			if(btns[i][i].getIcon().toString().contains("circle")) userCnt += 1;
			if(btns[i][i].getIcon().toString().contains("rectangle")) compCnt += 1;
			if(userCnt == 3) userWin = true;
			if(compCnt == 3) compWin = true;
		}
		
		userCnt = 0;
		compCnt = 0;
		for(int i = 0; i < btns.length; i++) {
			if(btns[i][2 - i].getIcon().toString().contains("circle")) userCnt += 1;
			if(btns[i][2 - i].getIcon().toString().contains("rectangle")) compCnt += 1;
			if(userCnt == 3) userWin = true;
			if(compCnt == 3) compWin = true;
		}
		
		if(userWin) return 0;
		if(compWin) return 1;
		return 2;
	}
}
