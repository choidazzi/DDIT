package kr.or.ddit.mvc.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.mvc.dao.IMemberDAO;
import kr.or.ddit.mvc.dao.MemberDAOImpl;
import kr.or.ddit.mvc.vo.MemberVO;

public class MemberServiceImpl implements IMemberService{
	// Singleton
	// 1.
	private static MemberServiceImpl service;
	
	// DAO객체가 저장될 변수 선언 
	private IMemberDAO dao;
	
	// 2. 생성자 
	private MemberServiceImpl() {
		// DAO 객체 생성 
		dao = MemberDAOImpl.getInstance();
	}
	// 3. 
	public static MemberServiceImpl getInstance() {
		if (service == null)
			service = new MemberServiceImpl();
		return service;
	}
	@Override
	public int insertMember(MemberVO memVO) {
		return dao.insertMember(memVO);
	}

	@Override
	public int deleteMember(String memId) {
		// TODO Auto-generated method stub
		return dao.deleteMember(memId); 
	}

	@Override
	public int updateMember(MemberVO memVO) {
		return dao.updateMember(memVO);
	}

	@Override
	public List<MemberVO> getAllMemeber() {
		return dao.getAllMemeber();
	}

	@Override
	public int getMemberCount(String memId) {
		return dao.getMemberCount(memId);
	}

	@Override
	public int updateMember2(Map<String, String> paramMap) {
		return dao.updateMember2(paramMap);
	}

	

}
