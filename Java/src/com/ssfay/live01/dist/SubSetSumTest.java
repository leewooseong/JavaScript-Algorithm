package com.ssfay.live01.dist;

import java.util.Scanner;

public class SubSetSumTest {

	static int arrSize, target;
	static int[] input;
	static boolean[] isSelected;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		arrSize = sc.nextInt();
		target = sc.nextInt();
		input = new int[arrSize];
		isSelected = new boolean[arrSize];

		for (int i = 0; i < arrSize; i++) {
			input[i] = sc.nextInt();
		}

		generateSubset(0);
		generateSubset2(0, 0, 0);
	}

	// cnt : 직전까지 고려된 원소의 개수, 현재 처리할 원소의 인덱스
	private static void generateSubset(int cnt) {

		// 종료 조건
		if (cnt == arrSize) {
			int sumOfSelected = 0;
			for (int i = 0; i < arrSize; i++) {
				if (isSelected[i]) {
					sumOfSelected += input[i];
				}
			}

			if (sumOfSelected == target) {
				for (int i = 0; i < arrSize; i++) {
					if (isSelected[i]) {
						System.out.print(input[i] + "\t");
					}
				}
				System.out.println();
			}
			return;
		}

		// 원소를 포함하는 경우 케이스로 재귀 함수 진행
		isSelected[cnt] = true;
		generateSubset(cnt + 1);

		// 원소를 포함하지 않는 경우 케이스로 재귀 함수 진행
		isSelected[cnt] = false;
		generateSubset(cnt + 1);
	}
	
	// cnt : 직전까지 고려된 원소의 개수, 현재 처리할 원소의 인덱스
	// sum : 직전까지 선택된 원소들의 합
	private static void generateSubset2(int cnt, int sum, int selectedCount) {
		
		// 종료 조건
		if (cnt == arrSize) {
			if (selectedCount > 0 && sum == target) {
				
				for (int i = 0; i < arrSize; i++) {
					if (isSelected[i]) {
						System.out.print(input[i] + "\t");
					}
				}
				System.out.println();
			} 
			return;
		}
		
		// 원소를 포함하는 경우 케이스로 재귀 함수 진행
		isSelected[cnt] = true;
		generateSubset2(cnt + 1, sum + input[cnt], selectedCount + 1);
		
		// 원소를 포함하지 않는 경우 케이스로 재귀 함수 진행
		isSelected[cnt] = false;
		generateSubset2(cnt + 1, sum, selectedCount);
	}

}
