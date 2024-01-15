package baeckjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 어떤 가맹점들을 M개 고르면 도시의 치킨 거리가 가장 작아질 것인가.
// 브루트포스라.. 


public class Pn15686_g5 {

	static int citySize;
	static int maxStore;
	
	static int[][] cityInfoArr;
	static int[][] storeInfo;
	static int[][] houseInfo;
	
	static int[][] selectedStore;
	
	static int minDistance = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/baeckjoon/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		citySize = Integer.parseInt(st.nextToken());
		maxStore = Integer.parseInt(st.nextToken());
		selectedStore = new int[maxStore][2];
		
		cityInfoArr = new int[citySize][citySize];
		
		int storeCount = 0;
		int houseCount = 0;
		for (int i = 0; i < cityInfoArr.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < cityInfoArr.length; j++) {
				cityInfoArr[i][j] =  Integer.parseInt(st.nextToken());
				if(cityInfoArr[i][j] == 1) {
					houseCount++;
				}
				if(cityInfoArr[i][j] == 2) {
					storeCount++;
				}
			}
		}
		
		// 가게 좌표 정보
		// (store좌표 x, y, d(모든 집까지의 거리)) 
		storeInfo = new int[storeCount][2];
		// 가게별 집 거리 정보
		houseInfo = new int[houseCount][2];
		
		// 정보 뽑아내기 
		for (int i = 0; i < cityInfoArr.length; i++) {
			for (int j = 0; j < cityInfoArr.length; j++) {
				if(cityInfoArr[i][j] == 1) {
					houseInfo[--houseCount][0] = i;
					houseInfo[houseCount][1] = j;
				}
				
				if(cityInfoArr[i][j] == 2) {
					System.out.println(i +" "+ j + " " + storeCount);
					storeInfo[--storeCount][0] = i;
					storeInfo[storeCount][1] = j;
				}
			}
		}
		
		combination(0, 0);
	
		System.out.println(minDistance);
	}
	
	// 각 치킨집에서 집까지의 거리 구하기  
	private static int getCityDistance(int[][] selectedStore) {
		int result = 0;
		int minDistance = Integer.MAX_VALUE;
		
		System.out.println(Arrays.deepToString(houseInfo));
		System.out.println(Arrays.deepToString(selectedStore));
		
		for (int j = 0; j < houseInfo.length; j++) {
			for (int i = 0; i < selectedStore.length; i++) {
				int distance = getDistance(houseInfo[j], selectedStore[i]);
				minDistance = minDistance < distance ? minDistance : distance;
			}
			result += minDistance;
			minDistance = Integer.MAX_VALUE;
		}
		
		return result;
	}
	
	private static int getDistance(int[] spotA, int[] spotB) {
		return Math.abs(spotA[0] - spotB[0]) + Math.abs(spotA[1] - spotB[1]); 
	}
	
	private static void combination(int selectedCount, int startIndex) {
		// 종료 조건
		if(selectedCount == maxStore) {
			int cityDistance = getCityDistance(selectedStore);
			minDistance = minDistance < cityDistance ? minDistance : cityDistance;
			return;
		}
		
		for (int i = startIndex; i < storeInfo.length; i++) {
			selectedStore[selectedCount][0] = storeInfo[i][0];
			selectedStore[selectedCount][1] = storeInfo[i][1];
			combination(selectedCount + 1, i + 1);
		}
	}
	
}
