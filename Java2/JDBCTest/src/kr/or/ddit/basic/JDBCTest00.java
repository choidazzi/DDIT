package kr.or.ddit.basic;
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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;

public class JDBCTest00 {
	private Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		new JDBCTest00().memberStart();
	}
	// 시작 메서드 
	public void memberStart() {
		while (true) {
			int choice = displayMenu();
			
			switch (choice) {
			// 추가 
			case 1:
				insertMember();
				break;
			// 삭제 
			case 2:
				deleteMember();
				break;
			// 수정 
			case 3:
				updateMember();
				break;
			// 전체 출력 
			case 4:
				displayAll();
				break;
				// 자료 수정 2	-	원하는 항목만 수정하기 
			case 5:
				updateMember2();
				break;
			// 종료 
			case 0:
				System.out.println();
				System.out.println("작업을 마칩니다...");
				return;

			default:
				System.out.println();
				System.out.println("작업 번호를 잘못 입력했습니다. 다시 입력하세요...");
			}
		}
	}

	
	
	////////////////////// CASE 1 //////////////////////
	// 회원 정보를 추가하는 메서드 
	public void insertMember() {
		System.out.println();
		System.out.println("추가할 회원 정보를 입력하세요...");
		
		//회원 ID 가 저장될 변수 
		String memId = null;
		int count = 0;
		do {
			System.out.print("회원 ID >>");
			memId = scan.next();
			
			count = getMemberCount(memId);
			if (count>0) {
				System.out.println(memId + "은(는) 이미 등록된 회원 ID 입니다...");
				System.out.println("다른 회원 ID를 입력해주세요...");
			}
		} while (count > 0);
		
		System.out.print("회원 Password >>");
		String memPass = scan.next();

		System.out.print("회원 Name >>");
		String memName = scan.next();
		
		System.out.print("회원 Tel >>");
		String memTel = scan.next();
		scan.nextLine();										//버퍼 비우기 
		System.out.print("회원 Address >>");
		String memAddr = scan.nextLine();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into mymember values(?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			pstmt.setString(2, memPass);
			pstmt.setString(3, memName);
			pstmt.setString(4, memTel);
			pstmt.setString(5, memAddr);
			
			int cnt = pstmt.executeUpdate();
			
			if (cnt > 0) {
				System.out.println(memId + ": 회원 등록이 완료되었습니다.");
			} else {
				System.out.println(memId + ": 회원 등록을 실패했습니다.");
			}
		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			if (conn != null) try {conn.close();} catch (SQLException e) {}
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
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
	
	//////////////////////CASE 2 //////////////////////
	// 회원정보를 삭제하는 메서드 
	private void deleteMember() {
		System.out.println();
		System.out.println("삭제할 회원 정보를 입력하세요...");
		System.out.print("삭제할 회원 ID >> ");
		String memId = scan.next();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getConnection();
			
			String sql = "delete from mymember where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			int cnt = pstmt.executeUpdate();
			
			if (cnt > 0) {
				System.out.println(memId + " : 회원 정보 삭제 성공!");
			} else {
				System.out.println(memId + " : 회원 ID 가 없거나 삭제 실패입니다.");
			}
		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			if (conn != null) try {conn.close();} catch (SQLException e) {}
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
		}
	}
	//////////////////////CASE 3 //////////////////////
	// 회원 정보를 수정하는 메서드 
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
		
		System.out.println();
		System.out.print("새로운 비밀번호 >> ");
		String newMemPass = scan.next();
		System.out.print("새로운 회원 이름 >> ");
		String newMemName = scan.next();
		System.out.print("새로운 전화번호 >> ");
		String newMemTel = scan.next();
		scan.nextLine();									// 입력 버퍼 비우기 
		System.out.print("새로운 주소 >> ");
		String newMemAddr = scan.nextLine();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getConnection();
			
			String sql = "update mymember set mem_pass=?,mem_name=?,"
							+ "mem_tel=?,mem_addr=?"
							+ "where mem_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newMemPass);
			pstmt.setString(2, newMemName);
			pstmt.setString(3, newMemTel);
			pstmt.setString(4, newMemAddr);
			pstmt.setString(5, memId);
			
			int cnt = pstmt.executeUpdate();
			
			if (cnt > 0) {
				System.out.println(memId + " : 회원 정보 수정이 완료되었습니다.");
			} else {
				System.out.println(memId + " : 회원 정보 수정에 실패했습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) try {conn.close();} catch (SQLException e) {}
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
		}
	}
	//////////////////////CASE 4 //////////////////////
	// 전체 회원 정보를 출력하는 메서드 
	private void displayAll() {
		System.out.println();
		System.out.println("======= =============== ==== 전체 정보 출력=== =============== ======= ========");
		System.out.println("ID			비밀번호 				이름			전화번호			주소	 ");
		System.out.println("======= ======= =============== ======= =============== ======= ========");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			
			String sql = "select * from mymember";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String memId = rs.getString("mem_id");
				String memPass = rs.getString("mem_pass");
				String memName = rs.getString("mem_name");
				String memTel = rs.getString("mem_tel");
				String memAddr = rs.getString("mem_addr");
				
				System.out.println(memId + "			" + memPass+"				" +memName+"				"+memTel +"				"+memAddr);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {			
			if (rs != null) try {rs.close();} catch (SQLException e) {}
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
		
	}
	//////////////////////CASE 5 //////////////////////
	// 원하는 항목 한 개만 수정하는 메서드 
	//update mymember set 수정할 컬럼명 = 수정값 where mem_id = ?
	private void updateMember2() {
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
		
		System.out.println("======================");
		System.out.println("수정하고 싶은 정보를 선택하세요.");
		System.out.println("1. 비밀번호");
		System.out.println("2. 전화번호");
		System.out.println("3. 주소");
		System.out.println("4. 이름");
		System.out.println("======================");
		
		System.out.print("정보 선택 >>");
		int select = scan.nextInt();
		String up= null;
		if (select == 1) up = "mem_pass"; 
		if (select == 2) up = "mem_tel"; 
		if (select == 3) up = "mem_addr"; 
		if (select == 4) up = "mem_name"; 
		scan.nextLine();
		System.out.println("수정할 정보 입력 >> ");
		String info = scan.nextLine();
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "update mymember set "+ up +" = ? where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, info);
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
	//메뉴를 출력하고 작업번호를 입력받아 반환하는 메서드 
	public int displayMenu() {
		System.out.println("------------------------------");
		System.out.println("1. 자료 추가");
		System.out.println("2. 자료 삭제");
		System.out.println("3. 자료 수정");
		System.out.println("4. 전체 자료 출력");
		// 원하는 항목 1개만 수정하기 
		System.out.println("5. 자료 수정 2");
		System.out.println("0. 작업 끝");
		System.out.println("------------------------------");
		
		System.out.print("메뉴 선택 >> ");
		return scan.nextInt();
	}
}
