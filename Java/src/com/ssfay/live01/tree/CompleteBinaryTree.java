package com.ssfay.live01.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class CompleteBinaryTree<T> {
	
	private Object[] nodes;
	private int lastIndex; // 채워진 마지막 노드의 인덱스
	private final int SIZE; // 최대 노드의 개수 
	
	//
	public CompleteBinaryTree(int size) {
		this.SIZE = size;
		nodes = new Object[size + 1];
	}
	
	public boolean isEmpty() {
		return lastIndex == 0;
	}
	
	public boolean isFull() {
		return lastIndex == SIZE;
	}
	
	// 완전 이진 트리는 채워지는 순서가 있기 때문에 어디에 추가할지는 받아오지 않아도 된다.
	public boolean add(T data) {
		if(isFull()) return false;
		nodes[++lastIndex] = data;
		return true;
	}
	
	// 너비 단위로 구분해서 bfs 돌리기..?
	// - 그냥 꺼내지 않고 큐의 사이즈를 체크해서 큐의 사이즈 만큼만 뽑고 있는 것
	// - 새로운 대상 탐색
	// - breath는 탐색하는 너비의 높이를 의미한다.
	// - size
	// 그래프의 상태는 2	
	public void bfs() {
		if(isEmpty()) return;
		
		// 0. 탐색 순서를 관리할 대기열 자료구조 생성
		Queue<Integer> queue = new ArrayDeque<Integer>();
		
		// 1. 탐색 시작의 대상부터 큐에 넣기
		queue.offer(1); // 루트노드의 인덱스
		
		int breath = 0;
		while(!queue.isEmpty()) { // 탐색 대상이 있다면
			int size = queue.size();
			
			while(--size >= 0) {
				int current = queue.poll(); // 현재 탐색 대상
				// 탐색 대상 방문 : 방문해서 해야되는 로직을 작성하면 된다.
				System.out.println(nodes[current]);
				// 현재 탐색 대상을 통해 탐색해야할 새로운 대상을 큐에 넣기
				// - 자식이 있는지 체크 필요(왼쪽 자식, 오른쪽 자식)
				// 왼쪽 자식
				if(current * 2 <= lastIndex) {
					queue.offer(current * 2);
				}
				// 오른쪽 자식
				if(current * 2 + 1 <= lastIndex) {
					queue.offer(current * 2 + 1);
				} 
			}
			
			System.out.println();
			System.out.println("================" + breath + "너비 탐색 완료");
			breath++;
		}
	
	}
	
	public void bfs2() {
		if(isEmpty()) return;
		
		// 0. 탐색 순서를 관리할 대기열 자료구조 생성
		Queue<Integer> queue = new ArrayDeque<Integer>();
		
		// 1. 탐색 시작의 대상부터 큐에 넣기
		queue.offer(1); // 루트노드의 인덱스
		
		while(!queue.isEmpty()) { // 탐색 대상이 있다면
			int current = queue.poll(); // 현재 탐색 대상
			// 탐색 대상 방문 : 방문해서 해야되는 로직을 작성하면 된다.
			System.out.println(nodes[current]);
			// 현재 탐색 대상을 통해 탐색해야할 새로운 대상을 큐에 넣기
			// - 자식이 있는지 체크 필요(왼쪽 자식, 오른쪽 자식)
			// 왼쪽 자식
			if(current * 2 <= lastIndex) {
				queue.offer(current * 2);
			}
			// 오른쪽 자식
			if(current * 2 + 1 <= lastIndex) {
				queue.offer(current * 2 + 1);
			} 
			
		}
	
	}
	
	// 원소를 출력할 때 자신의 너비 정보를 함께 표현해주는 bfs 함수
	// - int[]로 설계하는 것이 가독성이 좋지 않다면 클래스로 설계하는 것도 좋은 방법이다. 
	public void bfs3() {
		if(isEmpty()) return;
		
		// 0. 탐색 순서를 관리할 대기열 자료구조 생성
		// - 큐에 들어가는 배열을 int형 1차원 배열로 변경
		// - int[] : {탐색 노드의 인덱스, 너비}
		Queue<int[]> queue = new ArrayDeque<int[]>();
		
		// 1. 탐색 시작의 대상부터 큐에 넣기
		queue.offer(new int[] {1,0}); // 루트노드의 인덱스
		
		while(!queue.isEmpty()) { // 탐색 대상이 있다면
			int[] info = queue.poll();
			int current = info[0]; // 현재 탐색 대상
			// 탐색 대상 방문 : 방문해서 해야되는 로직을 작성하면 된다.
			System.out.println(nodes[current] + "//" + info[1]);
			// 현재 탐색 대상을 통해 탐색해야할 새로운 대상을 큐에 넣기
			// - 자식이 있는지 체크 필요(왼쪽 자식, 오른쪽 자식)
			// 왼쪽 자식
			if(current * 2 <= lastIndex) {
				queue.offer(new int[] {current * 2, info[1] + 1});
			}
			// 오른쪽 자식
			if(current * 2 + 1 <= lastIndex) {
				queue.offer(new int[] {current * 2 + 1, info[1] + 1});
			} 
			
		}
	}
	
	// 현재 노드를 전위 순회로 탐색!!
	// - bfs나 dfs나 결국 똑같다는 점을 확인해보자.
	// - queue에 집어넣는 행동이 재귀함수로 바뀌는 작업일 뿐!***
	// - 2진 트리에 대한 탐색임을 잊지 말자! 
	public void dfsByPreOrder(int current) {		
		// 노드 1개에 대한 작업!
		// 탐색 대상 방문 : 방문해서 해야되는 로직을 작성하면 된다.
		System.out.print(nodes[current]);
		// 현재 탐색 대상을 통해 탐색해야할 새로운 대상을 재귀 호출로 탐색시키기
		// 왼쪽 자식 : 기저 조건의 역할
		if(current * 2 <= lastIndex) {
			dfsByPreOrder(current * 2);
		}
		// 오른쪽 자식 : 기저 조건의 역할
		if(current * 2 + 1 <= lastIndex) {
			dfsByPreOrder(current * 2 + 1);
		} 
	}
	public void dfsByInOrder(int current) {		
		// 노드 1개에 대한 작업!
		// 현재 탐색 대상을 통해 탐색해야할 새로운 대상을 재귀 호출로 탐색시키기
		// 왼쪽 자식 : 기저 조건의 역할
		if(current * 2 <= lastIndex) {
			dfsByPreOrder(current * 2);
		}
		// 탐색 대상 방문 : 방문해서 해야되는 로직을 작성하면 된다.
		System.out.print(nodes[current]);
		// 오른쪽 자식 : 기저 조건의 역할
		if(current * 2 + 1 <= lastIndex) {
			dfsByPreOrder(current * 2 + 1);
		} 
	}
	
	public void dfsByPostOrder(int current) {		
		// 노드 1개에 대한 작업!
		// 현재 탐색 대상을 통해 탐색해야할 새로운 대상을 재귀 호출로 탐색시키기
		// 왼쪽 자식 : 기저 조건의 역할
		if(current * 2 <= lastIndex) {
			dfsByPreOrder(current * 2);
		}
		// 오른쪽 자식 : 기저 조건의 역할
		if(current * 2 + 1 <= lastIndex) {
			dfsByPreOrder(current * 2 + 1);
		} 
		// 탐색 대상 방문 : 방문해서 해야되는 로직을 작성하면 된다.
		System.out.print(nodes[current]);
	}
	
	// - 그냥 꺼내지 않고 큐의 사이즈를 체크해서 큐의 사이즈 만큼만 뽑고 있는 것
	// - 새로운 대상 탐색
	// - breath는 탐색하는 너비의 높이를 의미한다.
	// - size
	// 그래프의 상태는 2	
	public void dfs() {
		if(isEmpty()) return;
		
		// 0. 탐색 순서를 관리할 대기열 자료구조 생성
		Stack<Integer> stack = new Stack<Integer>();
		
		// 1. 탐색 시작의 대상부터 큐에 넣기
		stack.push(1); // 루트노드의 인덱스
		
		int breath = 0;
		while(!stack.isEmpty()) { // 탐색 대상이 있다면
			int size = stack.size();
			
			while(--size >= 0) {
				int current = stack.pop(); // 현재 탐색 대상
				// 탐색 대상 방문 : 방문해서 해야되는 로직을 작성하면 된다.
				System.out.print(nodes[current]);
				// 현재 탐색 대상을 통해 탐색해야할 새로운 대상을 큐에 넣기
				// - 자식이 있는지 체크 필요(왼쪽 자식, 오른쪽 자식)
				// 오른쪽 자식
				if(current * 2 + 1 <= lastIndex) {
					stack.push(current * 2 + 1);
				} 
				// 왼쪽 자식
				if(current * 2 <= lastIndex) {
					stack.push(current * 2);
				}
			}
			
//			System.out.println();
//			System.out.println();
//			System.out.println("================" + breath + "너비 탐색 완료");
//			breath++;
		}
	
	}
	
}
