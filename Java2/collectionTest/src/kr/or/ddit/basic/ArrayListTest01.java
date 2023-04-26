package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest01 {
	public static void main(String[] args) {
		//ArrayList의 기본적인 사용법은 Vector 와 같다. 
		ArrayList list1 = new ArrayList();
		
		//add() 메서드를 이용해서 데이터를 추가한다. 
		list1.add("aaa");
		list1.add("bbb");
		list1.add(123);
		list1.add('k');
		list1.add(false);
		list1.add(123.45);
		
		System.out.println("list1=> " + list1);
		System.out.println("size => " + list1.size());
		
		//데이터 끼워 넣기도 같다.
		list1.add(3, "zzz");
		System.out.println("list1=> " + list1);
		
		// get()메서드로 데이터를 꺼내온다. 
		System.out.println("1번째 자료: " + list1.get(1));
		
		//데이터 변경하기 
		String sTemp = (String) list1.set(3, "yyy");
		System.out.println("list1=> " + list1);
		System.out.println("3번째 자료: " + sTemp);
		System.out.println();
		
		//삭제방법도 같다. 
		list1.remove(3);
		System.out.println("3번째 자료 삭제 후 list1=> " + list1);
		list1.remove("bbb");
		System.out.println("bbb 삭제 후 list1=> " + list1);
		System.out.println();
		
		//제네릭을 사용할 수 있다. 
		ArrayList<String> list2 = new ArrayList<>();
		list2.add("AAAA");
		list2.add("BBBB");
		list2.add("BBBB");
		list2.add("DDDD");
		list2.add("EEEE");
		list2.add("FFFF");
		
		for (int i = 0; i < list2.size(); i++) {
			System.out.println(i +"=> " + list2.get(i));
		}
		System.out.println();
		
		for (String temp : list2) {
			System.out.println(temp);
		}
		System.out.println();
		System.out.println("----------------------------------------------");
		
		//contains (비교데이터) => 리스트에 저장된 데이터 중에서 '비교데이터' 가 있으면 true, 없으면 false 반환 
		System.out.println("DDDD값 존재 여부 : " + list2.contains("DDDD"));		
		System.out.println("DDDD값 존재 여부 : " + list2.contains("ZZZZ"));
		
		//indexOf(비교데이터), lastIndexOf(비교데이터)
		//=> 리스트에 '비교 데이터'가 있으면 '비교데이터' 가 저장된 index값을 반환하고  없으면 -1을 반환한다.
		//=> indexOf()메서드는 검색방향이 앞에서 뒤쪽으로 검색하고	
		//=>	lastIndexOf()메서드는 검색 방향이 뒤에서 앞쪽으로 검색한다. 
//		=> 리스트에 '비교데이'가 많으면 검색해서 첫번째로 찾아진 데이터의 값을반한다.
		System.out.println("list2=> "+ list2);
		System.out.println("DDDD의 위치값:"+  list2.indexOf("DDDD"));
		System.out.println("ZZZ의 위치값:"+  list2.indexOf("ZZZZ"));
		System.out.println("DDDD의 위치값:"+  list2.lastIndexOf("DDDD"));
		System.out.println("-----------------------------------------------");
		
		//toArray() => 리스트 안의 데이터들을 배열로 변환해서 반환한다.
		//				 => 기본적을 Object 형 배열로 변환한다.
		//toArray(new 제네릭타입[0]) => 제네릭 타입의 배열로 변환해서 반환한다.
		Object[] strArr = list2.toArray();
		System.out.println("list의 size: " + list2.size());
		System.out.println("배열의 길이: " + strArr.length );
		for (int i = 0; i < strArr.length; i++) {
			System.out.println(i + "=>" + strArr[i]);
		}
		System.out.println("--------------------------------------------------");
		//제네릭 타입의 열로 변환해서 가져오기 
		String [] strArr2 = list2.toArray(new String [0]);
		for (String str : strArr2) {
			System.out.println(str);
		}
	}
}
