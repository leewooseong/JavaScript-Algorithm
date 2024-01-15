import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution {
    static char[] tankCharList = new char[]{'^', 'v', '>', '<'};
	static int[] tLoc = new int[2];
	
	static char[][] matrix;
	static int rSize;	// 2 <= r,c <= 20
	static int cSize;
	
	static int cmdNum; // 0 < cmdNum <= 100
	static char[] cmdArr;
	
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 }  };
	static int cDir;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			rSize = Integer.parseInt(st.nextToken());
			cSize = Integer.parseInt(st.nextToken());
			matrix = new char[rSize][cSize];
			
			
			// 배열 입력받기
			for (int i = 0; i < rSize; i++) {
				matrix[i] = br.readLine().toCharArray();
				for (int j = 0; j < cSize; j++) {
					for (int j2 = 0; j2 < tankCharList.length; j2++) {
						if(matrix[i][j] == tankCharList[j2]) {
							tLoc[0] = i;
							tLoc[1] = j;				
							setCDir(matrix[i][j]);
						}
					}
				}
			}
			
			cmdNum = Integer.parseInt(br.readLine());
			cmdArr = br.readLine().toCharArray();
			
			for (int i = 0; i < cmdNum; i++) {
				executeCmd(cmdArr[i]);
			}
			
			System.out.print("#" + testCase + " ");
			printResult();
		}
	}
	
	private static void setCDir(char cValue) {
		switch(cValue) {
		case '^':
			cDir = 0;
			break;
		case 'v':
			cDir = 1;
			break;
		case '>':
			cDir = 2;
			break;
		case '<':
			cDir = 3;
			break;
		default:
			break;
		}
	}
	
	// 명령어를 입력 받고, 해당 명령어에 따른 처리 수행
	private static void executeCmd(char cmd) {
		switch(cmd) {
			case 'U':
				changeDir('^');
				move(dir[0]);
				break;
			case 'D':
				changeDir('v');
				move(dir[1]);
				break;
			case 'R':
				changeDir('>');
				move(dir[2]);
				break;
			case 'L':
				changeDir('<');
				move(dir[3]);
				break;
			case 'S':
				shoot();
				break;
			default:
				break;
		}

	}
	
	private static void changeDir(char dir) {
		matrix[tLoc[0]][tLoc[1]] = dir;
		setCDir(dir);
	}

	private static void move(int[] dir) {
		int[] cLoc = new int[] {tLoc[0] + dir[0], tLoc[1] + dir[1]};
		
		if(isInBoundary(new int[] {0,0}, rSize, cSize, cLoc) 
				&& matrix[cLoc[0]][cLoc[1]] == '.') {
			matrix[tLoc[0]][tLoc[1]] = '.';
			tLoc[0] = cLoc[0];
			tLoc[1] = cLoc[1];
			matrix[tLoc[0]][tLoc[1]] = tankCharList[cDir];
		}
		
	}
	
	private static void shoot() {
		// bullet location
		int[] bLoc = new int[] {tLoc[0] + dir[cDir][0], tLoc[1] + dir[cDir][1]};
		char landInfo = '\u0000';
		
		while(isInBoundary(new int[] {0,0}, rSize, cSize, bLoc)) {
			landInfo = matrix[bLoc[0]][bLoc[1]];
			if (landInfo == '#') {
				break;
			} else if(landInfo == '*') {				
				matrix[bLoc[0]][bLoc[1]] = '.';
				break;
			}
			
			bLoc = new int[] {bLoc[0] + dir[cDir][0], bLoc[1] + dir[cDir][1]};
		}
	}

	
	// 바운더리를 넘어갔는지 확인하는 함수
	// - sPoint : 시작점
	// - rowSize : 행 크기
	// - colSize : 열 크기
	// - cPoint : 현재 비교할 포인트
	private static boolean isInBoundary(int[] sPoint, int rowSize, int colSize, int[] cPoint) {
		// 시작 포인트와 끝 포인트 찾기
		int sRowIndex = sPoint[0];
		int sColIndex = sPoint[1];
		int eRowIndex = sRowIndex + rowSize;
		int eColIndex = sColIndex + colSize;
		
		// 현재 포인트의 범위 체크
		if ((cPoint[0] >= sRowIndex && cPoint[0] < eRowIndex) && (cPoint[1] >= sColIndex && cPoint[1] < eColIndex)) {
			return true;
		}

		return false;
	}
	
	private static void printResult() {
		for (int i = 0; i < rSize; i++) {
			for (int j = 0; j < cSize; j++) {
				System.out.print(matrix[i][j]);
			}	
			System.out.println();
		}
	}

}