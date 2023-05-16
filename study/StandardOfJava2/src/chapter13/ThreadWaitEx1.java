package chapter13;

import java.util.ArrayList;

public class ThreadWaitEx1 {
	public static void main(String[] args) throws Exception {
		// 여러 쓰레드가 공유하는 객체 
		Table table = new Table();
		
		new Thread(new Cook(table), "COOK1").start();
		new Thread(new Customer(table,"donut"), "CUST1").start();
		new Thread(new Customer(table,"burger"), "CUST2").start();
		//0.1초 후에 강제 종료 
		Thread.sleep(100);
		//프로그램 전체 종료(모든 쓰레드 종료)
		System.exit(0);
	}
}

class Customer implements Runnable {
	private Table table;
	private String food;

	public Customer(Table table, String food) {
		this.table = table;
		this.food = food;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String name = Thread.currentThread().getName();

			if (eatFood()) {
				System.out.println(name + "ate a " + food);
			} else
				System.out.println(name + "failed to eat ");
		} // while
	}
	
	boolean eatFood() {return table.remove(food);}
}

class Cook implements Runnable {
	private Table table;

	// 생성자
	Cook(Table table) {
		this.table = table;
	}

	@Override
	public void run() {
		while (true) {
			// 임의의 요리를 하나 선택해 table에 추가
			int idx = (int) (Math.random() * table.dishNum());
			table.add(table.dishNames[idx]);

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // while
	}
}

class Table {
	// donut 이 더 자주 나온다.
	String[] dishNames = { "donut", "donut", "burger" };
	// table 에 놓을 수 있는 최대 음식의 개수
	final int MAX_FOOD = 6;
	private ArrayList<String> dishes = new ArrayList<>();

	public synchronized void add(String dish) { // synchronized 추가 
		// 테이블에 음식이 가득 찼으면 음식을 추가하지 않는다.
		if (dishes.size() >= MAX_FOOD)
			return;
		dishes.add(dish);
		System.out.println("Dishes : " + dishes.toString());
	}

	public boolean remove(String dishName) {
		// 지정된 요리와 일치하는 요리를 테이블에서 제거한다.
		for (int i = 0; i < dishes.size(); i++)
			if (dishName.equals(dishes.get(i))) {
				dishes.remove(i);
				return true;
			}
		return false;
	}

	public int dishNum() {
		return dishNames.length;
	}
}