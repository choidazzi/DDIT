package dao;

import java.util.ArrayList;
import java.util.List;

import vo.BookVO;

public class BookRepository {
	private List<BookVO> listOfBooks = new ArrayList<>();
	
	private static BookRepository instance = new BookRepository();
	public static BookRepository getInstance() {return instance;}
	public BookRepository() {
		BookVO book1 = new BookVO("A0001","워터 멜론 슈가에서",16800,"리처드 브라우티건",
				"일곱 가지 태양이 뜨는 워터멜론 슈가 마을\n"
				+ "〈미국의 송어낚시〉의 저자 리처드 브라우티건의 소설. 일주일 동안 날마다 다른 색깔이 빛나는 태양을 가진 워터멜론 슈가 마을을 배경으로, 자연과 문명, 인간과 사회의 대립 속에서 미국인들의 이상에 대해 섬세하고 매혹적으로 그리고 있다.\n"
				+ "\n"
				+ "워터멜론 슈가 마을, 이곳에서는 일주일 동안 날마다 다른 색깔의 태양이 빛난다. 그리고 그 색깔의 햇살을 먹고 자라는 일곱 가지 색깔의 워터멜론들이 있다. 사람들은 이 워터멜론 즙을 끓여서 얻은 워터멜론 슈가로 자신들이 원하는 물건을 만든다.\n"
				+ "\n"
				+ "이 마을에서는 오두막집도, 들판도, 다리도 모두 달콤한 워터멜론 슈가로 만들어져 있다. 진하지 않으면서 은은하게 퍼지는 워터멜론 향기는 언제나 사람들에게 적당히 졸음을 자극한다. 하지만 늘 조용하고 평화롭게 보이는 이곳에서도 사랑과 배신, 그리고 '잊혀진 것들'로 인한 갈등이 시작되는데…."
				,"창비","소설",1000,234,"2023/03/03","NEW");
		BookVO book2 = new BookVO("B0001","없음의 대명사",12000,"오은수",
				"“없음은 있었음을 끊임없이 두드릴 것이다”\n"
				+ "\n"
				+ "‘웃음’과 ‘울음’이 나란히 놓이고\n"
				+ "‘무표정’으로 ‘표정’을 지을 때\n"
				+ "‘없다’와 ‘있었다’ 사이에서 떠오르는 ‘잃었다’의 자리\n"
				+ "시인 오은의 여섯번째 시집 『없음의 대명사』가 문학과지성사 시인선"
				+ " 585번째로 출간되었다. 전작 『나는 이름이 있었다』 이후 5년 만에 "
				+ "펴내는 시집이라 반가움이 크다. 오랜만의 새 시집이긴 하지만 그사이 "
				+ "시인은 다양한 앤솔러지와 산문집, 청소년 시집 등을 출간했을 뿐 아니라 2018년 4월"
				+ "부터 2023년 현재까지 온라인 서점 예스24의 도서 팟캐스트 책읽아웃에서 ‘오은의 옹기종"
				+ "기’를 맡아 현재까지 진행해오고 있으니, 읽고 쓰고 그에 대해 나누는 일을 게을리한 적은 없"
				+ "다."
						,"문학과 지성사","시/에세이",700,123,"2023/05/21","Refurbished");
		BookVO book3 = new BookVO("C0001","당신의 영향력은 생각보다 강하다",17800,"버네사 본스",
				"★ 파이낸셜타임스 선정 이달의 최고 비즈니스 도서\n"
				+ "★ 2022 Thinkers50 레이더 클래스 선정\n"
				+ "★ 컬럼비아, 브라운, 코넬 대학교를 거쳐온 ‘영향력’ 연구의 결정판!\n"
				+ "“잠재력을 보는 방식을 영원히 바꿔 줄 책!”\n"
				+ "세계적 석학 다니엘 핑크가 『당신의 영향력은 생각보다 강하다』에 남긴 서평이다. "
				+ "그의 표현대로 이 책은 우리 모두가 지니고 있지만 미처 깨닫지 못하고 있는 ‘숨은 영"
				+ "향력’의 힘을 일깨워 새로운 잠재력을 확인시켜줄 내용으로 가득 차 있다. 또한 남을 바"
				+ "꾸는 힘이 아니라 나 자신을 바꾸는 힘으로서의 영향력을 다루는 독특한 시각이 돋보인다."
						,"창비","인문",800,344,"2023/07/12","OLD");
		listOfBooks.add(book1);
		listOfBooks.add(book2);
		listOfBooks.add(book3);
	}
	
	public List<BookVO> getAllBooks() {
		return listOfBooks;
	}
	
	public BookVO getBookById(String bookId) {
		BookVO bookById = null;
		for(BookVO book : listOfBooks) {
			if(book.getBookId().equalsIgnoreCase(bookId)) {
				bookById =book;
				break;
			}
		}
		return bookById;
	}
}
