package com.ssfay.live01.List;

public class Node<T> {
	
	private T data;
	private Node<T> link;
	
	public Node(T data) {
		super();
		this.data = data;
	}
	
	public Node(T data, Node<T> link) {
		super();
		this.data = data;
		this.link = link;
	}
	
	// getters, setters
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getLink() {
		return link;
	}

	public void setLink(Node<T> link) {
		this.link = link;
	}
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Node [data=" + "]" ;
	}
}
