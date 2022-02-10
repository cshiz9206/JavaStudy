package OwnGame2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ScoreBoard {
	private Connection conn; // DB�� ���Ἲ�� ���� �������̽�
	private static final String USERNAME = "root"; // DBMS ���ӽ� ���̵�
	private static final String PASSWORD = "9206"; // DBMS ���ӽ� ��й�ȣ
	// DBMS ������ DB�� (�������� : jdbc:mysql / host : localhost / port : 3306 / filename : scorelog)
	private static final String URL = "jdbc:mysql://localhost:3306/scorelog";
	
	JTable jtb;
	
	public ScoreBoard(JTable jtb) {
		try {
			/* ����̺� �ε� Driver loading(DB ��ǰ�� ����) 
			/ forName([Ŭ������] or [��Ű����.����̹�Ŭ������]) 
			/ ��Ű���� : com.mysql.jdbc / Ŭ������ : Driver */
			Class.forName("com.mysql.jdbc.Driver"); 
			// ���ᰴü ���� / DriverManager : JVM���� JDBC ��ü�� �����ϴ� Ŭ����(Driver ���, Connection �����۾� ��)
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD); 
			System.out.println("����̹� �ε� ����");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("����̹� �ε� ����");
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		this.jtb = jtb;
	}
	
	public void insertBoard(String connectName, int score) {
		String query = "insert into scoreboard values(?,?,?)"; // insert into [table ��] values([? * column��])
		
		PreparedStatement pstmt = null; // Statement : SQL���� �����ϴ� �������̽�
		try {
			pstmt = conn.prepareStatement(query); // ���� ��ü ����
			
			pstmt.setString(1, null);
			pstmt.setString(2, String.valueOf(connectName));
			pstmt.setInt(3, score);
			
			int result = pstmt.executeUpdate(); // ������ sql ����� ���� ��, �����ǰų� ������ ���ڵ��� ���� ��ȯ
			// executeQuery(String sql : ������) : ResultSet(���̺�) ��ȯ -> .getInt(index) ���� �̿��Ͽ� ���̺� ������ �� �� ����
			
			// ���� �Ǵ�
			if(result == 1) System.out.println("������ ���� ����");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("������ ���� ����");
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null && !pstmt.isClosed()) pstmt.close();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
	}
	
	public ArrayList readBoard() {
		// https://blog.naver.com/PostView.nhn?isHttpsRedirect=true&blogId=munjh4200&logNo=50176968113
		// https://comster.tistory.com/776
		ArrayList<String[]> data = new ArrayList<String[]>();
		int rank = 1;
		
		String query = "select * from scoreboard order by userScore desc";
		
		PreparedStatement pstmt = null; // Statement : SQL���� �����ϴ� �������̽�
		try {
			pstmt = conn.prepareStatement(query); // ���� ��ü ����
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String[] userData = new String[3];
				userData[0] = String.valueOf(rank);
				userData[1] = rs.getString(2);
				userData[2] = String.valueOf(rs.getInt(3));
				data.add(userData);
				rank += 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("������ ���� ����");
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null && !pstmt.isClosed()) pstmt.close();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
		
		return data;
	}
	
	public void clearBoard() {
		String query = "delete from scoreboard";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
			
			int result = pstmt.executeUpdate();
			
			// ���� �Ǵ�
			if(result == 1) System.out.println("������ ���� ����");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("������ ���� ����");
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null && !pstmt.isClosed()) pstmt.close();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
	}
	
	public void dataUpdate() {
		clearJtable();
		ArrayList<String[]> data = readBoard();
		for(String[] userData : data) ((DefaultTableModel)jtb.getModel()).addRow(userData);
	}
	
	public void clearJtable() {
		((DefaultTableModel)jtb.getModel()).setNumRows(0);
		String[] header = {"No", "User", "Score"};
		((DefaultTableModel)jtb.getModel()).addRow(header);
	}
}
