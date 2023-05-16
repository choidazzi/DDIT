package kr.or.ddit.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.mvc.vo.MemberVO;
import kr.or.ddit.util.DBUtil3;

public class MemberDAOImpl implements IMemberDAO {

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
			pstmt.setString(1, memVO.getMemId());
			
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMemberCount(String memId) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
