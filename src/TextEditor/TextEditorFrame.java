package TextEditor;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TextEditorFrame extends JFrame implements ListSelectionListener, ActionListener{
	DefaultListModel dlm;
	JList jlist;
	JTextField jtf;
	JTextArea contents;
	
	public TextEditorFrame() {
		setTitle("간단한 메모장");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 600);
		
		Container ct = getContentPane();
		ct.setLayout(new BorderLayout());
		
		File folder = new File("./");
		File[] listOfFiles = folder.listFiles();
		
		dlm = new DefaultListModel();
		jlist = new JList(dlm);
		jlist.setFixedCellWidth(150);
		jlist.addListSelectionListener(this);
		//dlm.removeElement("");
		
		String fileName = new String();
		for(File tmp : listOfFiles) {
			fileName = tmp.getName();
			if(fileName.substring(fileName.lastIndexOf(".") + 1).contentEquals("txt")) {
				dlm.addElement(fileName);
				System.out.println(fileName);
			}
		}
		
		ct.add(jlist, BorderLayout.WEST);
		
		contents = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(contents);
		JLabel jlbFName = new JLabel("파일명");
		jtf = new JTextField();
		JLabel jlbFCont = new JLabel("파일 내용");
		JPanel jpnTop = new JPanel(new GridLayout(3, 1));
		jpnTop.add(jlbFName);
		jpnTop.add(jtf);
		jpnTop.add(jlbFCont);
		
		JPanel jpnRight = new JPanel(new BorderLayout());
		jpnRight.add(jpnTop, BorderLayout.NORTH);
		jpnRight.add(scrollPane, BorderLayout.CENTER);
		
		ct.add(jpnRight, BorderLayout.CENTER);
		
		JButton jbtn = new JButton("저장");
		jbtn.addActionListener(this);
		ct.add(jbtn, BorderLayout.SOUTH);
		
		setVisible(true);
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		// 목록 선택
		contents.setText(null);
		
		BufferedReader br;
		jtf.setText((String) jlist.getSelectedValue());
		
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream("./" + jtf.getText()), "UTF-8"));
			String line = null;
			while((line = br.readLine()) != null) {
				contents.append(line + "\n");
			}
			
			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// 저장 버튼
		BufferedWriter bw;
		try {
			if(jtf.getText().contains(".txt"))
				bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(jtf.getText()), "UTF-8"));
			else bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(jtf.getText() + ".txt"), "UTF-8"));
			bw.write(contents.getText());
			bw.flush();
			bw.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		boolean flag = false;
		for(int i = 0; i < dlm.getSize(); i++) {
			if(jtf.getText().contentEquals((String)dlm.getElementAt(i))) {
				flag = true;
			}
		}
		if(!flag) {
			if(jtf.getText().contains(".txt")) dlm.addElement(jtf.getText());
			else dlm.addElement(jtf.getText() + ".txt");
		}
	}
}
