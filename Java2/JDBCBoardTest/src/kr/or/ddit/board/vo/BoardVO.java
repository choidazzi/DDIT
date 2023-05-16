package kr.or.ddit.board.vo;

public class BoardVO {
	private int no;				// 번호(자동증가)
	private String title;		// 제목 
	private String writer;		// 작성자 
	private String date;		// 작성날짜 
	private int cnt;			// 조회수 
	private String content;		// 내용 
	
	// 생성자 
	public BoardVO() {
		// TODO Auto-generated constructor stub
	}

	public BoardVO(int no, String title, String writer, String date, int cnt, String content) {
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.date = date;
		this.cnt = cnt;
		this.content = content;
	}
	
	// getter & setter
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	//toString
	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", title=" + title + ", writer=" + writer + ", date=" + date + ", cnt=" + cnt
				+ ", content=" + content + "]";
	}	
}
