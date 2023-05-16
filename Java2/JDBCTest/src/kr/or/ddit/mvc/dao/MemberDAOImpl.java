package kr.or.ddit.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.or.ddit.mvc.vo.MemberVO;
import kr.or.ddit.util.DBUtil3;

public class MemberDAOImpl implements IMemberDAO {
	// 1변 - 자신 Class의 참조값이 저장될 변수를 private static으로 선언 
	private static MemberDAOImpl dao;
	
	// 2번 - 모든 생성자의 접근 제한자를 private으로 한다. 
	private MemberDAOImpl() {
		
	}
	
	// 3번 - 자신 Class의 인스턴스를 생성하고 반환하는 메서드를 public static으로 작성한다.
	public static MemberDAOImpl getInstance() {
		if (dao == null) dao = new MemberDAOImpl();
		return dao;
	}
	
	@Override
	public int insertMember(MemberVO memVO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;									// 반환값이 저장될 변수 선언 
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "insert into mymember values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memVO.getMemId());
			pstmt.setString(2, memVO.getMemPass());
			pstmt.setString(3, memVO.getMemName());
			pstmt.setString(4, memVO.getMemTel());
			pstmt.setString(5, memVO.getMemAddr());
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) try {conn.close();} catch (SQLException e) {}
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
		}
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;									// 반환값이 저장될 변수 선언 
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "delete from mymember where mem_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) try {conn.close();} catch (SQLException e) {}
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
		}
		
		return cnt;
	}

	@Override
	public int updateMember(MemberVO memVO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;									// 반환값이 저장될 변수 선언 
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "update mymember set mem_pass=?,mem_name=?,"
								+ "mem_tel=?,mem_addr=?"
								+ "where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memVO.getMemPass());
			pstmt.setString(2, memVO.getMemName());
			pstmt.setString(3, memVO.getMemTel());
			pstmt.setString(4, memVO.getMemAddr());
			pstmt.setString(5, memVO.getMemId());
			
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) try {conn.close();} catch (SQLException e) {}
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
		}
		
		return cnt;
	}
	
	@Override
	public List<MemberVO> getAllMemeber() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberVO> memList = null;
		MemberVO memVO = null;
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "select * from mymember";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			memList = new ArrayList<>();	// List 객체 생성 
			while (rs.next()) {
				memVO = new MemberVO();
				// 한 레코드의 내용을 VO객체에 저장한다. 
				memVO.setMemId(rs.getString("mem_id"));
				memVO.setMemPass(rs.getString("mem_pass"));
				memVO.setMemName(rs.getString("mem_name"));
				memVO.setMemTel(rs.getString("mem_tel"));
				memVO.setMemAddr(rs.getString("mem_addr"));
				
				// 데이터에 저장된 VO객체를 List에 추가한다.
				memList.add(memVO);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try {conn.close();} catch(SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
		}
		return memList;
	}

	@Override
	public int getMemberCount(String memId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;		// 반환값이 저장될 변수 
		try {
			conn = DBUtil3.getConnection();
			String sql = "select count(*) cnt from mymember where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);		
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				count = rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try {conn.close();} catch(SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
		}
		return count;
	}

	@Override
	public int updateMember2(Map<String, String> paramMap) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;	// 반환값이 저장될 변수 
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "update mymember set "+ paramMap.get("field") +"=? where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramMap.get("data"));
			pstmt.setString(2, paramMap.get("memid"));
			
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) try {conn.close();} catch (SQLException e) {}
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
		}
		return cnt;
	}
	
}
