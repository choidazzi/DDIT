package kr.or.ddit.buyer.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.buyer.vo.BuyerVO;
import kr.or.ddit.mybatis.config.MyBatisSqlSessionFactory;

public class BuyerDaoImpl implements IBuyerDao {

	private static IBuyerDao dao;
	
	//자기자신의 객체를 생성하고 리턴
	public static IBuyerDao getInstance() {
		
		if(dao == null) {
			dao = new BuyerDaoImpl();
		}
		
		return dao;
	}
	
	//SqlSession이 필요
	
	
	@Override
	public List<BuyerVO> selectIdName() {
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();

		List<BuyerVO> list = null;
		try {
			list = sqlSession.selectList("buyer.selectIdName");
			
			//sqlSession으로 mapper수행
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
		
		return list;
	}

	@Override
	public BuyerVO buyerDetail(String id) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();

		BuyerVO vo = null;
		try {
			
			//sqlSession으로 mapper수행
			vo = sqlSession.selectOne("buyer.buyerDetail", id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
		
		// TODO Auto-generated method stub
		return vo;
	}

}
