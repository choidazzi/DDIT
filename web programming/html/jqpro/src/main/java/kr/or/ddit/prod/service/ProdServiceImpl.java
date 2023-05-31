package kr.or.ddit.prod.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.config.MyBatisSqlSessionFactory;
import kr.or.ddit.prod.dao.IProdDao;
import kr.or.ddit.prod.dao.ProdDaoImpl;
import kr.or.ddit.prod.vo.ProdVO;

public class ProdServiceImpl implements IProdService {
	
	// dao객체 필요 
	private IProdDao dao;
	// 자기자신의 객체를 생성하여 return 
	private static IProdService service;
	
	public static IProdService getInstance() {
		if(service == null) service = new ProdServiceImpl();
		
		return service;
	}
	// Contructor 
	private ProdServiceImpl() {
		dao = ProdDaoImpl.getInstance();
	}
	
	@Override
	public List<ProdVO> ProdByLgu(String lprod_gu) {
		/*
		// 리턴타입 변수 선언 
		List<ProdVO> prodList = null;
		// dao 메소드 실행 
		prodList = dao.ProdByLgu(lprod_gu); 		
		//리턴 결과 
		return prodList;
		*/
		
		return dao.ProdByLgu(lprod_gu); 
	}

	@Override
	public ProdVO ProdById(String lprod_id) {
		/*
		ProdVO vo = null;
		vo = dao.ProdById(lprod_id);
		return vo;
		*/
		
		return dao.ProdById(lprod_id);
	}

}
