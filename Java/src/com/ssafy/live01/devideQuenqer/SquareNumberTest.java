package com.ssafy.live01.devideQuenqer;

import java.util.Scanner;

public class SquareNumberTest {
	static int callCount1 = 0, callCount2 = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long X = sc.nextLong();
		int N = sc.nextInt();
		
		System.out.println(exp1(X,N));
		System.out.println(exp2(X,N));
		
		System.out.println(callCount1 + " " + callCount2);
		
		System.out.println();
	}

	// 재귀 : 분할 정복 미적용
	// X ^ n = X * X ^ n-1
	// X ^ n-1 = X * X ^ n-2
	private static long exp1(long x, int n) {
		callCount1++;
		if(n == 1) return x;
		return x * exp1(x, n - 1);
	}
	
	// 재귀 : 분할 정복 적용
	// n: 짝수 X ^ n = X^n/2 * X^n/2
	// n: 홀수 X ^ n = X^n-1/2 * X^n/2 * X
	// n: 홀수일 때, X^n/2 ==> X^n-1/2와 같음 (n에 정수 연산이 되기 때문에)
	private static long exp2(long x, int n) {
		callCount2++;
		if(n == 1) return x;
		
		long y = exp2(x, n/2);
		return (n % 2 == 0) ? y * y : y * y * x;

	}
}
