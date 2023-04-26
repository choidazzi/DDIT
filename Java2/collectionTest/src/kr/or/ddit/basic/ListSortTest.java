package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * 정렬과 관련된 interface는 Comparable 과 Comparator
 * 두 가지가 있다.
 * 
 *- Comparable은 Collection에 추가되어 데이터 자체에 정렬 기준을 넣고 싶을 때 
 *   구현하는 인터페이스 이다. (내부 정렬 기준)
 *- Comparator는 외부에 별도로 정렬 기준을 구현하고 싶을 때 
 *   구현하는 인터페이스 이다. (외부 정렬 기준) 
 *   
 * Comparable 에서는 compareTo()메서드를 재정의하고 
 * Comparator 에서는 compare()	메서드를 재정의 해야한다. 
 * 
 * String 클래스, Wrapper 클래스, Date 클래스, File 클래스에는 
 * 내부 정렬 기준이 이미 구현되어 있다. 
 * (이 클래스들의 내부 정렬 기준은 '오름차순'으로 정렬되도록 구현되어 있다. )
 * */
public class ListSortTest {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		
		list.add("신짱구");
		list.add("김철수");
		list.add("이훈이");
		list.add("이유리");
		list.add("박맹구");
		
		System.out.println("정렬 전: " + list);
		
		//정렬은 Collections.sort() 메서드를 이용하여 정렬한다. 
		//Collections.sort() 메서드는 기본적으로 내부 정렬 기준으로 정렬된다.
		
		Collections.sort(list);
		System.out.println("정렬 후: " + list);
		
		Collections.shuffle(list); //자료 섞기 
		System.out.println("자료 섞기 후: " + list );
		
		//외부 정렬 기준을 적용해서 정렬하기 
		Collections.sort(list, new Desc());
		System.out.println("내림차순 정렬 후: " + list );
	}
	
}

// 외부 정렬 기준 만들기 
// 정렬 방식을 정해주는 Class를 만든다. ( 이 클래스를 외부 정렬 기준 클래스라고 한다.)
class Desc implements Comparator<String>{
	
	// 이 compare() 메서드를 이용해서 정렬하는 기준을 정해준다.  
	//compare()메서드의 반환값의 의미 
	//반환값이 0 이면 두 값이 같다.
	//반환값이 양수면 두 값의 순서를 바꾼다.
	//반환값이 음수면 두 값의 순서를 바꾸지 않는다. 
	@Override
	public int compare(String str1, String str2) {
		if(str1.compareTo(str2)>0) {
			return -1;
		} else if (str1.compareTo(str2)<0) {
			return 1;
		} else {
			return 0;
		}
	}
}









