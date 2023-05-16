package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;
import kr.or.ddit.util.DBUtil2;
import kr.or.ddit.util.DBUtil3;

/*
 * 회원을 관리하는 프로그램을 작성하시오 (MYMEMBER 테이블 이용)
 * 
 * 아래의 메뉴의 기능을 모두 구현하시오. (CRUD 기능 구현하기)
 * 
 * 
 * 메뉴예시 ) 
 * ------------------------------
 * 1. 자료 추가							=> insert 		(C)
 * 2. 자료 삭제							=> delete		(D)
 * 3. 자료 수정 							=> update		(U)
 * 4. 전체 자료 출력 					=> select		(R)
 * 0. 작업 끝.
 * ------------------------------
 * 
 * 조건 )
 * 			 1) '자료 추가' 메뉴에서 '회원 ID' 는 중복되지 않는다. (중복되면 다시 입력 받는다.)
 * 			 2) '자료 삭제' 는 '회원 ID' 를 입력 받아 처리한다. 
 * 			 3) '자료 수정' 에서 '회원 ID' 는 변경되지 않는다.
 * 
 * */



public class JDBCTest06 {
	Scanner scan;
	Connection conn;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;
	public static void main(String[] args) {
		JDBCTest06 jt = new JDBCTest06();
		jt.start();
	}
	//생성자 
	public JDBCTest06() {
		scan = new Scanner(System.in);
		conn = DBUtil.getConnection();
	}
	
	//프로그램 실행 메서드 start()
	public void start() {
		while (true) {			
			int num = menu();
			scan.nextLine();
			switch(num) {
			case 1: insert(); break;
			case 2: delete(); break;
			case 3: update(); break;
			case 4: select(); break;
			case 5: updateMember(); break;
			case 0: System.out.println("프로그램 종료"); return;
			default: System.out.println("번호를 다시 입력하세요."); break;
			}
		}
	}
	
	// 선생님이랑 함
	private void updateMember() {
		System.out.println();
		System.out.println("수정할 회원 정보를 입력하세요...");
		System.out.print("회원 ID >>");
		String memId = scan.next();
		
		int count = getMemberCount(memId);
		
		if (count == 0) {// 회원이 없을 때...
			System.out.println(memId + "은(는) 존재하지 않는 회원 ID 입니다.");
			System.out.println("수정 작업을 종료합니다.");
			return;
		}
		int num;								//수정을 원하는 항목의 선택 번호가 저장될 변
		String updateField = null;		// 수정할 컬럼명이 저장될 변수  
		String updateTitle = null;		// 입력할 때 보여줄 제목 
		
		do {
			System.out.println();
			System.out.println("수정할 항목을 선택하세요.");
			System.out.println("1. 비밀번호 		2. 회원이름 		3. 전화번호 		4. 회원주소 ");
			System.out.println("========================================");
			System.out.print("수정 항목 선택 >>");
			num = scan.nextInt();
			
			switch (num) {
			case 1: updateField = "mem_pass"; updateTitle = "비밀번호"; break;
			case 2: updateField = "mem_name"; updateTitle = "회원이름"; break;
			case 3: updateField = "mem_tel"; updateTitle = "전화번호"; break;
			case 4: updateField = "mem_addr"; updateTitle = "회원주소"; break;
			default: System.out.println("수정할 항목을 잘못 선택했습니다. 다시 선택하세요...");
				
			}
		} while (num < 1 || num > 4);
		scan.nextLine(); // 입력 버퍼 비우기 
		System.out.println();
		System.out.println("수정할" + updateTitle + ">>");
		String updateData = scan.nextLine();	// 수정할 데이터 입력 
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			
			String sql = "update mymember set "+ updateField +" =? where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, updateData);
			pstmt.setString(2, memId);
			int cnt = pstmt.executeUpdate();
			
			if (cnt > 0) {
				System.out.println(memId + "의 정보 수정이 완료되었습니다.");
			} else {
				System.out.println(memId + "의 정보 수정을 실패했습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
	}
	// 회원 ID를 매개변수로 받아서 해당 회원의 개수를 반환하는 메서드 
		private int getMemberCount(String memId) {
			// 반환값이 저장될 변수 
			int count = 0;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				conn = DBUtil.getConnection();
				
				String sql = "select count(*) cnt from mymember where mem_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, memId);		// 위의 매개변수 
				
				rs = pstmt.executeQuery();
				
				if (rs.next()) {
					count = rs.getInt("cnt");
				}
				
			} catch (SQLException e) {
				e.getStackTrace();
			} finally {
				if (rs != null) try {rs.close();} catch (SQLException e) {}
				if (conn != null) try {conn.close();} catch (SQLException e) {}
				if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
			}
			return count;
		}
	private void insert() {
		conn = DBUtil.getConnection();

		try {
			String id;
			int count = 0;
			pstmt = null;
			// 아이디, 패스워드, 회원이름, 전화번호, 주소
			do {
				System.out.print("아이디 입력 >>");
				id = scan.nextLine();
				
				String sql1 = "select count(*) cnt from mymember where mem_id = ?";
				
				pstmt = conn.prepareStatement(sql1);
				pstmt.setString(1, id);
				
				rs = pstmt.executeQuery();
				if (rs.next()) {
					count = rs.getInt("cnt");
				}
				
				if (count >0) {
					System.out.println(id + "이미 등록된 ID 입니다. 다시 입력하세요...");
				}
			} while (count > 0);
			
			System.out.print("패스워드 입력 >>");
			String pass = scan.nextLine();
			System.out.print("회원이름 입력 >>");
			String name = scan.nextLine();
			System.out.print("전화번호 입력 >>");
			String tel = scan.nextLine();
			System.out.print("주소 입력 >>");
			String addr = scan.nextLine();
			
			String sql2 = "insert into mymember values (?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql2);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			pstmt.setString(3, name);
			pstmt.setString(4, tel);
			pstmt.setString(5, addr);
			
			int cnt = pstmt.executeUpdate();
			
			if (cnt>0) System.out.println("등록 성공!!"); 
			else System.out.println("등록 실패!!"); 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) try {rs.close();} catch(SQLException e) {}
			if (pstmt != null) try {pstmt.close();} catch(SQLException e) {}
			if (conn != null) try {conn.close();} catch(SQLException e) {}
		}
	}
	
