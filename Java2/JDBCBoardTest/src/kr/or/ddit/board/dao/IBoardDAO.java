package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;

public interface IBoardDAO {
	
	// 새글 작성(insert)
	public int insertBoard(BoardVO vo);
	
	// 전체 게시글 보기- select   
	public List<BoardVO> getAllBoard();
	
	// 게시글 한 개만 보기 - select 
	public BoardVO getBoard(int no);
	
	// 게시글 보기 => a. 수정 
	/**
	 * key값 정보 => 수정 번호: no, 수정 제목: title, 수정 내용: content
	 * @param map
	 * @return
	 */
	public int updateBoard(BoardVO vo);
	
	// 게시글 보기 => a. 삭제  
	public int deleteBoard(int no);
	
	// 검색
	public List<BoardVO> searchBoard(String title);
	
	// 조회수 증가 
	public int increaseHits(int no);
}
