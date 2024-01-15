package baeckjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 구간 합 구하기 4
public class Pn11660 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/baeckjoon/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		
		// 입력 받기
		// - 배열 사이즈, 문제 풀이 횟수
		int arrSize = Integer.parseInt(st.nextToken());
		int problemNum = Integer.parseInt(st.nextToken());
		
		// - 배열 입력 받기 
		int[] inputArr = new int[arrSize];
		int[] prefixSumArr = new int[arrSize + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= inputArr.length; i++) {
			// 배열 입력 받기  						
			inputArr[i - 1] = Integer.parseInt(st.nextToken());
			
			// 누적합 계산하기
			prefixSumArr[i] = prefixSumArr[i - 1] + inputArr[i - 1];
		}
		
//		System.out.println(Arrays.toString(inputArr));
//		System.out.println(Arrays.toString(prefixSumArr));
		
		int result = 0;
		int startPoint, endPoint;
		for (int problemCase = 0; problemCase < problemNum; problemCase++) {
			st = new StringTokenizer(br.readLine());
			
			startPoint = Integer.parseInt(st.nextToken());
			endPoint = Integer.parseInt(st.nextToken());

//			System.out.println(startPoint + " " + endPoint);
			
			// 범위 안의 수 모두 구하기
			// - N부터 L까지의 합 구하기
			// - S[N] - S[L - 1]  
			result = prefixSumArr[endPoint] - prefixSumArr[startPoint - 1];

			System.out.println(result);
			result = 0;
		}
	}
}
