package vo;

public class BookVO {
	private String bookId   ;
	private String name     ;
	private int unitPrice;
	private String author   ;
	private String description;
	private String publisher;
	private String category ;
	private long unitInSto;
	private long totalPage;
	private String releaseDate;
	private String condition;
	
	public BookVO() {
		// TODO Auto-generated constructor stub
	}
	
	public BookVO(String bookId, String name, int unitPrice) {
		this.bookId = bookId;
		this.name = name;
		this.unitPrice = unitPrice;
	}
	
	public BookVO(String bookId, String name, int unitPrice, String author, String description, String publisher,
			String category, long unitInSto, long totalPage, String releaseDate, String condition) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.unitPrice = unitPrice;
		this.author = author;
		this.description = description;
		this.publisher = publisher;
		this.category = category;
		this.unitInSto = unitInSto;
		this.totalPage = totalPage;
		this.releaseDate = releaseDate;
		this.condition = condition;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public long getUnitInSto() {
		return unitInSto;
	}
	public void setUnitInSto(long unitInSto) {
		this.unitInSto = unitInSto;
	}
	public long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}
	public String getreleaseDate() {
		return releaseDate;
	}
	public void setreleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	
}
