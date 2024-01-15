package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pn2001_2 {
	
	static int[][] inputArr;
	static int arrSize;
	static int killingZoneSize;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/swea/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		
		for(int testCase = 1; testCase <= T; testCase++)
		{
			st = new StringTokenizer(br.readLine());
			arrSize = Integer.parseInt(st.nextToken());
			killingZoneSize = Integer.parseInt(st.nextToken());
			
			inputArr = new int[arrSize][arrSize];
			
			// 배열 입력 받기
			for (int i = 0; i < inputArr.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < inputArr.length; j++) {
					inputArr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 파리 퇴치 최대값 구하기
			int maxDeadValue = 0;
			for (int i = 0; i <= inputArr.length - killingZoneSize; i++) {
				for (int j = 0; j <= inputArr.length - killingZoneSize; j++) {
					int deadFlys = killingFlys(inputArr, killingZoneSize, i, j);
					maxDeadValue = deadFlys > maxDeadValue ? deadFlys : maxDeadValue;
				}
			}
			
			System.out.println("#" + testCase + " " + maxDeadValue);
		}
	}
	
	private static int killingFlys(int[][] inputArr, int killingZoneSize, int rIndex, int cIndex) {
		int result = 0;
		
		for (int i = rIndex; i < rIndex + killingZoneSize; i++) {
			for (int j = cIndex; j < cIndex + killingZoneSize; j++) {
				result += inputArr[i][j];
			}
		}
		
		return result;
	}
}
