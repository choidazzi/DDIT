package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.board.vo.BoardVO;

public interface IBoardDAO {
	
	/**
	 * JdbcBoardVO에 담겨진 자료를 DB에 insert하는 메서드 
	 * @param vo insert할 자료가 저장된 BoardVO객체 
	 * @return 작업 성공 : 1 / 작업 실패 : 0 
	 */
	public int insertBoard(BoardVO vo);
	
	/**
	 * JDBC_Board 테이블의 전체 레코드를 가져와서 List에 담아서 반환하는 메서드 
	 * @return BoardVO객체가 저장된 List객체 
	 */
	public List<BoardVO> getAllBoard();
	
	/**
	 * 게시글 번호를 매개변수로 받아서 해당 게시글 정보를 가져와 반환하는 메서드 
	 * @param no 가져올 게시글 번호 
	 * @return 해당 개시글 번호에 맞는 데이터가 저장된 BoardVO객체 (단, 검색 자료가 없으면 null으로 반환한다.)
	 */
	public BoardVO getBoard(int no);
	
	 
	/**
	 * 수정할 정보가 저장된 BoardVO 객체를 매개변수로 받아서 수정하는 메서드 
	 * @param vo 수정할 정보가 저장된 BoardVO객체 
	 * @return 작업 성공 : 1 / 작업 실패 : 0 
	 */
	public int updateBoard(BoardVO vo);
	
	/**
	 * 게시글 번호를 매개변수로 받아서 해당 게시글을 삭제하는 메서드 
	 * @param no 삭제할 게시글 번호 
	 * @return 작업 성공 : 1 / 작업 실패 : 0 
	 */
	public int deleteBoard(int no);
	
	/**
	 * 게시글의 제목을 이용하여 검색한 결과를 List에 담아서 반환하는 메서드 
	 * @param title 검색할 게시글 제목 
	 * @return 검색된 결과가 저장된 List 객체 
	 */
	public List<BoardVO> searchBoard(String title);
	
	/**
	 * 게시글 번호를 매개변수로 받아서 해당 게시글의 조회수를 증가시키는 메서드 
	 * @param no 조회수를 증가할 게시글 번호 
	 * @return
	 */
	public int increaseHits(int no);
}
