package chapter06;

public class CardTest {
	public static void main(String[] args) {
		System.out.println("Card.width = " + Card.width);
		System.out.println("Card.height = " + Card.height);
		
		Card card1 = new Card();
		card1.kind = "Heart";
		card1.number = 7;
		Card card2 = new Card();
		card2.kind = "Spade";
		card2.number = 3;
		
		System.out.println("c1은 " + card1.kind + "," + card1.number + "이며, 크기는 " + card1.width + ","+card1.height );
		System.out.println("c2은 " + card2.kind + "," + card2.number + "이며, 크기는 " + card2.width + ","+card2.height );
		
		card1.width = 20;
		System.out.println(card1.width );
		System.out.println(card2.width );
		
	}
}

class Card{
	String kind;
	int number;
	static int width = 100;
	static int height = 250;
}
