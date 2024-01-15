package baeckjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Pn2023_g5 {
	
	static int maxDigitNum;
	static int[] decimalArr;
	
	public static void main(String[] args) throws IOException {		
		System.setIn(new FileInputStream("src/baeckjoon/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		maxDigitNum = Integer.parseInt(br.readLine());
		decimalArr = new int[maxDigitNum];
		getCuriousDecimal(1, 2, 9);
	}
	
	// 자리수, 탐색 시작 수
	private static void getCuriousDecimal(int digitNum, int startNum, int endNum) {
		
		if(digitNum - 1 == maxDigitNum) {
			int result = 0;
			for (int i = 0; i < decimalArr.length; i++) {
				result += Math.pow(10, i) * decimalArr[i];
			}
			System.out.println(result);
			return;
		}
		
		// 해당 범위의 수 중에서 되는 소수, 앞에서 정해진 소수를 만족하는 수
		for (int i = startNum; i <= endNum; i++) {			
			if(isDecimal(i)) {
				int nextSNum = i * 10;
				int nextENum =  nextSNum + 9;
				
				decimalArr[digitNum - 1] = i;
				getCuriousDecimal(digitNum + 1, nextSNum, nextENum);
			} 
		}
	}
	
	// 소수인지 판별하기
	private static boolean isDecimal(int num) {
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		
		return true;
	}
}
