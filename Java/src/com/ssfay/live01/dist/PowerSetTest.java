package com.ssfay.live01.dist;

import java.util.Scanner;

public class PowerSetTest {

	static int arrSize;
	static int[] input;
	static boolean[] isSelected;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		arrSize = sc.nextInt();
		input = new int[arrSize];	
		isSelected = new boolean[arrSize];
		
		for (int i = 0; i < arrSize; i++) {
			input[i] = sc.nextInt();
		}
		
		generateSubset(0);
	}

	// cnt : 직전까지 고려된 원소의 개수, 현재 처리할 원소의 인덱스
	private static void generateSubset(int cnt) {

		if (cnt == arrSize) {
			for (int i = 0; i < arrSize; i++) {
				System.out.println(isSelected[i] ? input[i] : "X" + "\t");
			}
			System.out.println();
			return;
		}

		// 원소를 포함하는 경우 케이스로 재귀 함수 진행
		isSelected[cnt] = true;
		generateSubset(cnt + 1);

		// 원소를 포함하지 않는 경우 케이스로 재귀 함수 진행
		isSelected[cnt] = false;
		generateSubset(cnt + 1);
	}

}
