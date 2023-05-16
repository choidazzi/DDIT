package kr.or.ddit.mvc.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.mvc.vo.MemberVO;

/**
 * 실제 DB와 연결해서 SQL문을 수행하여 결과를 Service에 전달하는 DAO의 interface
 * 
 * 메서드 하나가 DB와 관련된 작업 1개를 수행하도록 작성한다.
 * 
 * @author ChoiSeoYeon
 */
public interface IMemberDAO {
	// int cnt로 return
	/**
	 * MemberVO객체에 담겨진 자료를 DB에 insert하는 메서드
	 *  
	 * @param memVO DB에 insert할 자료가 저장된 MemberVO객체 
	 * @return 작업 성공: 1 / 작업 실패: 0
	 */
	public int insertMember(MemberVO memVO);
	
	/**
	 * 회원 ID를 매개변수호 받아서 해당 회원 정보를 삭제하는 메서드
	 *  
	 * @param memId 삭제할 회원 ID 
	 * @return 작업 성공: 1 / 작업 실패: 0
	 */
	public int deleteMember(String memId);
	
	/**
	 * MemberVO객체에 저장된 자료를 이용하여 DB에 update하는 메서드 
	 * 
	 * @param memVO update할 회원 정보가 저장된 MemberVO객체 
	 * @return 작업 성공: 1 / 작업 실패: 0
	 */
	public int updateMember(MemberVO memVO);
	
	/**
	 * 원하는 항목만 수정할 수 있는 데이터를 Map으로 받아서 수정작업을 수행하는 메서드 
	 * 			key값 정보 => 회원ID(memid), 수정할 컬럼명(field), 수정할 데이터(data)
	 * 			
	 * @param paramMap 수정할 정보가 저장된 Map객체 
	 * @return 작업성공 : 1, 작업 실패 : 0
	 */
	public int updateMember2(Map<String,String> paramMap);
	
	/**
	 * DB의 전체 회원 정보를 가져와서 List에 담아 반환하는 메서드 
	 * @return MemberVO 객체가 저장된 List객체 
	 */
	public List<MemberVO> getAllMemeber(); 
	
	/**
	 * 회원 ID를 매개변수로 받아서 해당 회원ID의 개수를 반환하는 메서드
	 *  
	 * @param memId 검색할 회원ID
	 * @return 검색된 회원ID의 갯수 
	 */
	public int getMemberCount(String memId);
}
