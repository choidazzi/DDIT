package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDAOImp;
import kr.or.ddit.board.dao.IBoardDAO;
import kr.or.ddit.board.vo.BoardVO;

public class BoardService implements IBoardService {
	// Singleton
	private static BoardService service;
	
	private IBoardDAO dao;
	
	
	// Constructor
	private BoardService() {
		dao = BoardDAOImp.getInstance();
	}
	
	public static BoardService getInstance() {
		if (service == null) 
			service = new BoardService();
		return service;
	}
	
	@Override
	public int insertBoard(BoardVO vo) {
		return dao.insertBoard(vo);
	}

	@Override
	public List<BoardVO> getAllBoard() {
		return dao.getAllBoard();
	}

	@Override
	public BoardVO getBoard(int no) {
		return dao.getBoard(no);
	}

	@Override
	public int updateBoard(BoardVO vo) {
		return dao.updateBoard(vo);
	}

	@Override
	public int deleteBoard(int no) {
		return dao.deleteBoard(no);
	}

	@Override
	public List<BoardVO> searchBoard(String title) {
		return dao.searchBoard(title);
	}

	@Override
	public int increaseHits(int no) {
		return dao.increaseHits(no);
	}

}
