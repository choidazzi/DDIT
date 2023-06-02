package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;
import kr.or.ddit.mybatis.config.MyBatisSqlSessionFactory;

public class MemberDaoImpl implements IMemberDao{
	
	private static MemberDaoImpl dao;
	
	public static IMemberDao getInstance() {
		if(dao == null) dao = new MemberDaoImpl();
		return dao;
	}
	
	@Override
	public String idCheck(String id) {
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		
		String res = null;
		try {
			res = session.selectOne("member.idCheck",id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return res;
	}

	@Override
	public int insertMember(MemberVO vo) {
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();

		int cnt = 0;
		try {
			cnt = session.insert("member.insertMember", vo);
			if (cnt>0) {
				session.commit();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public List<ZipVO> searchZip(String dong) {
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();

		List<ZipVO> zipList = null;
		try {
			zipList = session.selectList("member.searchZip",dong);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return zipList;
	}

}
