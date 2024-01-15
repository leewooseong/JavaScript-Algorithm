package baeckjoon.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Pn16926_s1 {

	static int rowSize;
	static int colSize;
	static int rotatingCount;
	static int[][] inputArr;

	// 방향 배열 : ↓ → ↑ ←
	static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("src/baeckjoon/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		rowSize = Integer.parseInt(st.nextToken());
		colSize = Integer.parseInt(st.nextToken());
		rotatingCount = Integer.parseInt(st.nextToken());

		inputArr = new int[rowSize][colSize];
		for (int i = 0; i < rowSize; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < colSize; j++) {
				inputArr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		System.out.println("before rotate");
//		printInput();

		for (int i = 0; i < rotatingCount; i++) {			
			rotateArr(new int[] { 0, 0 }, rowSize, colSize);
		}
		
		printInput();

//		System.out.println("after rotate");
//		printInput();
	}

	private static void rotateArr(int[] sPoint, int rowRange, int colRange) {
		// 종료 조건
		if (sPoint[0] >= rowSize / 2 || sPoint[1] >= colSize / 2) {
			return;
		}

		int[] nextPoint = new int[] { sPoint[0], sPoint[1] };
		int currentValue = inputArr[sPoint[0]][sPoint[1]];
		int nextValue;

		int dirIndex = 0;

		// while문을 돌기 위해 한번은 ↓ 뱡향으로 진행해야 한다.
		do {
			nextPoint[0] = nextPoint[0] + dir[dirIndex][0];
			nextPoint[1] = nextPoint[1] + dir[dirIndex][1];

			if (!isInBoundary(sPoint, nextPoint, rowRange, colRange)) {
				nextPoint[0] = nextPoint[0] - dir[dirIndex][0];
				nextPoint[1] = nextPoint[1] - dir[dirIndex][1];
				dirIndex = (dirIndex + 1) % 4;

			} else {
				nextValue = inputArr[nextPoint[0]][nextPoint[1]];
				inputArr[nextPoint[0]][nextPoint[1]] = currentValue;
				currentValue = nextValue;
			}
		} while (!isSamePoint(sPoint, nextPoint));

		int[] nextSPoint = new int[] { nextPoint[0] + 1, nextPoint[1] + 1 };
		rotateArr(nextSPoint, rowRange - 2, colRange - 2);

		return;
	}

	// 다시 시작 시점으로 도착했는지 확인하는 함수
	private static boolean isSamePoint(int[] pointA, int[] pointB) {
		return pointA[0] == pointB[0] && pointA[1] == pointB[1];
	}

	// 바운더리를 넘어갔는지 확인하는 함수
	private static boolean isInBoundary(int[] sPoint, int[] cPoint, int rowRange, int colRange) {
		int sRowIndex = sPoint[0];
		int sColIndex = sPoint[1];
		int eRowIndex = sRowIndex + rowRange;
		int eColIndex = sColIndex + colRange;

		if ((cPoint[0] >= sRowIndex && cPoint[0] < eRowIndex) && (cPoint[1] >= sColIndex && cPoint[1] < eColIndex)) {
			return true;
		}

		return false;
	}

	private static void printInput() {
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				System.out.print(inputArr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
