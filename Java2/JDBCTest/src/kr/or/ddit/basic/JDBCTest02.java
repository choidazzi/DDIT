package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 문제 1) 사용자로부터 lprod_id 값을 입력받아 입력한 값보다 lprod_id보다 큰 자료들을 출력하시오.
public class JDBCTest02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"system",
					"java");
			System.out.println("lprod_id 값을 입력하세요. 1~12까지");
			String user = sc.nextLine();
			String sql = "select * from lprod where lprod_id >" + user;
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			System.out.println("== 쿼리문 처리 결과 ==");
			
			while (rs.next()) {
				System.out.println("LPROD_ID : " + rs.getInt("lprod_id"));
				System.out.println("LPROD_GU :" + rs.getString("lprod_gu"));
				System.out.println("LPROD_NM :" + rs.getString("lprod_nm"));
				System.out.println("-----------------------------------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// 5) 자원 반납 (만들어진 순서의 반대로)
			if (rs != null) try {rs.close();} catch(SQLException e) {}
			if (stmt != null) try {stmt.close();} catch(SQLException e) {}
			if (conn != null) try {conn.close();} catch(SQLException e) {}
		}
	}
}
