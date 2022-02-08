package CatGame;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CatGameFrame extends JFrame implements MouseMotionListener {
	JLabel cat, mouse;
	boolean isStarted = false;
	
	public CatGameFrame() {
		setTitle("°í¾çÀÌ °ÔÀÓ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200, 600);
		
		Container ct = getContentPane();
		ct.setLayout(null);
		
		cat = new JLabel();
		ImageIcon iiCat = new ImageIcon("C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_Á¤½ÂÇö\\JAVA_edu_Á¤½ÂÇö\\src\\CatGame\\cat.png");
		cat.setIcon(iiCat);
		cat.setSize(iiCat.getIconWidth(), iiCat.getIconHeight());
		cat.setLocation(600, 300);
		
		mouse = new JLabel();
		ImageIcon iiMouse = new ImageIcon("C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_Á¤½ÂÇö\\JAVA_edu_Á¤½ÂÇö\\src\\CatGame\\mouse.png");
		mouse.setIcon(iiMouse);
		mouse.setSize(iiMouse.getIconWidth(), iiMouse.getIconHeight());
		
		ct.addMouseMotionListener(this);
		
		ct.add(cat);
		ct.add(mouse);
		
		
		setVisible(true);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		mouse.setLocation(e.getX(), e.getY());
		if(!isStarted) new CatThread(cat, mouse).start();
		isStarted = true;
	}
}
