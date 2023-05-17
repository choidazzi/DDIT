package kr.or.ddit.board.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

// JDBC 드라이버를 로딩하고 Connection 객체를 생성하여 반환하는 메서드로 구성된 class 만들기 
public class DBUtil3 {
	// ResourceBundle객체 변수 선언 
	private static ResourceBundle bundle;
	
	static {
		bundle = ResourceBundle.getBundle("kr.or.ddit.config.dbinfo");
		try {
			
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName(bundle.getString("driver"));
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
	}
}
	
	public static Connection getConnection() {
		try {
			/*
			return DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"system",
					"java");
			*/
			return DriverManager.getConnection(
					bundle.getString("url"),
					bundle.getString("user"),
					bundle.getString("pass"));
		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
			return null;
		}
	}
}
