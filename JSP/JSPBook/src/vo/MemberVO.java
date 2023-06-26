package vo;
// 자바빈 클래스 (1. 멤버변수, 2. 기본생성자(생략가능), 3.getter/setter 메서드)
public class MemberVO {
	// 멤버변수 
	private String username;
	private String password;
	private String enabled;
	
	// 기본 생성자 
	public MemberVO() {
		// TODO Auto-generated constructor stub
	}
	
	// getter, setter
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "MemberVO [username=" + username + ", password=" + password + ", enabled=" + enabled + "]";
	}
	
	
}
