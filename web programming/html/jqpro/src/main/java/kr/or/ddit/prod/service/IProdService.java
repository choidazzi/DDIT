package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.prod.vo.ProdVO;

public interface IProdService {
	// prod_id , prod_nm 을 출력
	// select prod_id, prod_name from prod where prod_lgu = #{lprod_gu}
	public List<ProdVO> ProdByLgu(String lprod_gu);
	
	
	//select * from prod where prod_id = #{lprod_id}
	public ProdVO ProdById(String lprod_id);
}
