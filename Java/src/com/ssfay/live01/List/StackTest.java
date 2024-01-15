package com.ssfay.live01.List;

public class StackTest {

	public static void main(String[] args) {
		IStack<String> stack = new LinkedListStack<String>();
		
		stack.push("서다찬");
		stack.push("전은희");
		stack.push("유현지");
		
		System.out.println(stack.peek());
		System.out.println(stack.size() + "//" + stack.isEmpty());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.size() + "//" + stack.isEmpty());
		System.out.println(stack.pop());		
	}

}
