package baeckjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Pn1244 {
	static int start, end = 0;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/baeckjoon/input.txt"));		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int switchNum = Integer.parseInt(br.readLine()); // 스위치 개수
		String[] tmp = br.readLine().split(" ");

		// 입력
		// - 0 인덱스는 안쓰는 것으로 처리
		int[] switchStatus = new int[switchNum + 1];
		for (int i = 1; i <= tmp.length; i++) {
			switchStatus[i] = Integer.parseInt(tmp[i-1]);
		}

		// 학생 정보 입력
		int studentNum = Integer.parseInt(br.readLine());
		
		while (studentNum-- > 0) {
			String[] line = br.readLine().split(" ");
			int gender = Integer.parseInt(line[0]);
			int num = Integer.parseInt(line[1]);

			if (gender == 1) { // 남학생
				for (int j = 1; j <= switchNum / num; j++) {
					// 상태 교체
					if (switchStatus[num * j] == 1) {
						switchStatus[num * j] = 0;
					} else {
						switchStatus[num * j] = 1;
					}
				}
				System.out.println("boys : " + Arrays.toString(switchStatus));
				
			} else if (gender == 2) { // 여학생
				
				changeStatus(num, switchStatus, 1);

				if (end != 0) {
					for (int j = start; j <= end; j++) { // 가장 많은 대칭 범위를 상태변경?
						if (switchStatus[j] == 1) {
							switchStatus[j] = 0;
						} else {
							switchStatus[j] = 1;
						}
					}
				}
				else {
					if (switchStatus[num] == 1) {
						switchStatus[num] = 0;
					} else {
						switchStatus[num] = 1;
					}
				}
				end = 0;
				start = 0;
				System.out.println("girl : " + Arrays.toString(switchStatus));
			}
		}
		// 출력
		for (int i = 1; i <= switchNum; i++) {
			System.out.print(switchStatus[i] + " ");
			if (i % 20 == 0)
				System.out.println();
		}
	}

	// 여학생 로직
	// index : 여학생이 받은 카드 수
	// status : 스위치 상태
	// i : 중심점으로 부터의 비교 거리
	public static void changeStatus(int index, int[] status, int i) {
		// 받은 카드 index - i >= i && index + i
		if (index - i >= 1 && index + i <= status.length) {
			if (status[index - i] == status[index + i]) { // 대칭이면
				start = index - i;
				end = index + i;
				changeStatus(index, status, i + 1);
			}
			return;
		}
		return;
	}
}




//package baeckjoon;
//
//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//// 8				: 스위치 개수
//// 0 1 0 1 0 0 0 1	: 각 스위치 상태
//// 2				: 학생 수
//// 1 3				: 여자, 3명
//// 2 3				: 남자, 3명
//
//// 1 0 1 0 1 0 0 1
//// 1 0 0 0 1 1 0 1
//
//public class Pn1244 {
//	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("src/baeckjoon/input.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//
//		// 전구 입력 배열 만들기
//		st = new StringTokenizer(br.readLine());
//		int numOfLights = Integer.parseInt(st.nextToken());
//		int[] lights = new int[numOfLights];
//
//		st = new StringTokenizer(br.readLine());
//		for (int i = 0; i < numOfLights; i++) {
//			lights[i] = Integer.parseInt(st.nextToken());
//		}
//		
//		// 학생 입력 배열 만들기
//		st = new StringTokenizer(br.readLine());
//		int numOfStudents = Integer.parseInt(st.nextToken());
//		int[][] students = new int[numOfStudents][2];
//
//		for (int i = 0; i < numOfStudents; i++) {
//			st = new StringTokenizer(br.readLine());
//			students[i][0] = Integer.parseInt(st.nextToken());
//			students[i][1] = Integer.parseInt(st.nextToken());
//		}
//
//		// 전구 switching
//		int gender;
//		int num;
//		int numIndex;
//		
//		for (int i = 0; i < students.length; i++) {
//			gender = students[i][0];
//			num = students[i][1];
//			numIndex = num - 1;
//			
//			if (gender == 1) {
//				switchMultiple(lights, num, numIndex);
//			} else if (gender == 2) {
//				switchSymmetry(lights, numIndex);
//			}
//		}
//
//		// 결과 출력
//		for (int i = 0; i < lights.length; i++) {
//			if ((i+1) % 20 == 0) {
//				System.out.print(lights[i]);
//				System.out.println();				
//			} else {				
//				System.out.print(lights[i] + " ");
//			}
//		}
//	}
//
//	public static void switchSymmetry(int[] lights, int numIndex) {
//		int left = numIndex;
//		int right = numIndex;
//
//		lights[numIndex] = lights[numIndex] == 0 ? 1 : 0;
//		
//		while ((left - 1 >= 0 && right + 1 < lights.length) && (lights[left - 1] == lights[right + 1])) {
//			lights[left - 1] = lights[left - 1] == 0 ? 1 : 0;				
//			lights[right + 1] = lights[right + 1] == 0 ? 1 : 0;				
//			left--;
//			right++;
//		}
//	}
//
//	public static void switchMultiple(int[] lights, int num, int numIndex) {
//		for (int i = numIndex; i < lights.length; i += num) {
//			lights[i] = lights[i] == 0 ? 1 : 0;							
//		}
//	}
//}
