package kr.or.ddit.lprod.service;

import java.util.List;

import kr.or.ddit.lprod.vo.LprodVO;

public interface ILprodService {
	// lprod 리스트 
	public List<LprodVO> SelectAllLprod();
}
