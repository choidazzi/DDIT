package kr.or.ddit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

// JDBC 드라이버를 로딩하고 Connection 객체를 생성하여 반환하는 메서드로 구성된 class 만들기 
public class DBUtil {
	static final Logger logger = Logger.getLogger(DBUtil.class);
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			logger.info("DB 드라이버 로딩 성공!");
		} catch (ClassNotFoundException e) {
			//System.out.println("드라이버 로딩 실패");
			logger.error("드라이버 로딩 실패!",e);
			//e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn =  DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"system",
					"java");
			logger.info("DB 연결 성공!");
		} catch (SQLException e) {
			//System.out.println("오라클 연결 실패");
			logger.error("DB 연결 실패!",e);
			return null;
		}
		return conn;
	}
}
