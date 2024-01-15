package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Pn0731 {
	
	public static void main(String[] args) throws IOException {		
		System.setIn(new FileInputStream("src/swea/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int testCase = 1; testCase <= T; testCase++) {
			// 배열 입력 받기
			String inputStr = br.readLine();
			int[] inputArr = new int[inputStr.length()];
			int[] initialArr = new int[inputStr.length()];
			
			for (int i = 0; i < inputStr.length(); i++) {
				inputArr[i] = inputStr.charAt(i) - '0';
			}

			System.out.println(Arrays.toString(initialArr));

			// 초기화 상태 -> 원래 상태 
			int result = 0;
			
			int goal;
			int initial;
			for (int i = 0; i < inputArr.length; i++) {
				goal = inputArr[i];
				initial = initialArr[i];
				if(goal != initial) {					
					result++;
					for (int j = i; j < inputArr.length; j++) {
						initialArr[j] = initialArr[j] == 0 ? 1 : 0; 
					}
					System.out.println(Arrays.toString(initialArr));
				}
			}
			
			System.out.println(Arrays.toString(initialArr));
			System.out.println("#" + testCase + " " + result);
		}

	}
	
}
