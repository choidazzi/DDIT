package chapter05.chapter053;

public enum Week {
	MONDAY("월요일"), 
	TUESDAY("화요일"), 
	WEDNESDAY("수요일"), 
	THURSDAY("목요일"), 
	FRIDAY("금요일"), 
	SATURDAY("토요일"),
	SUNDAY("일요일");
	//한글 변환  
	String korName;
	private Week(String name) {
		korName = name;
	}
}
enum Season{
	//상수는 모두 대문자로 표현 : command + shift + x
	//소문자 : command + shift + y
	//상수일때만 언더바 _ 사용 
	SPRING, SUMMER, FALL, WINTER, STUDENT_NAME
}
