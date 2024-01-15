package com.ssfay.live01.tree;

public class CompleteBinaryTreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size = 9;
		CompleteBinaryTree<Character> tree = new CompleteBinaryTree<>(size);
		
		for (int i = 0; i < size; i++) {
			tree.add((char)(65 + i));
		}
		
//		tree.bfs();
		
		tree.dfs();
		System.out.println();
		
		tree.dfsByPreOrder(1);
		System.out.println();
//		tree.dfsByInOrder(1);
//		System.out.println();
//		tree.dfsByPostOrder(1);
	}

}
