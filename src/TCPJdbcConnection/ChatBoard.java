package TCPJdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChatBoard {
	private Connection conn; // DB�� ���Ἲ�� ���� �������̽�
	private static final String USERNAME = "root"; // DBMS ���ӽ� ���̵�
	private static final String PASSWORD = "9206"; // DBMS ���ӽ� ��й�ȣ
	// DBMS ������ DB�� (�������� : jdbc:mysql / host : localhost / port : 3306 / filename : chatlog)
	private static final String URL = "jdbc:mysql://localhost:3306/chatlog";
	
	public ChatBoard() {
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
	}
	
	public void insertBoard(int connectNo, String chat) {
		String query = "insert into chatboard values(?,?,?)"; // insert into [table ��] values([? * column��])
		
		PreparedStatement pstmt = null; // Statement : SQL���� �����ϴ� �������̽�
		try {
			pstmt = conn.prepareStatement(query); // ���� ��ü ����
			
			pstmt.setString(1, null);
			pstmt.setString(2, String.valueOf(connectNo));
			pstmt.setString(3, chat);
			
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
	
	public void clearBoard() {
		String query = "delete from chatboard";
		
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
}
