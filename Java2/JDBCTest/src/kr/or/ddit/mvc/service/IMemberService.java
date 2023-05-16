package kr.or.ddit.mvc.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.mvc.vo.MemberVO;

/**
 * Service객체는 DAO에 만들어진 메서드를 원하는 작업에 맞게 호출하여 실행하고 
 * 그 결과를 받아와서 Controller에게 보내주는 역할을 한다.
 * 
 * 보통 메서드의 구조가 DAO메서드 구조와 같다. 
 *  
 * 
 * @author ChoiSeoYeon
 *
 */
public interface IMemberService {
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
	public int updateMember2(Map<String, String> paramMap);
	
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
