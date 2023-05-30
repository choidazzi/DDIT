package kr.or.ddit.lprod.dao;

import java.util.List;

import kr.or.ddit.lprod.vo.LprodVO;

public interface ILprodDao {
	// lprod 리스트 
		public List<LprodVO> SelectAllLprod();
}
