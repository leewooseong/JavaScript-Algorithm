package com.ssafy.live01.devideQuenqer;

import java.util.ArrayList;
import java.util.List;

public class practice {
	public static void main(String[] args) {
		List<Integer> list= new ArrayList<>(), adding_l = new ArrayList<>();
		List<List<Integer>> map = new ArrayList<>();
		
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		
		for (int i = 9; i >= 0; i--) {
			adding_l.add(i); // 9 8 7 6 5 4 3 2 1 0
		}
		
		for(int i = 0; i < 10; i++) {
			map.add(list);
		}
		
		for(List<Integer> line : map) {
			System.out.println(line.toString());
		}

		System.out.println("==========");
		
		for(int i = 0; i < 10; i++) {
			System.out.println(map.get(i).toString());

			map.get(i).add(adding_l.get(i));
		}
		
//		for(List<Integer> line : map) {
//			System.out.println(line.toString());
//		}
	}
}
