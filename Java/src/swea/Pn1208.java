package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Pn1208 {

	static final int WIDTH = 100;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/swea/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int dumpCount;
		Integer[] heightArr = new Integer[WIDTH];
		
		
		int T = 10;

		for(int test_case = 1; test_case <= T; test_case++) {
			// 입력 받기
			// - dumpCount
			st = new StringTokenizer(br.readLine());
			dumpCount = Integer.parseInt(st.nextToken());
			// - heightArr
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < WIDTH; i++) {
				heightArr[i] = Integer.parseInt(st.nextToken());
			}
			
			// 내림차순 정렬하기
			Arrays.sort(heightArr, (h1,h2)->{
				return h2 - h1;
			});
			
			int lowPoint = WIDTH - 1;
			int highPoint = 0;
			while(dumpCount > 0){
				heightArr[highPoint]--;
				heightArr[lowPoint]++;
				
				Arrays.sort(heightArr, (h1,h2)->{
					return h2 - h1;
				});
				
				dumpCount--;
			}
			
			System.out.printf("#%d %d",test_case, heightArr[highPoint] - heightArr[lowPoint]);
			System.out.println();
		}
	}

}
