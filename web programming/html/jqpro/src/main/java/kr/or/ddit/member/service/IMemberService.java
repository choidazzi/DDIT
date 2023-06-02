package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public interface IMemberService {
	// 아이디 중복검사 
	public String idCheck(String id);
	// 저장하기 
	public int insertMember(MemberVO vo); 
	
	// 우편번호 검색 
	public List<ZipVO> searchZip(String dong);
}
