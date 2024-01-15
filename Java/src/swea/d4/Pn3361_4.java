package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Pn3361_4 {
	static final int A = 0;
	static final int B = 1;
	static final int C = 2;
	static final int D = 3;
	
	static char[] resList;	// 책임자 명단
	static int numOfCase = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/swea/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());

		// 테스트 케이스 수행
		for (int testCase = 1; testCase <= T; testCase++) {
			resList = br.readLine().toCharArray();
			getTotalCase(0, 0, new boolean[4]);
		}
		
		System.out.println(numOfCase);
	}
	// pInfo : 이전 단계에서 참가한 사용자 내역
	private static void getTotalCase(int sIndex, int dayCount, boolean[] pInfo) {

		// 활동 일자 끝날까지 인원이 다 배정된 경우 return
		if(dayCount == resList.length) {
			numOfCase++;
			System.out.println(Arrays.toString(pInfo));
			return;
		}
		
		// 1. 책임자는 필수 참가
		switch(resList[dayCount]) {
		case 'A':
			pInfo[A] = true;
			break;
		case 'B':
			pInfo[B] = true;
			break;
		case 'C':
			pInfo[C] = true;
			break;
		case 'D':
			pInfo[D] = true;
			break;
		}
		dayCount++;
		
		// candidates count
		int cCount = 0;
		for (int i = 0; i < pInfo.length; i++) {
			if(!pInfo[i]) cCount++;
		}
		
		// 2. 남은 인원에 대해서 경우의수 구해야한다.
		// - 각 경우 마다 재귀를 돈다.
		// - 중복이 허용되기 때문에 i부터 시작되어야 한다.
		for (int i = sIndex; i < pInfo.length; i++) {
			if(!pInfo[i]) {	
				pInfo[i] = true;
				getTotalCase(i, dayCount, pInfo);
				pInfo[i] = false;
			}
			getTotalCase(i, dayCount, pInfo);
		}	
		
	}
	
	private static void subSet(int sIndex, int cCount, boolean[] isSelected) {
		if(sIndex == cCount) {
		}
		
		for (int i = 0; i < isSelected.length; i++) {
			if(!isSelected[i]) {
				subSet(i + 1, cCount, isSelected);
				isSelected[i] = true;
				subSet(i + 1, cCount, isSelected);
				isSelected[i] = false;
			}
		}

	}
}
