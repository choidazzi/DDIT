package kr.or.ddit.basic;

import java.util.LinkedList;
import java.util.Stack;

public class StacQueueTest {
	/*
	 * Stack => 후입선출(LIFO) - last in first out 
	 * Queue => 선입선출(FIFO) - first in first out
	 * 
	 * - Stack 과 Queue 는 LinkedList를 이용하여 사용할 수 있다. 
	 */
	public static void main(String[] args) {
		/*
		 * Stack 의 명령
		 *1. 자료 입력: push(입력값)
		 *2. 자료 출력: pop() 		 => 자료를 꺼내온 후 꺼내온 자료를 Stack에서 삭제한다. 
		 *					peek() 		 => 삭제없이 자료를 꺼내온다. 
		 */
		
		Stack<String> stack = new Stack<>();
		stack.push("스폰지밥");
		stack.push("징징이");
		stack.push("뚱이");
		stack.push("핑핑이");
		
		System.out.println("현재 Stack값: " + stack);
		System.out.println("꺼내온 값: " + stack.pop());
		System.out.println("현재 Stack값: " + stack);
		stack.push("다람이");
		System.out.println("추가 후 Stack값: " + stack);
		System.out.println("꺼내온 값: " + stack.pop());
		System.out.println("현재 Stack값: " + stack);
		
		System.out.println();
		System.out.println("삭제없이 꺼내온 값: " + stack.peek());
		System.out.println("현재 Stack값: " + stack);
		System.out.println("\n------------------------------------------------\n");
		
		/*
		 *Queue의 명령
		 *1. 자료 입력: offer(입력값)
		 *2. 자료 출력: poll()		 => 자료를 꺼내오고 꺼내온 자료를 Queue 에서 삭제한다.
		 *					peek()	 => 삭제없이 자료를 꺼내온다. 
		 **/
		LinkedList<String> queue = new LinkedList<>();
		queue.offer("스폰지밥");
		queue.offer("징징이");
		queue.offer("뚱이");
		queue.offer("핑핑이");
		
		System.out.println("현재 queue값: " + queue);
		String temp = queue.poll();
		System.out.println("꺼내온 값: " + temp);
		System.out.println("꺼내온 값: " + queue.poll());
		System.out.println("현재 queue값: " + queue);
		
		queue.offer("다람이");
		System.out.println("현재 queue값: " + queue);
		
		System.out.println("꺼내온 값: " + queue.poll());
		System.out.println("현재 queue값: " + queue);
		
		System.out.println("삭제없이 꺼내온 값: " + queue.peek());
		System.out.println("현재 queue값: " + queue);
		
//		test();
	}
	
//	static void test() {
//		System.out.println("이것은 test method 입니다.");
//	}
}
