package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Pn6808_3
{
    static final int TOTAL_CARD_NUM = 18;
	static final int CARD_NUM = 9;
	
	static int winCount = 0;
	static int looseCount = 0;
	
	// 규영과 인영의 카드 정보를 저장하는 배열
	static int[] gyu = new int[CARD_NUM];
	static int[] in = new int[CARD_NUM];
	
	// 18장 중 선택되지 않은 카드를 인영이의 카드로 사용
	static boolean[] isSelected = new boolean[TOTAL_CARD_NUM];
    
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("src/swea/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());

			// 규영이 카드 정보 받아오기
			for (int i = 0; i < CARD_NUM; i++) {
				gyu[i] = Integer.parseInt(st.nextToken());
				isSelected[gyu[i] - 1] = true;
			}
			
			// 인영이 카드 정보 받아오기
			int count = 0;
			for (int i = 0; i < TOTAL_CARD_NUM; i++) {
				if (isSelected[i]) continue;
				in[count++] = i + 1;
			}
			
			long start = System.nanoTime();
			
			// NextPermutation으로 순열 적용하기
			// - 오름 차순 배열에서 내림 차순 배열까지의 순서를 지정하므로 정렬이 필요하다.
			// - NextPermutation은 while문으로 돌리면 변경된 배열부터 작업(처리)가 가능하므로 do-while문을 사용한다.
			// ===========================================================
			Arrays.sort(in);
			
			do { 
				chooseWinner();
			}while(nextPermutation(in));
			
			// ===========================================================
			
			long end = System.nanoTime();
			System.out.println((double)(end - start)/1000000000 + "초 소요");
		
			System.out.println("#" + testCase + " " + winCount + " " + looseCount);
			System.out.println();
			
			winCount = 0;
			looseCount = 0;
			Arrays.fill(isSelected, false);
			
		}
	}
	
	private static boolean nextPermutation(int[] pList) {
		int lastIndex = pList.length - 1;
		int top = lastIndex; // 꼭대기가 될 index
		
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
		int changingSpot = lastIndex; 
		for (int i = 0; i < pList.length; i++) {
			if (pList[top - 1] < pList[changingSpot]) {
				swap(pList, top - 1, changingSpot);
				break;
			}
			changingSpot--;
		}
		
		// 꼭지점부터 마지막까지 부분 오름차순으로 정렬하기
		int endPointer = lastIndex;
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
			if(gyu[i] < in[i]) {
				inScore += gyu[i] + in[i];
			} else {
				gyuScore += gyu[i] + in[i];
			}
		}
		
		if(gyuScore > inScore) {
			winCount++;
		} else if (gyuScore < inScore) {
			looseCount++;
		}
		
	}

}