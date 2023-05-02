package kr.or.ddit.basic;

public class ThreadEx19 {
	public static void main(String[] args) {
		DataBox databox = new DataBox();
		
		DataInThread in = new DataInThread(databox);
		DataOutThread out = new DataOutThread(databox);
		
		out.start();
		in.start();
	}
}

//데이터를 공통으로 사용하는 클래스 
class DataBox {
	private String data;
	
	// data 변수에 값이 null이면 data 변수에 문자열이 채워질 때까지 기다리고 
	// data 변수에 값이 있으면 해당 문자열을 반환한다.  
	// data 값을 반환 후에는 data 변수의 값을 null 로 만든다.
	public synchronized String getData() {
		if (data == null) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// data 변수에 값이 있을 때...
		String temp = data;
		System.out.println("쓰레드가 읽은 데이터: " + temp);
		data = null;
		
		notify();
		
		return temp;
	}
	
	// data 변수에 값이 있으면 data 변수의 값이 null 이 될 때까지 기다린다.
	// data 변수의 값이 null이 되면 새로운 값을 data변수에 저장한다. 
	public synchronized void setData(String data) {
		if (this.data != null) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//data 변수의 값이 null일 때...
		this.data = data;
		System.out.println("Thread에서 새로 저장한 데이터 : " + data);
		notify();
	}
}

// 데이터를 넣어주는 쓰레드 
class DataInThread extends Thread {
	private DataBox databox;
	
	public DataInThread(DataBox databox) {
		this.databox = databox;
	}
	
	@Override
	public void run() {
		String[] testArr = new String[] {"서울","대전","광주","대구"};
		for (int i = 0; i < testArr.length; i++) {
			databox.setData(testArr[i]);
		}
	}
}

// 데이터를 꺼내서 사용하는 쓰레드 
class DataOutThread extends Thread {
	private DataBox databox;
	
	public DataOutThread(DataBox databox) {
		this.databox = databox;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 4; i++) {
			String data = databox.getData();
		}
	}
}
