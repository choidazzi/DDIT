package kr.or.ddit.buyer.service;

import java.util.List;

import kr.or.ddit.buyer.dao.BuyerDaoImpl;
import kr.or.ddit.buyer.dao.IBuyerDao;
import kr.or.ddit.buyer.vo.BuyerVO;

public class BuyerServiceImpl implements IBuyerService {

	private static IBuyerService service;
	private IBuyerDao dao;

	//dao객체를 얻어온다
	private BuyerServiceImpl() {
		dao = BuyerDaoImpl.getInstance();
	}
	
	//자기자신의 객체를 생성하고 리턴해주는 메소드
	public static IBuyerService getService() {
		
		if (service==null) {
				service = new BuyerServiceImpl();
		}
		
		return service;
	}
	
	
	@Override
	public List<BuyerVO> selectIdName() {
		//1. 리턴 결과형의 변수 선언
		List<BuyerVO> list = null;
		
		//2. dao의 메소드 실행 - 결과값을 받는다
		list = dao.selectIdName();
		
		//3. 결과값을 리턴한다
		return list;
	}

	@Override
	public BuyerVO buyerDetail(String id) {

		return dao.buyerDetail(id);
	}

}
