package kr.or.ddit.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.PageVO;
import kr.or.ddit.mybatis.config.MyBatisSqlSessionFactory;

public class BoardDAO implements IBoardDAO{
	private static IBoardDAO dao;
	
	public static IBoardDAO getInstance() {
		if(dao == null) dao = new BoardDAO();
		return dao;
	}
	
	public BoardDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<BoardVO> listPerPage(Map<String, Object> map) {
		int count = 0;
		List<BoardVO> list = null;
		
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		
		try {
			list = session.selectList("board.listPerPage", map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return list;
	}

	@Override
	public PageVO getInfo(int page, String stype, String sword) {
		// 전체 글 개수 구하기 
		Map<String, Object> map = new HashMap<>();
		map.put("stype", stype);
		map.put("sword", sword);
		int count = this.totalCount(map);
		
		// 전체 페이지 수 구하기 
		// 전체 글 갯수/노출되는 리스트 갯수 를 올림한다.
		int totalPage = (int)Math.ceil((double)count/PageVO.getPerList());
		
		// start, end 구하기 
		// start: 페이지별 시작 항목의 인덱스 
		int start = (page-1) * PageVO.getPerList() + 1;
		int end = start + PageVO.getPerList() - 1;
		
		if(end > count) end = count;
		
		// startPage, endPage 구하기 
		// 페이지의 시작 페이지
		int perPage = PageVO.getPerPage(); //2 
		int startPage = ((page - 1) / perPage * perPage) + 1;
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
	// 전체 글 개수 구하기 
	
	@Override
	public int totalCount(Map<String, Object> map) {
		int count = 0;
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		
		try {
			count = session.selectOne("board.totalCount",map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return count;
	}
}
