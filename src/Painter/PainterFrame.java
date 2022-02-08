package Painter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PainterFrame extends JFrame implements MouseMotionListener, MouseListener {
	JPanel[][] jpnls;
	JPanel tmp;
	boolean isClicked = false;
	
	ArrayList<JPanel> pnlLogs = new ArrayList<>();
	
	public PainterFrame() {
		setTitle("간단한 그림판");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container ct = getContentPane();
		ct.setLayout(new BorderLayout());
		ct.addMouseMotionListener(this);
		ct.addMouseListener(this);
		
		JPanel jpnlsGrid = new JPanel(new GridLayout(100, 100));
		jpnls = new JPanel[100][100];
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				jpnls[i][j] = new JPanel();
				jpnls[i][j].setFocusable(true);
				jpnls[i][j].setBackground(Color.WHITE);
				jpnlsGrid.add(jpnls[i][j]);
			}
		}
		jpnlsGrid.setBackground(new Color(0, 0, 0));
		
//		JLabel topSpace = new JLabel("aaa");
//		topSpace.setBackground(new Color(0, 0, 0));
//		topSpace.setSize(600, 10);
//		JLabel rightSpace = new JLabel("aaa");
//		rightSpace.setBackground(new Color(0, 0, 0));
//		rightSpace.setSize(10, 600);
//		JLabel leftSpace = new JLabel("aaa");
//		leftSpace.setBackground(new Color(0,0,0));
//		leftSpace.setSize(10, 600);
//		JLabel bottomSpace = new JLabel("aaa");
//		bottomSpace.setBackground(new Color(0,0,0));
//		bottomSpace.setSize(600, 10);
		
//		ct.add(topSpace, BorderLayout.NORTH);
//		ct.add(rightSpace, BorderLayout.EAST);
//		ct.add(leftSpace, BorderLayout.WEST);
//		ct.add(bottomSpace, BorderLayout.SOUTH);
		ct.add(jpnlsGrid, BorderLayout.CENTER);
		
		setVisible(true);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		isClicked = true;
		for(JPanel[] pnlRow : jpnls) {
			for(JPanel pnl : pnlRow) {
				if((pnl.getX() <= e.getX()) && ((pnl.getX() + pnl.getWidth()) >= e.getX()) && (pnl.getY() <= e.getY()) && ((pnl.getY() + pnl.getHeight()) >= e.getY())) {
					pnl.setBackground(Color.GREEN);
					pnl.setOpaque(true);
				}
			}
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		if(!isClicked) {
			for(int i = 0; i < pnlLogs.size()-1; i++) { // 같은 패널 방문하는 것때문에 순서 바꿈
				if(pnlLogs.get(i).getBackground() != Color.GREEN) {
					System.out.println(pnlLogs.get(i).getBackground());
					pnlLogs.get(i).setBackground(Color.white);
					pnlLogs.get(i).setOpaque(true);
				}
			}
			
			for(JPanel[] pnlRow : jpnls) {
				for(JPanel pnl : pnlRow) {
					if((pnl.getX() < e.getX()) && ((pnl.getX() + pnl.getWidth()) > e.getX()) && (pnl.getY() < e.getY()) && ((pnl.getY() + pnl.getHeight()) > e.getY())) {
						if(pnl.getBackground() != Color.GREEN) {
							pnl.setBackground(Color.RED);
							pnl.setOpaque(true);
							
							pnlLogs.add(pnl);
						}
					}
				}
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		isClicked = false;
	}
}
