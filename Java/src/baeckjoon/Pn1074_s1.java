package baeckjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Pn1074_s1 {
	static int exponentSize;
	static int matrixSize;
	static int result = 0;

	static int rIndex;
	static int cIndex;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/baeckjoon/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		exponentSize = Integer.parseInt(st.nextToken());
		matrixSize = (int) Math.pow(2, exponentSize);
		rIndex = Integer.parseInt(st.nextToken());
		cIndex = Integer.parseInt(st.nextToken());

		getResult(0, 0, matrixSize);
	}

	// 1 -> 2 -> 3 -> 4 분면 순으로 탐색
	private static void getResult(int r, int c, int size) {
		if (r == rIndex && c == cIndex) {
			System.out.println(result);
			System.exit(0);
		}

		int half = size / 2;
		// 최종 목표 인덱스가 해당하는 4분면으로 이동
		if(rIndex < r + half && cIndex < c + half) {
			// 1사분면
			getResult(r, c, half);
		} else if(rIndex < r + half && cIndex >= c + half) {
			// 2사분면
			result += half * half;
			getResult(r, c + half, half);			
		} else if(rIndex >= r + half && cIndex < c + half) {
			// 3사분면
			result += half * half * 2;
			getResult(r + half, c, half);
		} else {
			// 4사분면
			result += half * half * 3;
			getResult(r + half, c + half, half);
		}
		
		return;

	}
}
