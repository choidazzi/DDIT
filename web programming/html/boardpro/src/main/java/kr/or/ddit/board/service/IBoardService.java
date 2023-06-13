package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.PageVO;
import kr.or.ddit.board.vo.ReplyVO;

public interface IBoardService {
	// 페이지별 리스트 가져오기 
	public List<BoardVO> listPerPage(Map<String, Object> map);
	// 글 갯수 
	public int totalCount(Map<String, Object> map); 
	//글쓰기 - 저장하기 
	public int insertBoard(BoardVO vo);
	// 페이지 정보 얻기 
	public PageVO getInfo(int page, String stype, String sword);
	public int updateBoard(BoardVO vo);
	public int deleteBoard(int num);
	public int updateHit(int num);
	
	// 댓글 수정 
	public int updateReply(ReplyVO vo);
	
	// 댓글 삭제 
	public int deleteReply(int renum);
	
	// 댓글 쓰기 - 저장 
	public int insertReply(ReplyVO vo);
	
	// 댓글 리스트 
	public List<ReplyVO> listReply(int num);
}
