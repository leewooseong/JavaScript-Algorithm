package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Pn1210 {
	// 위, 좌, 우
	// (row, col)
	static int[][] dir = {{-1, 0}, {0, -1}, {0, 1}};
	// 위, 좌, 우
	static int endPoint = 0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/swea/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = 10;
		
		int validSize = 100;
		int arrColSize = validSize + 2;
		int arrRowSize = validSize + 1;
		
		// 입력 배열 양 옆, 위에 값이 0인 열들을 추가
		int[][] inputArr = new int[arrRowSize][arrColSize];
		
		for(int testCase = 1; testCase <= T; testCase++) {
			int[] startPoint = {validSize, 0};
			
			// testCase 입력 버리기
			br.readLine();
			
			// 배열 입력받기
			for (int i = 1; i < arrRowSize; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < arrColSize - 1; j++) {
					inputArr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 시작할 포인트 찾기(x 지점: 2)
			for (int i = 0; i < arrColSize; i++) {
				if(inputArr[100][i] == 2) {
					startPoint[1] = i;
				}
			}
						
			// 엔드 포인트 찾기(사다리타기 출발 지점 : result)
			findEndPoint(inputArr, startPoint);
			System.out.println("#" + testCase + " " + endPoint);
			
			// 모든 로직 수행 후 배열 초기화
			clearArray(inputArr);
		}
		
	}
	
	public static void clearArray(int[][] inputArr) {
		for (int i = 0; i < inputArr.length; i++) {
			Arrays.fill(inputArr[i], 0);
		}
		
		return;
	}

	public static void findEndPoint(int[][] inputArr, int[] currentPoint) {
		
		int rIndex = currentPoint[0];
		int cIndex = currentPoint[1];
		
		// 방문한 포인트는 0으로 초기화
		inputArr[currentPoint[0]][currentPoint[1]] = 0;
		
		// 종료 조건
		if(rIndex == 1) {
			endPoint = currentPoint[1] - 1;
			return;
		}
		int upperValue = inputArr[rIndex - 1][cIndex];
		int leftValue = inputArr[rIndex][cIndex - 1];
		int rightValue = inputArr[rIndex][cIndex + 1];
		
		// 위, 좌, 우 이동이 가능한 곳 찾기
		// 좌로 이동 아니면 위로 이동
		if(inputArr[rIndex][cIndex-1] == 1) {
			currentPoint[0] += dir[1][0];
			currentPoint[1] += dir[1][1];
		} else if(inputArr[rIndex][cIndex + 1] == 1) {
			currentPoint[0] += dir[2][0];
			currentPoint[1] += dir[2][1];
		} else if(inputArr[rIndex - 1][cIndex] == 1) {
			currentPoint[0] += dir[0][0];
			currentPoint[1] += dir[0][1];
		}
		
		findEndPoint(inputArr, currentPoint);
		
		return;
	}
}
