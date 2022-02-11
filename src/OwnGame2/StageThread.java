package OwnGame2;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class StageThread implements Runnable {
	Container ct;
	ScoreBoard db;
	
	public StageThread(Container ct, ScoreBoard db) {
		this.ct = ct;
		this.db = db;
	}
	
	public void run() {
		while(true) {
			if(Ball.isDead || TimeThread.timeEnd) {
				ct.removeAll();
				ct.repaint();
				ct.add(new EndingPanel(ct, db));
				ct.repaint();
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				ct.removeAll();
				Ball.isDead = false;
				TimeThread.timeEnd = false;
			}
		}
	}
}
