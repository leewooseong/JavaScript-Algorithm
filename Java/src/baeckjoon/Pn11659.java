package baeckjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 구간 합 구하기 5
public class Pn11659 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/baeckjoon/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 입력 받기
		// - 배열 사이즈, 문제 풀이 횟수
		int arrSize = Integer.parseInt(st.nextToken());
		int problemNum = Integer.parseInt(st.nextToken());
		
		// 배열 입력 받기 
		int[][] inputArr = new int[arrSize][arrSize];
		int[][] prefixSumArr = new int[arrSize + 1][arrSize + 1];
		for (int i = 1; i <= inputArr.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= inputArr.length; j++) {
				// 배열 입력 받기
				inputArr[i - 1][j - 1] = Integer.parseInt(st.nextToken());
				// 누적합 입력 받기
				prefixSumArr[i][j] = inputArr[i - 1][j - 1] + prefixSumArr[i-1][j] + prefixSumArr[i][j - 1] - prefixSumArr[i - 1][j - 1];
			}
		}
		
		int result = 0;
		int[] startPoint, endPoint;

		for (int problemCase = 0; problemCase <problemNum; problemCase++) {
			st = new StringTokenizer(br.readLine());
			
			startPoint = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			endPoint = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

			System.out.println(Arrays.toString(startPoint));
			System.out.println(Arrays.toString(endPoint));

			// 범위 안의 수 모두 구하기
			if (startPoint[0] == endPoint[0] && startPoint[1] == endPoint[1]) {
				result = inputArr[startPoint[0] - 1][startPoint[1] - 1];
			} else {				
				result = prefixSumArr[endPoint[0]][endPoint[1]] 
						- prefixSumArr[endPoint[0]][startPoint[1] - 1] 
						- prefixSumArr[startPoint[0] - 1][endPoint[1]] 
						+ prefixSumArr[startPoint[0] - 1][startPoint[1] - 1];
			}
			
			System.out.println(result);
			result = 0;
		}
		
	}

}
