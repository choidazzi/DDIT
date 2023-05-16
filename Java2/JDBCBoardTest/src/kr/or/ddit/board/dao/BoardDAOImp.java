package kr.or.ddit.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.util.DBUtil3;
import kr.or.ddit.board.vo.BoardVO;

public class BoardDAOImp implements IBoardDAO {
	//Singleton
	private static BoardDAOImp dao;
	
	//Singleton's Constructor
	private BoardDAOImp() {
		
	}
	// getInstance()
	public static BoardDAOImp getInstance() {
		if(dao == null) dao = new BoardDAOImp();
		return dao;
	}
	
	@Override
	public int insertBoard(BoardVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			conn = DBUtil3.getConnection();
			// 번호, 1-제목, 2-작성자, 날짜, 조회수, 3-내용 
			String sql = "insert into jdbc_board values(board_seq.nextval,?,?,sysdate,0,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) try {conn.close();} catch (SQLException e) {}
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
		}
		return cnt;
	}
	// 메인에서 보이는 목록 
	@Override
	public List<BoardVO> getAllBoard() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> boardList = null;
		BoardVO vo = null;
		
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "select * from jdbc_board";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			boardList = new ArrayList<>();
			// 번호, 제목, 작성자, 날짜, 조회수, 내용 
			while (rs.next()) {
				vo = new BoardVO();
				vo.setNo(rs.getInt("board_no"));
				vo.setTitle(rs.getString("board_title"));
				vo.setWriter(rs.getString("board_writer"));
				vo.setDate(rs.getString("board_date"));
				vo.setCnt(rs.getInt("board_cnt"));
				vo.setContent(rs.getString("board_content"));
				
				boardList.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try {conn.close();} catch(SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
		}
		return boardList;
	}

	@Override
	public BoardVO getBoard(int no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO vo = new BoardVO();
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "select * from jdbc_board where board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				vo.setNo(no);
				vo.setTitle(rs.getString("board_title"));
				vo.setWriter(rs.getString("board_writer"));
				vo.setDate(rs.getString("board_date"));
				vo.setCnt(rs.getInt("board_cnt"));
				vo.setContent(rs.getString("board_content"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try {conn.close();} catch(SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
		}
		return vo;
	}

	@Override
	public int updateBoard(BoardVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "update jdbc_board "
							+ "set board_title = ?, board_content = ?"
							+ "where board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,vo.getTitle());
			pstmt.setString(2,vo.getContent());
			pstmt.setInt(3,vo.getNo());
			
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
	public int deleteBoard(int no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "delete from jdbc_board where board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
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
	public List<BoardVO> searchBoard(String title) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> boardList = new ArrayList<>();
		try {
			conn = DBUtil3.getConnection();
			String sql = "select * from jdbc_board where board_title like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+ title +"%");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setNo(rs.getInt("board_no"));
				vo.setTitle(rs.getString("board_title"));
				vo.setWriter(rs.getString("board_writer"));
				vo.setDate(rs.getString("board_date"));
				vo.setCnt(rs.getInt("board_cnt"));
				vo.setContent(rs.getString("board_content"));
				
				boardList.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try {conn.close();} catch(SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
		}
		return boardList;
	}
	@Override
	public int increaseHits(int no) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "update jdbc_board set board_cnt = board_cnt + 1 where board_no = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
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
