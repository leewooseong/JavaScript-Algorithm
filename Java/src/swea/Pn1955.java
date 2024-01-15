package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1954. 달팽이 숫자
public class Pn1955 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/swea/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int[][] inputArr;
		
		// 좌, 하, 우, 상
		int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		
		for(int testCase = 1; testCase <= T; testCase++)
		{
			// 입력 받기
			int inputSize = Integer.parseInt(br.readLine());
			inputArr = new int[inputSize][inputSize];
			int matrixSize = inputSize * inputSize;
			int dirIndex = 0;			// index of dir
			int currentNum = 1;
			
			
			int rowIndex = 0;
			int colIndex = 0;
			while(currentNum <= matrixSize) {
				int nextRIndex = rowIndex + dir[dirIndex % 4][0];
				int nextCIndex = colIndex + dir[dirIndex % 4][1];
				
				inputArr[rowIndex][colIndex] = currentNum++;
				
				if(!checkBoundary(inputArr, nextRIndex, nextCIndex) || inputArr[nextRIndex][nextCIndex] != 0) {
					dirIndex++;
					rowIndex = rowIndex + dir[dirIndex % 4][0];
					colIndex = colIndex + dir[dirIndex % 4][1];
				} else {
					rowIndex = nextRIndex;
					colIndex = nextCIndex;
				}
				
			}
			
			printResult(testCase, inputArr);
		}
		
	}
	
	public static boolean checkBoundary(int[][] inputArr, int rowIndex, int colIndex) {
		boolean result = false;
		
		if(rowIndex < inputArr.length && rowIndex >= 0) {
			if(colIndex < inputArr.length && colIndex >= 0) {
				result = true;
			}
		}
		
		return result;
	}
	
	public static void printResult(int testCase, int[][] inputArr) {
		System.out.println("#" + testCase);
		
		for (int i = 0; i < inputArr.length; i++) {
			for (int j = 0; j < inputArr.length; j++) {
				System.out.print(inputArr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
