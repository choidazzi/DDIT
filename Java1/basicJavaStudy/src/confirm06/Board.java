package confirm06;

public class Board {
	String title;
	String content;
	String writer;
	String date;
	int hitcount;
	
	public Board(String title, String content) {
		this(title, content, null, null, 0);
	}
	public Board(String title, String content, String writer) {
		this(title, content, writer, null, 0);
	}
	public Board(String title, String content, String writer, String date) {
		this(title, content, writer, date, 0);
	}
	public Board(String title, String content, String writer, String date, int h) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.date = date;
		this.hitcount = h; //다른 이름으로 저장할 수 있음. 
	}
	
	public static void main(String[] args) {
		Board board1 = new Board(null,null);
		Board board2 = new Board(null,null,null);
		Board board3 = new Board(null,null,null,null);
		Board board4 = new Board(null,null,null,null, 0);
	}
}
