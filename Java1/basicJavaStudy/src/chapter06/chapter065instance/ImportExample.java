package chapter06.chapter065instance;

import java.util.Arrays;
import java.util.Collections;

//import java.util.* 모든 클래스 import 

public class ImportExample {
	public static void main(String[] args) {
		Earth earth = new Earth(); //패키지가 같으면 import 안해도 됨 
		String string = new String("");
		Arrays.toString(args);
		Collections.max(Arrays.asList(args));
		
	}
}
