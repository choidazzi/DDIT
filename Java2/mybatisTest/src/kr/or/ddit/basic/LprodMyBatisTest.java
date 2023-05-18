package kr.or.ddit.basic;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.ddit.vo.LprodVO;

public class LprodMyBatisTest {
	// myBatis를 이용하여 DB자료를 처리하는 순서 및 방법 
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// 1. myBatis의 환경설정파일 (mybatis-config.xml)을 읽어와서 실행한다.
		InputStream in = null;
		SqlSessionFactory sqlSessionFactory = null;
		try {
			// 1-1. 환경 설정 파일을 읽어 올 스트림 객체 생성 
			in = Resources.getResourceAsStream("kr/or/ddit/mybatis/config/mybatis-config.xml");
			
			// 1-2. 환경 설정 파일을 읽어와 환경 설정을 완성한 후 SQL문을 호출해서 실행할 수  있는 객체를 
			//		생성할 수 있는 SqlSessionFactory 객체를 생성한다.
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		} catch (Exception e) {
			System.out.println("myBatis 초기화 실패");
			e.printStackTrace();
		} finally {
			if(in!=null)try {in.close();} catch (Exception e2) {}
		}
		//------------------환경 설정 과정---------------------------------------
/*		
		// 2. mapper에 등록된 SQL문들 중 실해할 SQL문을 호출해서 원하는 작업을 수행한다.
		// 2-1. insertdustmq 
		System.out.println("insert 작업 시작...");
		
		System.out.println("LProd_id입력 : ");
		int lprodId = scan.nextInt();

		System.out.println("LProd_gu입력 : ");
		String lprodGu = scan.next();
		
		System.out.println("LProd_nm입력 : ");
		String lprodNm = scan.next();
		
		// 입력한 데이터를 VO 객체에 저장한다.
		LprodVO lvo1 = new LprodVO();
		lvo1.setLprod_id(lprodId);
		lvo1.setLprod_gu(lprodGu);
		lvo1.setLprod_nm(lprodNm);
		
		SqlSession session = null;		//SqlSession 객체 변수 선언 
		try {
			// SqlSessionFactory 객체를 이용하여 SqlSession객체를 구한다. 
			// => openSession() 메서드를 이용한다.
			// 형식) SqlSessionFactory객체.openSession(논리값) 
			//		'논리값'이 true이면 AutoCommit이 활성화된 상태이고 
			//		'논리값'이 생략되거나 false이면 AutoCommit이 비활성화된 상태이다. 
			session = sqlSessionFactory.openSession();
			
			// SqlSession객체를 이용하여 처리할 SQL문을 호출하여 실행한다. 
			// 형식) SqlSession객체.insert("namespace속성값.id속성값", parameter 클래스)
			//		반환값: 작업에 성공한 레코드 수 
			//int insertCnt = session.insert("lprod.insertLprod1", lvo1);
			int insertCnt = session.insert("lprod.insertLprod2", lvo1);
			if (insertCnt>0) {
				System.out.println("insert 작업 성공!");
				// SqlSession객체를 생성할 때 AutoCommit 이 비활성화된 상태일 때에는 
				// commit을 직접 실행해야 한다. 
				session.commit();
			} else {
				System.out.println("insert 작업 실패!");
			}
		} finally {
			if(session!=null) session.close();
		}
 */
/*
		//-------------------------------------------------------------------------
		// 2-2. update 연습 
		System.out.println("update 작업 시작...");
		System.out.print("수정할 Lprod_gu 입력 : ");
		String lprodGu2 = scan.next();
		System.out.print("새로운 Lprod_id 입력 : ");
		int lprodId2 = scan.nextInt();
		System.out.print("새로운 Lprod_nm 입력 : ");
		String lprodNm2 = scan.next();
		
		// 입력한 데이터를 VO에 저장하기 
		LprodVO lvo2 = new LprodVO();
		lvo2.setLprod_gu(lprodGu2);
		lvo2.setLprod_id(lprodId2);
		lvo2.setLprod_nm(lprodNm2);
		
		SqlSession session = null;
		try {
			// SqlSession객체 생성 
			session = sqlSessionFactory.openSession();
			
			// SqlSession객체의 업데이트 메서드를 이용해서 수정작업을 수행한다.
			// 형식) SqlSession객체.update("namespace속성값.id속성값", parameter클래스)
			// 		반환값: 작업에 성공한 레코드 수 
			int updateCnt = session.update("lprod.updateLprod",lvo2);
			
			if (updateCnt > 0) {
				System.out.println("update 작업 성공!");
				session.commit();
			} else {
				System.out.println("update 작업 실패!");
			}
		} finally {
			if (session!=null) session.close();
		}
*/
/*
		//----------------------------------------------------------------
		// 2-3. delete 작업
		System.out.println("delete 작업 시작...");
		System.out.print("삭제할 Lprod_gu 입력 : ");
		String lprodGu3 = scan.next();
		
		SqlSession session = null;
		try {
			// SqlSession 객체 생성 
			session = sqlSessionFactory.openSession();
			
			// SqlSession 객체의 delete() 메서드를 이용해서 삭제한다.
			// 형식) SqlSession객체.delete("namespace속성값.id속성값", parameter클래스)
			//		반환값: 작업에 성공한 레코드 수 
			int deleteCnt = session.delete("lprod.deleteLprod",lprodGu3);
			
			if (deleteCnt > 0) {
				System.out.println("delete 작업 성공!");
				session.commit();
			} else {
				System.out.println("delete 작업 실패!");
			}
		} finally {
			if (session!=null) session.close();
		}
*/
		/*
		//------------------------------------------------------------------------
		// 2-4. select 연습 
		// 1) 응답 결과가 여러개인 경ㅇ 
		SqlSession session = null;
		try {
			// SqlSession객체 생성 
			session = sqlSessionFactory.openSession();
			
			//응답 결과가 여러개일 경우 selectList()메서드를 사용하는데 이 메서드는
			// 여러개의 레코드 각각을 VO객체에 담은 후 이 VO데이터를 List에 추가해주는 작업을 자동으로 수행한다.
			// 형식: SqlSession객체.selecList("namespace속성값.id속성값", parameter 클래스)
			
			List<LprodVO> lprodList = session.selectList("lprod.getAllLprod");
		      
			for(LprodVO lvo3  : lprodList) {
		            System.out.println("ID : " + lvo3.getLprod_id());
		            System.out.println("GU : " + lvo3.getLprod_gu());
		            System.out.println("NM : " + lvo3.getLprod_nm());
		            System.out.println("----------------------------");
		         }
		} finally {
			if (session!=null) session.close();
		}
		*/
		
		// 2) 응답 결과가 1개인 경우 
		System.out.println("select 작업 시작 -- 응답결과가 1개인 경우....");
		System.out.print("검색할 Lprod_gu 입력:");
		String lprodGu4 = scan.next();
		
		SqlSession session = null;
		try {
			//SqlSession 객체 생성 
			session = sqlSessionFactory.openSession();
			
			//응답 결과가 1개일 경우에는 selectOne()메서드를 사용한다. 
			// 형식) SqlSession객체.selectOne("namespace속성값.id속성값", parameter 클래스")
			//		반환값: resultType속성에 지정한 데이터가 반환 
			//				검색한 데이터가 하나도 없으면 null을 반환한다.
			LprodVO lvo5 = session.selectOne("lprod.getLprod",lprodGu4);
			if (lvo5 == null) {
				System.out.println("검색한 데이터가 하나도 없습니다.");
			} else {
				System.out.println("검색 결과");
	            System.out.println("ID : " + lvo5.getLprod_id());
	            System.out.println("GU : " + lvo5.getLprod_gu());
	            System.out.println("NM : " + lvo5.getLprod_nm());
	            System.out.println("----------------------------");   
			}
		} finally {
			if (session!=null) session.close();
		}
	}
}
