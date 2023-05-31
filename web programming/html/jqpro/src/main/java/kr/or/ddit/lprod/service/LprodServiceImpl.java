package kr.or.ddit.lprod.service;

import java.util.List;

import kr.or.ddit.lprod.dao.ILprodDao;
import kr.or.ddit.lprod.dao.LprodDaoImpl;
import kr.or.ddit.lprod.vo.LprodVO;

public class LprodServiceImpl implements ILprodService {
	private ILprodDao dao;
	
	private static ILprodService service;
	
	public static ILprodService getInstance() {
		if(service == null) service = new LprodServiceImpl();
		
		return service;
	}
	
	private LprodServiceImpl() {
		dao = LprodDaoImpl.getInstance();
	}
	@Override
	public List<LprodVO> SelectAllLprod() {
		
		return dao.SelectAllLprod();
	}

}
