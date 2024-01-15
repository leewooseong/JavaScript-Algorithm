package com.ssafy.live01.devideQuenqer;

import java.util.Scanner;

public class MakeSpaceTest {

	static int spaces[][];
	static int white, green;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		spaces = new int[N][N];
		

		for (int i = 0; i < spaces.length; i++) {
			for (int j = 0; j < spaces.length; j++) {
				spaces[i][j] = sc.nextInt();
			}
		}
		
		makeSpace(0, 0, N);
		System.out.println(white);
		System.out.println(green);
	}
	
	// 좌 상단 r, c, 영역 크기 size
	private static void makeSpace(int sr, int sc, int size) {
		int sum = 0;
		
		for (int i = sr; i < sr + size; i++) {
			for (int j = sc; j < sc + size; j++) {
				sum += spaces[i][j];
			}
		}
		
		if (sum == 0) { // 모두 하얀색인 공간(기저 조건)
			white++;
		} else if (sum == size * size) { // 모두 초록색인 공간(기저 조건)	
			green++;
		} else { // 두 색이 섞여있는 공간
			int half = size / 2;
			makeSpace(sr, sc, half); // 1번 공간
			makeSpace(sr, sc + half, half); // 2번 공간
			makeSpace(sr + half, sc, half); // 3번 공간
			makeSpace(sr + half, sc + half, half); // 3번 공간
		}
	}

}
