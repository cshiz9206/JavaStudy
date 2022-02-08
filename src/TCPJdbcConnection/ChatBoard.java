package TCPJdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChatBoard {
	private Connection conn; // DB와 연결성을 갖는 인터페이스
	private static final String USERNAME = "root"; // DBMS 접속시 아이디
	private static final String PASSWORD = "9206"; // DBMS 접속시 비밀번호
	// DBMS 접속할 DB명 (프로토콜 : jdbc:mysql / host : localhost / port : 3306 / filename : chatlog)
	private static final String URL = "jdbc:mysql://localhost:3306/chatlog";
	
	public ChatBoard() {
		try {
			/* 드라이브 로딩 Driver loading(DB 제품군 선택) 
			/ forName([클래스명] or [패키지명.드라이버클래스명]) 
			/ 패키지명 : com.mysql.jdbc / 클래스명 : Driver */
			Class.forName("com.mysql.jdbc.Driver"); 
			// 연결객체 생성 / DriverManager : JVM에서 JDBC 전체를 관리하는 클래스(Driver 등록, Connection 연결작업 등)
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD); 
			System.out.println("드라이버 로딩 성공");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버 로딩 실패");
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public void insertBoard(int connectNo, String chat) {
		String query = "insert into chatboard values(?,?,?)"; // insert into [table 명] values([? * column수])
		
		PreparedStatement pstmt = null; // Statement : SQL문을 실행하는 인터페이스
		try {
			pstmt = conn.prepareStatement(query); // 실행 객체 생성
			
			pstmt.setString(1, null);
			pstmt.setString(2, String.valueOf(connectNo));
			pstmt.setString(3, chat);
			
			int result = pstmt.executeUpdate(); // 지정된 sql 명령을 수행 후, 수정되거나 삭제된 레코드의 수를 반환
			// executeQuery(String sql : 쿼리문) : ResultSet(테이블) 반환 -> .getInt(index) 등을 이용하여 테이블 내용을 볼 수 있음
			
			// 성공 판단
			if(result == 1) System.out.println("데이터 삽입 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("데이터 삽입 실패");
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
			
			// 성공 판단
			if(result == 1) System.out.println("데이터 삭제 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("데이터 삭제 실패");
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
