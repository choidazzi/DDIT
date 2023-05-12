package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 문제 ) lprod_id값을 2개 입력받아서 두 값 중 작은 값부터 큰 값 사이의 자료들을 출력하시오. 
//				(작은 값과 큰 값은 포함)
public class JDBCTest03 {
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
			System.out.print("첫 번째 lprod_id 입력>>");
			int first = sc.nextInt();
			System.out.print("두 번째 lprod_id 입력>>");
			int twice = sc.nextInt();
			
			int max = 0;
			int min = 0;	
			if (first > twice) {
				max = first;
				min = twice;	
			} else {
				max = twice;
				min = first;
			}
			//int min = Math.min(first, twice);
			//int min = Math.max(first, twice);
			
			//String sql = "select * from lprod where lprod_id>= " + min + "and lprod_id<=" + max ;
			String sql = "select * from lprod where lprod_id between " + min + " and " + max ;
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			System.out.println("== 쿼리문 처리 결과 ==");
			while(rs.next()) {
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
