package com.ssfay.live01.List;

import java.util.EmptyStackException;

// 예외 상황보단 연결리스트구현에 초점을 맞춰 구현해보겠다.***

// 제네릭 타입을 IStack에게 맞추겠다.?
public class LinkedListStack<E> implements IStack<E>{

	// 노드의 제네릭도 Stack에서 사용하는 것으로 따라가겠다..?
	private Node<E> top = null;
	
	
	// 첫 노드 삽입
	@Override
	public void push(E e) {
		top = new Node<>(e, top);
		
	}

	// 
	@Override
	public E pop() { // 첫 노드 삭제 후 반환
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		
		Node<E> popNode = top;
		top = top.getLink();
		popNode.setLink(null);
		
		return popNode.getData();
	}

	@Override
	public E peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}		
		return top.getData();
	}

	@Override
	public int size() {
		int size = 0;
		
		for (Node<E> temp = top; temp != null; temp = temp.getLink()) {
			size++;
		}
		
		return size;
	}

	
	@Override
	public boolean isEmpty() {
		return top == null;
	}

}
