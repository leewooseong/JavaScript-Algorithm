package baeckjoon.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 수열 구현하기
public class Pn15649_s3 {
	static boolean[] isVisited;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/baeckjoon/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력 받기
		st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		int pNum = Integer.parseInt(st.nextToken());
		
		// 순열 출력하기
//		permutation(num, pNum);
		
	}
	
}
