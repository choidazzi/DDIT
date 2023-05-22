package kr.or.ddit.mvc.vo;

/*
 * DB테이블에 있는 컬럼을 기준으로 데이터를 객체화한 클래스 
 * 
 * DB테이블의 '컬럼명'이 클래스의 '멤버변수명'이 된다.
 * DB테이블의 컬럼과 클래스의 멤버변수를 매핑하는 역할을 수행한다.  
 */
public class MemberVO {
	private String memId;
	private String memPass;
	private String memName;
	private String memTel;
	private String memAddr;
	
	// VO클래스에서 별도의 생성자를 만들 경우에는 기본 생성자도 반드시 같이 만들어 준다.
	public MemberVO() {
		
	}
	
	public MemberVO(String memId, String memPass, String memName, String memTel, String memAddr) {
		this.memId = memId;
		this.memPass = memPass;
		this.memName = memName;
		this.memTel = memTel;
		this.memAddr = memAddr;
	}
	
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPass() {
		return memPass;
	}
	public void setMemPass(String memPass) {
		this.memPass = memPass;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemTel() {
		return memTel;
	}
	public void setMemTel(String memTel) {
		this.memTel = memTel;
	}
	public String getMemAddr() {
		return memAddr;
	}
	public void setMemAddr(String memAddr) {
		this.memAddr = memAddr;
	}
	
	@Override
	public String toString() {
		return "MemberVO [memId=" + memId + ", memPass=" + memPass + ", memName=" + memName + ", memTel=" + memTel
				+ ", memAddr=" + memAddr + "]";
	}
}
