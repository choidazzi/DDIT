package kr.or.ddit.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mvc.vo.MemberVO;
import kr.or.ddit.util.MyBatisSqlSessionFactory;

public class MemberDAOImpl implements IMemberDAO {
	// Singleton
	private static MemberDAOImpl dao;
	
	private MemberDAOImpl() {
		
	}
	
	public static MemberDAOImpl getInstance() {
		if (dao == null) dao = new MemberDAOImpl();
		return dao;
	}
	
	
	@Override
	public int insertMember(MemberVO memVO) {
		int cnt = 0;
		//sesison
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
			cnt = session.insert("member.insertMember",memVO);
			if (cnt > 0) {
				System.out.println("insert 성공!");
				session.commit();
			} else {
				System.out.println("insert 실패!");
			}
		} finally {
			if(session!=null) session.close();
		}
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		int cnt = 0;									
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
			cnt = session.delete("member.deleteMember", memId);
			if (cnt > 0) {
				System.out.println("delete 성공!");
				session.commit();
			} else {
				System.out.println("delete 실패!");
			}
		} finally {
			if(session!=null) session.close();
		}
		return cnt;
	}


	@Override
	public int updateMember(MemberVO memVO) {
		int cnt = 0;									
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
			cnt = session.update("member.updateMember", memVO);
			if (cnt > 0) {
				System.out.println("update 성공!");
				session.commit();
			} else {
				System.out.println("update 실패!");
			}
		} finally {
			if(session!=null) session.close();
		}
		return cnt;
	}
	
	@Override
	public List<MemberVO> getAllMemeber() {
		List<MemberVO> memList = null;
		int cnt = 0;									
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
			memList = session.selectList("member.getAllMember");
			
		} finally {
			if(session!=null) session.close();
		}
		return memList;
	
	}

	@Override
	public int getMemberCount(String memId) {
		int count = 0;
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
			count = session.selectOne("member.getMemberCount", memId);
		} finally {
			if(session!=null) session.close();
		}
		return count;
	}

	@Override
	public int updateMember2(Map<String, String> paramMap) {
		int cnt = 0;
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
			
			cnt=session.update("member.updateMember2",paramMap);
			if (cnt > 0) {
				System.out.println("update 성공!");
				session.commit();
			} else {
				System.out.println("update 실패!");
			}
		} finally {
			if(session!=null) session.close();
		}
		return cnt;
	}
}
