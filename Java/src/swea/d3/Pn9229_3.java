package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Pn9229_3 {

	static int numOfSnack;
	static int weightLimit;
	static Integer[] snackArr;
	static int maxWeight = 0;
	static int snacksWeight = 0;
	static boolean isFound = false;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/swea/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		// 테스트 케이스 수행
		for (int testCase = 1; testCase <= T; testCase++) {
			// 입력 받기
			st = new StringTokenizer(br.readLine());
			numOfSnack = Integer.parseInt(st.nextToken());
			weightLimit = Integer.parseInt(st.nextToken());
			snackArr = new Integer[numOfSnack];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < numOfSnack; i++) {
				snackArr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(snackArr, Collections.reverseOrder());
			
			chooseSnacks(0, 0);
			
			maxWeight = maxWeight == 0 ? -1 : maxWeight; 
			System.out.println("#" + testCase + " " + maxWeight);
			
			maxWeight = 0;
			snacksWeight = 0;
			isFound = false;
		}

	}

	private static void chooseSnacks(int sIndex, int selectedCount) {
		// 2개가 선택됐다면
		if (selectedCount == 2) {
			if(snacksWeight <=  weightLimit && maxWeight < snacksWeight) {
				maxWeight = snacksWeight;
			}
			if(snacksWeight == weightLimit) {
				isFound = true;
			}
			
			return;
		}

		for (int i = sIndex; i < snackArr.length && !isFound; i++) {
			snacksWeight += snackArr[i];
			chooseSnacks(i + 1, selectedCount + 1);
			snacksWeight -= snackArr[i];
		}

		return;
	}
}
