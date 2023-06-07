package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.PageVO;
import kr.or.ddit.mybatis.config.MyBatisSqlSessionFactory;

public class BoardDaoImpl implements IBoardDao{
	// 자기 자신의 클래스 객체 선언, 생성, 리턴 
	private static IBoardDao dao;
	
	public static IBoardDao getInstance() {
		if(dao==null) dao = new BoardDaoImpl();
		
		return dao;
	}
	
	public BoardDaoImpl() {}

	@Override
	public List<BoardVO> listPerPage(Map<String, Object> map) {
		
		// 1. 리턴 변수 선언
		int count = 0;
		List<BoardVO> list = null;
		
		// 2. list = mapper 실행
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		
		try {
			list = session.selectList("board.listPerPage", map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		// 3. 결과 리턴  
		return list;
	}

	@Override
	public int totalCount(Map<String, Object> map) {
		// 1. 리턴 변수 선언
		int count = 0;
		
		// 2. list = mapper 실행
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		
		try {
			count = session.selectOne("board.totalCount", map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		// 3. 결과 리턴  
		return count;
	}

}
