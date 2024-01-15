package baeckjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Pn1992_s1 {

	static char[][] inputArr;
	static int size;
	static StringBuilder result = new StringBuilder();
	static Stack<Integer> stack = new Stack<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/baeckjoon/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		size = Integer.parseInt(br.readLine());
		inputArr = new char[size][size];
		
		for (int i = 0; i < inputArr.length; i++) {
			char [] inputLine = br.readLine().toCharArray();
			for (int j = 0; j < inputArr.length; j++) {
				inputArr[i][j] = inputLine[j];
			}
		}
		
		result.append(makeQuardTree(0, 0, size));
		
		System.out.println(result);
	}
	
	private static String makeQuardTree(int r, int c, int size) {
		char cValue = inputArr[r][c];

		// 기저 조건
		// - 탐색하는 배열의 size가 1 일때
		if(size == 1) {				
			return Character.toString(cValue);
		} 
		
		int half = size / 2;
		String lt = makeQuardTree(r, c, half);
		String rt = makeQuardTree(r, c + half, half);
		String lb = makeQuardTree(r + half, c, half);
		String rb = makeQuardTree(r + half, c + half, half);
		
		if (lt.length() == 1 && lt.equals(rt) && lt.equals(lb) && lt.equals(rb)) {
			// 모두 동일한 경우 한 개로 리턴
			return lt;
		}  else {
			// 나머지 경우에는 모든 원소 리턴
			return "(" + lt + rt + lb + rb + ")";
		}
	}
}
