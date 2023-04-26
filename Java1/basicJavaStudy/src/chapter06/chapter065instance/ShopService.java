package chapter06.chapter065instance;

public class ShopService {
	private static ShopService instance = new ShopService();
	
	static ShopService getInstance() {
		return instance;
	}
	
	private ShopService() {
		
	}
}
