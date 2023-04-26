package Exercise.Exercise230402.book;

public abstract class Book {
	private int number; //관리번호 
	private String title; //책의 제목 
	private String author; // 책의 저자
	private static int countOfBooks = 0; //만들어진 Book객체 개수
	
	//Constructor 
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
		number = countOfBooks;
		countOfBooks++;
	}

	//Method 
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public abstract int getLateFee(int lateDays); //연체료 
	
	@Override
	public int hashCode() {
		return 0;
	}

	/*
	 * 객체 해시코드란 객체를 식별하는 하나의 정수값을 말한다. Object의 hashCode() 메소드는 객체의 메모리 번지를 이용해서
	 * 해시코드를 만들어 리턴하기 때문에 객체 마다 다른 값을 가지고 있다. hashCode()
	 * 
	 * 메소드를 실행해서 리턴된 해시코드 값이 같은지를 본다. 해시 코드값이 다르면 다른 객체로 판단하고, 해시 코드값이 같으면
	 * 
	 * equals()
	 * 
	 * 메소드로 다시 비교한다. 이 두 개가 모두 맞아야 동등 객체로 판단한다. 즉, 해시코드 값이 다른 엔트리끼리는 동치성 비교를 시도조차 하지
	 * 않는다.
	 */
	@Override
	public boolean equals(Object obj) { //데이터 타입이 Object인 obj 값을 받는 equals 메서드
		if (this.title.equals(((Book) obj).title) 
			&& this.author.equals(((Book) obj).author)) { //obj 를 Book으로 Casting 
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return String.format("관리번호:%d, 제목: %s, 작가: %s, (일주일 연체료: %,d원)",number, title, author, getLateFee(7)); //일주일
	}
}
