package baeckjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Pn1987_g4 {
	static int rSize;
	static int cSize; 
	static char[][] board;
	
	static Set<Character> selected = new HashSet<Character>();
	static int max = 0;
	static boolean[] alpha = new boolean[26];
	
	// ↑ ↓ ← → 
	static int[][] dir = {{ -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }};
	
	// bit masking
	static int flag = 0; 
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/baeckjoon/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st  = new StringTokenizer(br.readLine());
		rSize = Integer.parseInt(st.nextToken());
		cSize = Integer.parseInt(st.nextToken());
		board = new char[rSize][cSize];
		
		for (int i = 0; i < rSize; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
//		for (int i = 0; i < rSize; i++) {
//			for (int j = 0; j < cSize; j++) {
//				System.out.print(board[i][j] + " ");
//			}
//			System.out.println();
//		}
	
		getMaxTravel(0, 0, 1, flag | 1 << (board[0][0] - 65));
		System.out.println(max);
	}
	
	private static void getMaxTravel(int cR, int cC, int result, int flag) {
		int nR = cR;
		int nC = cC;
		
		max = Math.max(result, max);
//		max = max < result ? result : max; // 3항 연산자와 Math.max의 속도 차이는 얼마 없다.
//		alpha[board[cR][cC] - 65] = true;
//		int tmp = flag;
//		flag = flag | 1 << (board[cR][cC] - 65); // bit setting
		
		for (int i = 0; i < dir.length; i++) {			
			nR = cR + dir[i][0]; 
			nC = cC + dir[i][1];
			
			// 범위 안에 있고 방문하지 않은 것이라면
			if(isInBoundary(0, 0, rSize, cSize, nR, nC)) {
//				if(!alpha[board[nR][nC] - 65]) {					
				if((flag & 1 << (board[nR][nC] - 65)) == 0) {					
					getMaxTravel(nR, nC, result + 1, flag | 1 << (board[nR][nC] - 65));
				} 
			}			
		}
		
		// bit unsetting
		// 1. 같은 비트 위치로 이동해서 0과 and 연산?
		// 2. 
//		flag = flag & 0 << (board[cR][cC] - 65);
//		alpha[board[cR][cC] - 65] = false;
	}
	
	// 바운더리를 넘어갔는지 확인하는 함수
	// - sPoint : 시작점
	// - rowSize : 행 크기
	// - colSize : 열 크기
	// - cPoint : 현재 비교할 포인트
	private static boolean isInBoundary(int sR, int sC, int rowSize, int colSize, int cR, int cC) {
		if ((cR >= sR && cR < sR + rowSize) 
				&& (cC >= sC && cC < sC + colSize)) {
			return true;
		}

		return false;
	}
	
	
}
