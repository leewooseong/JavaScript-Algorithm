package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Pn6808_case2 {
	static final int TOTAL_CARD_NUM = 18;
	static final int CARD_NUM = 9;
	
	static int winCount = 0;
	static int looseCount = 0;
	
	static int[] gyu = new int[CARD_NUM];
	static int[] in = new int[CARD_NUM];
	static int[] compareArr = new int [CARD_NUM];
	
	static boolean[] isSelected = new boolean[TOTAL_CARD_NUM];
	static boolean[] inSelected = new boolean[TOTAL_CARD_NUM];
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/swea/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());

			// get gyu's cardList
			for (int i = 0; i < CARD_NUM; i++) {
				gyu[i] = Integer.parseInt(st.nextToken());
				isSelected[gyu[i] - 1] = true;
			}
			
			// get in's cardList
			int count = 0;
			for (int i = 0; i < TOTAL_CARD_NUM; i++) {
				if (isSelected[i]) continue;
				in[count++] = i + 1;
			}
			
			long start = System.nanoTime();

			permutation(0,9);
			
			long end = System.nanoTime();
			
			System.out.println((double)(end - start)/1000000000 + "초 소요");
			
			System.out.println("#" + testCase + " " + winCount + " " + looseCount);
			System.out.println();
			
			winCount = 0;
			looseCount = 0;
			Arrays.fill(isSelected, false);
			Arrays.fill(inSelected, false);
			Arrays.fill(compareArr, 0);
			
		}
	}
	
	private static boolean nextPermutation(int[] pList) {
		int len = pList.length; 
		int top = len - 1; // 꼭대기가 될 index
		
		// 현재 배열의 꼭대기 위치 찾는 작업. 
		// - 값이 꺽이는 지점을 찾는 것. 
		while(top > 0 && pList[top] <= pList[top - 1]) {
			top--;
		}
		
		// 종료 조건. 
		// - 꼭대기가 0 번째라는 건 이미 내림차순으로 모든 배열이 정렬되어 
		// - 마지막 순서의 순열까지 작업을 마무리했다는 의미로 더 이상 작업을 수행하지 않는다.
		if(top == 0) return false; 
		
		// top - 1 부분과 교환할 점 찾고 swap하기.
		int changingSpot; 
		for (int i = 1; i < pList.length; i++) {
			changingSpot = len - i;
			if (pList[top - 1] < pList[changingSpot]) {
				swap(pList, top - 1, changingSpot);
				break;
			}
		}
		
		// 꼭지점부터 마지막까지 부분 오름차순으로 정렬하기
		int endPointer = len - 1;
		for (int i = top; i < pList.length; i++) {
			if(top < endPointer) {				
				swap(pList, top++, endPointer--);
			}
		}

		return true;
	}
	
	private static void swap(int[] pList, int a, int b) {
		// TODO Auto-generated method stub
		int temp = pList[a];
		pList[a] = pList[b];
		pList[b] = temp;
	}

	private static void chooseWinner() {		
		int gyuScore = 0;
		int inScore = 0;
		
		for (int i = 0; i < CARD_NUM; i++) {
			if(gyu[i] < compareArr[i]) {
				inScore += gyu[i] + compareArr[i];
			} else {
				gyuScore += gyu[i] + compareArr[i];
			}
		}

		//
		if(gyuScore > inScore) {
			winCount++;
		} else if (gyuScore < inScore) {
			looseCount++;
		}
		
	}
	
	private static void permutation(int selectedCount, int N) {
		// 종료 조건
		if(selectedCount == N) {
			chooseWinner();
			return;
		}
		
		// 한번 던질 때 가능한 상황에 대한 시도(1-6 주사위 눈이 가능한 상황)
		for (int i = 0; i < CARD_NUM; i++) {
			if(inSelected[i]) continue; // 기존 주사위 눈과 중복되는지 체크
			compareArr[selectedCount] = in[i];
			inSelected[i] = true;
			permutation(selectedCount + 1, N);					// 현 주사위 눈을 i로 고정한 채로 다음 주사위 던지러 가기
			inSelected[i] = false;
		}
	}
}