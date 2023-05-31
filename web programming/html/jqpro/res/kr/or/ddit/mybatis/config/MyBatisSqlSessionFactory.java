package kr.or.ddit.mybatis.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisSqlSessionFactory {
	private static SqlSessionFactory factory;
	
	static {
		InputStream in = null;
		
		try {
			in = Resources.getResourceAsStream("kr/or/ddit/mybatis/config/mybatis-config.xml");
			factory = new SqlSessionFactoryBuilder().build(in);
			
		} catch (Exception e) {
			System.out.println("myBatis 초기화 실패!");
			e.printStackTrace();
		} finally {
			if(in != null) try {in.close();} catch (IOException e) {}
		}
	}
	
	// SqlSession객체를 반환하는 메서드 
	public static SqlSession getSqlSession() {
		return factory.openSession();
	}
}
