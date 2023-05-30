package kr.or.ddit.prod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.config.MyBatisSqlSessionFactory;
import kr.or.ddit.prod.vo.ProdVO;

public class ProdDaoImpl implements IProdDao{
	// 자기 자신의 객체를 생성하여 리턴 
	// type은 ProdDaoImpl / IProdDao 모두 가능 ==> 1 대 1일 때 (여러 개 상속받는 경우 불가능)
	private static IProdDao dao;
	
	public static IProdDao getInstance() {
		if(dao == null) dao = new ProdDaoImpl();
		
		return dao;
	}

	@Override
	public List<ProdVO> ProdByLgu(String lprod_gu) {
		// sqlSession 생성 
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
		// 리턴 타입 변수 선언
		List<ProdVO> prodList = null;
		// mapper 실행 
		try {
			prodList = sqlSession.selectList("prod.ProdByLgu",lprod_gu);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.commit(); // 필수 아님 
			sqlSession.close();
		}
		return prodList;
	}

	@Override
	public ProdVO ProdById(String lprod_id) {
		// sqlSession 생성 
				SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
				// 리턴 타입 변수 선언
				ProdVO vo = null;
				// mapper 실행 
				try {
					vo = sqlSession.selectOne("prod.ProdById",lprod_id);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					sqlSession.commit(); // 필수 아님 
					sqlSession.close();
				}
				return vo;
	}

}
