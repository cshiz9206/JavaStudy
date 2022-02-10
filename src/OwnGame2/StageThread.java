package OwnGame2;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class StageThread extends BreakOutFrame implements Runnable {
	
	public void run() {
		while(true) {
			if(Ball.isDead || TimeThread.timeEnd) {
				ct.removeAll();
				ct.repaint();
				new EndingPanel(ct.getWidth(), ct.getHeight(), db);
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				stageStart();
			}
		}
	}
}
