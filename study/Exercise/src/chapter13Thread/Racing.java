package chapter13Thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Racing {

	public static void main(String[] args) {

		List<Horse> horseList = new ArrayList<Horse>();

		for (int i = 0; i <= 9; i++) {
			horseList.add(new Horse("0" + i + "번말"));
		}

		Thread p = new Position(horseList);

		for (Thread th : horseList) {
			th.start();
		}

		p.start();

		try {
			p.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		Collections.sort(horseList);

		System.out.println("============== 경기결과 ==============");
		for (Horse horse : horseList) {
			System.out.println(horse.getRank() + " 등 : " + horse.getHName());
		}
	}
}

class Horse extends Thread implements Comparable<Horse> {
	public static int ranking;
	private String hName;
	private int rank;
	private int position;
	private Random random = new Random();

	public Horse(String name) {
		super();
		this.hName = name;
	}

	public String getHName() {
		return hName;
	}

	public void setHName(String hName) {
		this.hName = hName;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	@Override
	public int compareTo(Horse h) {
		return Integer.compare(this.getRank(), h.getRank());
	}

	@Override
	public void run() {
		for (int i = 1; i <= 50; i++) {
			setPosition(i);

			try {
				Thread.sleep(random.nextInt(300));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		setRank(++ranking);
	}
}

class Position extends Thread {
	private List<Horse> list;

	public Position(List<Horse> list) {
		super();
		this.list = list;
	}

	@Override
	public void run() {
		while (true) {

			if (Horse.ranking == list.size()) {
				break;
			}

			System.out.println();
			System.out.println();
			System.out.println();

			for (Horse h : list) {
				System.out.print(h.getHName() + " : ");
				for (int i = 1; i <= 50; i++) {
					if (h.getPosition() == i) {
						System.out.print(">");
					} else {
						System.out.print("-");
					}
				}
				System.out.println();
			}

		}
	}
}