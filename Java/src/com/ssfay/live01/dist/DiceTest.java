package com.ssfay.live01.dist;

import java.util.Arrays;
import java.util.Scanner;

public class DiceTest {
	
	static int N, numbers[];
	static boolean isSelected[];
	public static void main(String[] args) {
		// 입력 : 주사위 던지는 횟수, 주사위 던지기 모드(1,2,3,4)
		// - 입력이 크지 않기 때문에 Scanner 사용해도 괜찮을 것 같ㄷ.
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 주사위 던지는 회수 (0 < N < 7)
		int M = sc.nextInt(); // 주사위 던지기 모드
		numbers = new int[N]; // 던저진 주사위 수들
		switch(M) {
		case 1:
			dice1(0);
			break;
		case 2:
			isSelected = new boolean[7];
			dice2(0);
			break;
		case 3:
			dice3(0, 1);
			break;
		case 4:
			dice4(0, 1);
			break;
		}
	}
	
	// 주사위 던지기 1 문제 풀이
	// - 주사위 던지기 2에서 중복 체크하는 로직을 제거하면 된다.
	// - n 번째 주사위 던지기
	// - cnt + 1번째 주사위 한번 던지기, cnt : 기존까지 던져진 주사위 횟수
	private static void dice1(int cnt) {
		// 종료 조건
		if(cnt == N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		// 한번 던질 때 가능한 상황에 대한 시도(1-6 주사위 눈이 가능한 상황)
		for (int i = 1; i <= 6; i++) {
//			if(isSelected[i]) continue; // 기존 주사위 눈과 중복되는지 체크
			numbers[cnt] = i;
//			isSelected[i] = true;
			dice2(cnt + 1);					// 현 주사위 눈을 i로 고정한 채로 다음 주사위 던지러 가기
//			isSelected[i] = false;
		}
	}
	
	// 주사위 던지기 2 문제 풀이
	// - n 번째 주사위 던지기
	// - cnt + 1번째 주사위 한번 던지기, cnt : 기존까지 던져진 주사위 횟수
	private static void dice2(int cnt) {
		// 종료 조건
		if(cnt == N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		// 한번 던질 때 가능한 상황에 대한 시도(1-6 주사위 눈이 가능한 상황)
		for (int i = 1; i <= 6; i++) {
			if(isSelected[i]) continue; // 기존 주사위 눈과 중복되는지 체크
			numbers[cnt] = i;
			isSelected[i] = true;
			dice2(cnt + 1);					// 현 주사위 눈을 i로 고정한 채로 다음 주사위 던지러 가기
			isSelected[i] = false;
		}
	}
	
	// 중복이 가능한 조합의 경우
	// - start : 시작 주사위 눈의 수
	private static void dice3(int cnt, int start) {
		if (cnt == N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		// i : 뽑는 수, 중복이 가능해야되기 때문에
		for (int i = start; i <= 6; i++) {
			numbers[cnt] = i;
			dice3(cnt + 1, i);
		}
	}
	
	// 중보깅 불가능한 조합의 경우
	// - start : 시작 주사위 눈의 수
	private static void dice4(int cnt, int start) {
		if (cnt == N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		// i : 뽑는 수, 중복이 가능해야되기 때문에
		for (int i = start; i <= 6; i++) {
			numbers[cnt] = i;
			dice4(cnt + 1, i + 1);
		}
	}
}
