package kr.or.ddit.basic.session;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.basic.util.MyBatisSqlSessionFactory;
import kr.or.ddit.vo.MemberVO;

public class MemberDaoImpl {
	private static MemberDaoImpl dao;
	
	private MemberDaoImpl() {}
	
	public static MemberDaoImpl getInstance() {
		if(dao == null) dao = new MemberDaoImpl();
		return dao;
	}
	
	/**
	 * 회원 ID 와 패스워드가 저장된 MemberVO객체를 인수값으로 받아서 
	 * 해당 회원을 검색하여 반환하는 메서드 
	 * 
	 * @param vo 검색할 회원 ID와 패스워드가 저장된 MemberVO객체 
	 * @return 검색된 회원정보가 저장된 MemberVO객체 (검색자료 없으면 null 반환)
	 */
	public MemberVO getLoginMember(MemberVO vo) {
		MemberVO loginMemberVo = null;	// 반환값이 저장될 변수
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
			
			loginMemberVo = session.selectOne("mymember.getLoginMember", vo);
			
		} finally {
			// TODO: handle finally clause
			if (session != null) session.close();
		}
		return loginMemberVo;
	}
}
