package baeckjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pn20187_g3 {
	static int[][] before = new int[4][2];
	static int[][] after = new int[4][2];
	
	static int[][] result;
	static String[] foldArr;
	static int hole;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/baeckjoon/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		
		// 입력 받기
		int expNum = Integer.parseInt(br.readLine());
		int foldNum = (int)Math.pow(2, expNum);
		result = new int[expNum][expNum];
		foldArr = new String[foldNum];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < foldArr.length; i++) {
			foldArr[i] = st.nextToken();
		}	
		hole = Integer.parseInt(br.readLine());
		before[0] = new int[] {0,0};
		before[1] = new int[] {0,0};
		before[2] = new int[] {0,0};
		before[3] = new int[] {0,0};
	}
	
	private void getStartingPoint() {

	}
	
	private static void printResult() {
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}

	}
}
