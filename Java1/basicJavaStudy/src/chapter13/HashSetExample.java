package chapter13;

import java.util.Iterator;
import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
//		set = new LinkedHashSet<>();
//		set = new TreeSet<>();
		set.add("Java");
		set.add("JDBC");
		set.add("Servlet/JSP");
		set.add("iBatis");
		
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			String string = iterator.next();
			System.out.println(string);
		}
		//jdk1.5 부터 foreach(a.k.a advanced fro loop)
		for (String string : set) {
			System.out.println(string);
		}
		//함수형 프로그래밍 (functional programming) => 변수를 사용하지 않고 프로그래밍
		//jdk 1.8에서  Stream API 함수형 프로그래밍을 구현 
		set.forEach(System.out::println);
	}
}