	//삭제 - 아이디를 받아 처리 
	private void delete() {
		conn = DBUtil.getConnection();

		try {
			String id;
			int count = 0;
			do {
			System.out.print("회원정보를 삭제할 아이디 입력 >> ");
			id = scan.nextLine();
			String sql1 = "select count(*) cnt from mymember where mem_id = ?";
			
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1,id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				count = rs.getInt("cnt");
			}
			
			if (count == 0) {
				System.out.println("존재하지 않는 아이디 입니다. 다시 입력해주세요.");
			}
			} while (count == 0);
			String sql2 = "delete from mymember where mem_id = ?";
			pstmt = conn.prepareStatement(sql2);
			
			pstmt.setString(1, id);
			
			int cnt = pstmt.executeUpdate();
			
			if (cnt > 0) System.out.println("삭제완료!");
			else System.out.println("삭제 실패!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) try {rs.close();} catch(SQLException e) {}
			if (pstmt != null) try {pstmt.close();} catch(SQLException e) {}
			if (conn != null) try {conn.close();} catch(SQLException e) {}
		}
	}

	private void update() {
		String id;
		int count = 0;
		conn = DBUtil.getConnection();
		try {
			do {
			System.out.println("회원정보를 수정하려는 ID를 입력해주세요.");
			id = scan.nextLine();
			String sql1 = "select count(*) cnt from mymember where mem_id = ?";
			
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1,id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				count = rs.getInt("cnt");
			}
			
			if (count == 0) {
				System.out.println("존재하지 않는 아이디 입니다. 다시 입력해주세요.");
			}
			} while (count == 0);
			
			System.out.print("변경할 비밀번호 입력>>");
			String pass = scan.nextLine();
			System.out.print("변경할 회원이름 입력>>");
			String name = scan.nextLine();
			System.out.print("변경할 전화번호 입력>>");
			String tel = scan.nextLine();
			System.out.print("변경할 주소 입력>>");
			String addr = scan.nextLine();
			
			String sql2 = "update mymember set mem_pass = ?,"
								+ " mem_name = ?, "
								+ "mem_tel = ?,"
								+ " mem_addr= ? "
								+ "where mem_id= ? ";
			
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, pass);
			pstmt.setString(2, name);
			pstmt.setString(3, tel);
			pstmt.setString(4, addr);
			pstmt.setString(5, id);
			
			int cnt = pstmt.executeUpdate();
			
			if (cnt>0) System.out.println("수정 성공!!");
			else System.out.println("수정 실패!!");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (rs != null) try {rs.close();} catch(SQLException e) {}
			if (pstmt != null) try {pstmt.close();} catch(SQLException e) {}
			if (conn != null) try {conn.close();} catch(SQLException e) {}
		}
		
	}

	// 전체 정보 출력 
	private void select() {
		conn = DBUtil3.getConnection();
		
		try {
			String sql = "select * from mymember";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			System.out.println("== 모든 회원 정보 출력==");
			while (rs.next()) {				
				System.out.println("+++++++++++++++++++++");
				System.out.println("아이디: " + rs.getString("mem_id"));
				System.out.println("비밀번호: " +rs.getString("mem_pass"));
				System.out.println("이름: " +rs.getString("mem_name"));
				System.out.println("전화번호: " +rs.getString("mem_tel"));
				System.out.println("주소: " +rs.getString("mem_addr"));
				System.out.println("+++++++++++++++++++++");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			// 5) 자원 반납 (만들어진 순서의 반대로)
			if (rs != null) try {rs.close();} catch(SQLException e) {}
			if (stmt != null) try {stmt.close();} catch(SQLException e) {}
			if (conn != null) try {conn.close();} catch(SQLException e) {}
		}
	}

	public int menu() {
		System.out.println("------------------------------");
		System.out.println("1. 자료 추가");
		System.out.println("2. 자료 삭제");
		System.out.println("3. 자료 수정");
		System.out.println("4. 전체 자료 출력");
		System.out.println("5. 자료 수정2");
		System.out.println("0. 작업 끝");
		System.out.println("------------------------------");
		
		System.out.print("메뉴 선택 >> ");
		return scan.nextInt();
	}
}

