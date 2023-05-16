package kr.or.ddit.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// JDBC 드라이버를 로딩하고 Connection 객체를 생성하여 반환하는 메서드로 구성된 class 만들기 
public class DBUtil2 {
	// Properties객체 변수 선언 
	private static Properties prop;
	
	static {
		// Properties 객체 생성 
		prop = new Properties();
		File f = new File("res/kr/or/ddit/config/dbinfo.properties");
		FileInputStream fin = null;
		try {
			fin = new FileInputStream(f);
			prop.load(fin);
			
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName(prop.getProperty("driver"));
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		} finally {
			if(fin!=null) try {fin.close();} catch(IOException e) {}
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
					prop.getProperty("url"),
					prop.getProperty("user"),
					prop.getProperty("pass"));
		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
			return null;
		}
	}
}
