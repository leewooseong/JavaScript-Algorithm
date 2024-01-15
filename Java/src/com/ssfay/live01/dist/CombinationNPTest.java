package com.ssfay.live01.dist;

import java.util.Arrays;
import java.util.Scanner;

public class CombinationNPTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();    // N개의 배열 
		int R = sc.nextInt();    // R개를 뽑겠다.
		int[] input = new int[N];
		int[] cInput = new int[N]; // 조합을 위해 사용되는 배열 
		
		// 비교와 swap을 통해서 순열을 뽑아내기 때문에 따로 저장할 자료구조(isSelected)는 필요 없다. 
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		// 조합을 위해 사용될 때는 input을 정렬할 필요가 없다.
		// -> cInput을 건드려 줘야 한다.
		// -> 뒤에서부터 1로 채우기
		int cnt = 0;
		while(++cnt <= R) {
			cInput[N - cnt] = 1;
		}
		
		do {
			// cInput 배열을 이용한 조합 확인
			for (int i = 0; i < N; i++) {
				if (cInput[i] == 0) {
					continue;
				}
				System.out.print(input[i] +"\t");
			}
			System.out.println();
		} while(nextPermutation(cInput));
		
		
	}
	
	// 여기는 건드리지도 않았다.
	private static boolean nextPermutation(int[] pList) {
		int lastIndex = pList.length - 1;
		int top = lastIndex; // 꼭대기가 될 index
		
		// 현재 배열의 꼭대기 위치 찾는 작업. 
		// - 값이 꺽이는 지점을 찾는 것. 
		while(top > 0 && pList[top] <= pList[top - 1]) {
			top--;
		}
		
		// 종료 조건. 
		// - 꼭대기가 0 번째라는 건 이미 내림차순으로 모든 배열이 정렬되어 
		// - 마지막 순서의 순열까지 작업을 마무리했다는 의미로 더 이상 작업을 수행하지 않는다.
		if(top == 0) return false; 
		
		// top - 1 부분과 교환할 점 찾고 swap하기.
		int changedSpot = lastIndex; 
		for (int i = 0; i < pList.length; i++) {
			if (pList[top - 1] < pList[changedSpot]) {
				swap(pList, top - 1, changedSpot);
				break;
			}
			changedSpot--;
		}
		
		// 꼭지점부터 마지막까지 부분 오름차순으로 정렬하기
		int endPointer = lastIndex;
		for (int i = top; i < pList.length; i++) {
			if(top < endPointer) {				
				swap(pList, top++, endPointer--);
			}
		}

		return true;
	}
	
	private static void swap(int[] pList, int a, int b) {
		// TODO Auto-generated method stub
		int temp = pList[a];
		pList[a] = pList[b];
		pList[b] = temp;
	}

}
