package kr.or.ddit.basic;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class ThreadTest13 {
	public static void main(String[] args) {
		Horse[] horseArr = new Horse[] {
				new Horse("01번말"),
				new Horse("02번말"),
				new Horse("03번말"),
				new Horse("04번말"),
				new Horse("05번말"),
				new Horse("06번말"),
				new Horse("07번말"),
				new Horse("08번말"),
				new Horse("09번말"),
				new Horse("10번말")
		};
		
		GameStatePrint gsp = new GameStatePrint(horseArr);
		
		// 말들의 경주 시작 
		for (Horse horse : horseArr) {
			horse.start();
		}
		
		// 말들의 경주 상태 출력 
		gsp.start();
		
		for (Horse horse : horseArr) {
			try {
				horse.join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		try {
			gsp.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println("경기 끝...");
		
		System.out.println("경기 결과");
		
		//등수의 오름차순으로 정렬하기 
		Arrays.sort(horseArr);
		for (Horse horse : horseArr) {
			System.out.println(horse);
		}
	}
}

class Horse extends Thread implements Comparable<Horse> {
   public static int currentRank = 0;	// 말들의 등수를 결정할 변수 

	private String horseName;		// 말이름 
	private int location;				// 현재 위치
	private int rank;					// 등수 
	


	// 생성자
	public Horse(String horseName) {
		this.horseName = horseName;
	}
	
	
	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}
	

	public String getHorseName() {
		return horseName;
	}



	public int getLocation() {
		return location;
	}


	public void setLocation(int location) {
		this.location = location;
	}


	public int getRank() {
		return rank;
	}


	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "경주마 " + horseName +"의 등수는 " + rank +" 등 입니다.";
	}
	
	//등수의 오름차순으로 처리할 내부 정렬 기준
	@Override
	public int compareTo(Horse horse) {
			return Integer.compare(rank, horse.rank);
	}
	
	//말이 달리는 것을 쓰레드로 처리한다 
	@Override
	public void run() {
		Random rnd = new Random();
		for(int i = 1; i <= 50; i++) {
			this.location = i;
			
			try {
				Thread.sleep(rnd.nextInt(500));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} //for 문 끝.... 
		
		// 한 마리의 말이 경주가 끝나면 등수를 구해서 저장한다. 
		
		currentRank++;
		this.rank = currentRank;
		
	}
	
}

/*
 	경기 중 중간 중간에 각 말들의 위치를 나타내시오. 
 	예) 
 	1번말 -->--------------------------------------------
 	2번말 -->--------------------------------------------
 	...
 	
 */

// 경기 중 말의 현재 위치를 나타내는 쓰레드 
class GameStatePrint extends Thread {
	private Horse[] horseArr;
	
	//생성자 
	public GameStatePrint(Horse[] horseArr) {
		this.horseArr = horseArr;
	}
	
	@Override
	public void run() {
		while (true) {
			//모든 말들의 경기가 종료되었는지 여부 검사하기 
			if (Horse.currentRank == horseArr.length) {
				break;
			}
			
			for (int i = 1; i <= 10; i++) {
				System.out.println();
			}
			
			for (int i = 0; i < horseArr.length; i++) {
				System.out.println(horseArr[i].getHorseName() + " : ");
				
				for (int j = 1; j <= 50; j++) {
					if (horseArr[i].getLocation() == j) {
						System.out.print("🐴");
					}else {
					System.out.print("-");
					}
				}
				System.out.println(); //줄바꿈 
				
			}
			//시간 지연용 
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}