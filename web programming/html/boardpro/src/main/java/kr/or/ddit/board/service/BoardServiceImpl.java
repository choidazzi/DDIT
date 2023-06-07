package kr.or.ddit.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.PageVO;

public class BoardServiceImpl implements IBoardService{
	// 자기 자신의 클래스 객체 선언, 생성, 리턴 
		private static IBoardDao dao;
		private static IBoardService service;
		
		public static IBoardService getInstance() {
			if(service==null) service = new BoardServiceImpl();
			
			return service;
		}
		
		public BoardServiceImpl() {
			dao = BoardDaoImpl.getInstance();
		}
	@Override
	public List<BoardVO> listPerPage(Map<String, Object> map) {
		return dao.listPerPage(map);
	}

	@Override
	public int totalCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.totalCount(map);
	}

	@Override
	public PageVO getInfo(int page, String stype, String sword) {
		// 전체 글 개수 구하기 
		Map<String, Object> map = new HashMap<>();
		map.put("stype", stype);
		map.put("sword", sword);
		int count = this.totalCount(map);
		
		// 전체 페이지 수 구하기 
		int totalPage = (int)Math.ceil((double) count / PageVO.getPerList());
		
		// start, end 구하기 
		int start = (page-1) * PageVO.getPerList() + 1;
		int end = start + PageVO.getPerList() - 1;
		
		if(end > count) end = count;
		
		// startPage, endPage 
		int perPage = PageVO.getPerPage();
		int startPage = ((page-1) / perPage * perPage) + 1;
		int endPage = startPage + perPage - 1;
		
		if(endPage > totalPage) endPage = totalPage;
		
		System.out.println("start= " + start);
		System.out.println("end= " + end);
		System.out.println("startPage= " + startPage);
		System.out.println("endPage= " + endPage);
		System.out.println("totalPage= " + totalPage);
		
		PageVO pvo = new PageVO();
		pvo.setStart(start);
		pvo.setEnd(end);
		pvo.setStartPage(startPage);
		pvo.setEndPage(endPage);
		pvo.setTotalPage(totalPage);
		
		return pvo;
	}

}
