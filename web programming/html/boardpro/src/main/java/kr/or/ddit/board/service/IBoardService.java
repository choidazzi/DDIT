package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.PageVO;

public interface IBoardService {
	public List<BoardVO> listPerPage(Map<String, Object> map);
	
	public int totalCount(Map<String, Object> map); 
	
	public PageVO getInfo(int page, String stype, String sword);
}
