package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Pn4193_4 {

	static int poolSize;
	static int[][] pool;
	static int[] sPoint;
	static int[] ePoint;
	static int result = 15 * 15; // 총 걸린 시간 (최대 15 * 15);

	// 상, 하, 좌, 우
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/swea/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		// 테스트 케이스 수행
		for (int testCase = 1; testCase <= T; testCase++) {

			// 입력 받기
			poolSize = Integer.parseInt(br.readLine());
			pool = new int[poolSize + 2][poolSize + 2];

			for (int i = 0; i < pool.length; i++) {
				if (i >= 1 && i < pool.length - 1) {
					st = new StringTokenizer(br.readLine());
					
					for (int j = 0; j < pool.length; j++) {
						if (j >= 1 && j < pool.length - 1) {							
							pool[i][j] = Integer.parseInt(st.nextToken());
						} else {
							pool[i][j] = 1;
						}
					}	
				} else {
					for (int j = 0; j < pool.length; j++) {
						pool[i][j] = 1;
					}
				}
			}

			printPool();

			// 시작점, 끝점 입력받기
			st = new StringTokenizer(br.readLine());
			sPoint = new int[] { Integer.parseInt(st.nextToken()) + 1, Integer.parseInt(st.nextToken()) + 1 };
			st = new StringTokenizer(br.readLine());
			ePoint = new int[] { Integer.parseInt(st.nextToken()) + 1, Integer.parseInt(st.nextToken()) + 1 };

			swimShortestPath(sPoint, 0, new int[] { -1, -1 });
			
			System.out.println(result);
			result = 0;
			for (int i = 0; i < pool.length; i++) {
				Arrays.fill(pool[i], 0);
			}
		}
	}

	// 가장 빠른 경로로 수영하기
	private static void swimShortestPath(int[] cPoint, int swimTime, int[] previousMove) {
		pool[cPoint[0]][cPoint[1]] = 1;
		
		int nextSwimTime = swimTime + 1;

		// 도착지에 도작하면 종료
		if (cPoint[0] == ePoint[0] && cPoint[1] == ePoint[1]) {
			if (swimTime < result) {
				result = swimTime;
			}

			return;
		}

		// 상 하 좌 우로 각 재귀 함수를 통해 이동
		for (int i = 0; i < dir.length; i++) {
			int[] nextPoint = new int[] { cPoint[0] + dir[i][0], cPoint[1] + dir[i][1] };
			int nextValue = pool[nextPoint[0]][nextPoint[1]];

			// 갈 수 있는 방향이면 가고 소용돌이면 2초 기다렸다가 가고
			if (nextValue == 0) {
				swimShortestPath(nextPoint, nextSwimTime, dir[i]);
			} else if (nextValue == 2) {
				// 소용돌이를 만났을 때
				swimShortestPath(nextPoint, nextSwimTime + 2, dir[i]);
			}
		}

		pool[cPoint[0]][cPoint[1]] = 0;
		return;
	}

	private static void printPool() {
		for (int i = 0; i < pool.length; i++) {
			for (int j = 0; j < pool.length; j++) {
				System.out.print(pool[i][j] + " ");
			}
			System.out.println();
		}
	}
}
