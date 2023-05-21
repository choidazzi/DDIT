package kr.or.ddit.basic;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.ddit.util.MyBatisSqlSessionFactory;
import kr.or.ddit.vo.LprodVO;

public class JdbcToMyBatis {
	//JDBC예제 중 05.java를 myBatis용으로 변환하시오.
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//===============================================
/*		
		InputStream in = null;
		SqlSessionFactory sqlSessionFactory = null;
		//===============================================
		
		try {
			in = Resources.getResourceAsStream("kr/or/ddit/mybatis/config/mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
			
			
		} catch (Exception e) {
			System.out.println("myBatis 초기화 실패!");
			e.printStackTrace();
		} finally {
			if(in != null) try {in.close();} catch (IOException e) {}
		}
*/		
		SqlSession session = null;
		try {
			session =MyBatisSqlSessionFactory.getSqlSession();
			//lprod_id는 현재의 lprod_id 중에서 제일 큰 값보다 1크게 한다. 
			int maxNum = session.selectOne("jdbc.getMaxId");
			maxNum++;
			
			//입력 받은 lprod_id가 이미 등록되어 있으면 다시 입력받아서 처리한다. 
			String gu;
			int count = 0;
			do {
				System.out.print("lprod_gu(상품 분류 코드) 입력 >>");
				gu = scan.next();
				
				count = session.selectOne("jdbc.getLprodCount",gu);
				
				if (count > 0) {
					System.out.println(gu + "는 이미 등록된 코드입니다. 다시 입력해주세요...");
				}
			} while (count > 0 );
			System.out.print("lprod_nm(상품 분류 이름) 입력 >>");
			String nm = scan.next();
			
			// 입력된 데이터들을 VO객체에 저장한다. 
			LprodVO lvo = new LprodVO();
			lvo.setLprod_id(maxNum);
			lvo.setLprod_gu(gu);
			lvo.setLprod_nm(nm);
			
			int cnt = session.insert("jdbc.insertLprod",lvo);
			if (cnt > 0) {
				System.out.println(gu + "등록 성공!");
				session.commit();
			} else {
				System.out.println(gu + "등록 실패!");				
			}
		} finally {
			if (session != null) session.close(); 
		}
	}//main 끝 
}
