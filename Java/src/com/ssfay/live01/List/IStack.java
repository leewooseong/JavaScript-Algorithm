package com.ssfay.live01.List;

public interface IStack<E> {
	void push(E e);
	E pop();
	E peek();
	int size();
	boolean isEmpty();
	
}
