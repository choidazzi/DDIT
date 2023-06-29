package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDAO;
import kr.or.ddit.board.dao.IBoardDAO;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.PageVO;

public class BoardService implements IBoardService{
	private static IBoardDAO dao;
	private static IBoardService service;
	
	public static IBoardService getInstance() {
		if(service == null) service = new BoardService();
		
		return service;
	}
	public BoardService() {
		dao = BoardDAO.getInstance();
	}
	
	@Override
	public List<BoardVO> listPerPage(Map<String, Object> map) {
		return dao.listPerPage(map);
	}
	@Override
	public PageVO getInfo(int page, String stype, String sword) {
		return dao.getInfo(page, stype, sword);
	}
	@Override
	public int totalCount(Map<String, Object> map) {
		return dao.totalCount(map);
	}

}
