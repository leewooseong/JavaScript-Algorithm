package baeckjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Pn12891_2 {

	static boolean[] isSelected;
	static char[] output;
	static char[] dnaArr;
	static int result = 0;

	static Map<Character, Integer> dnaMinimunCondition;
	static final char A = 'A';
	static final char C = 'C';
	static final char G = 'G';
	static final char T = 'T';
	
	static Set<String> checkedSubset = new HashSet<String>(); 

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/baeckjoon/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int dnaStrLen = Integer.parseInt(st.nextToken());
		int subStrLen = Integer.parseInt(st.nextToken());
		isSelected = new boolean[dnaStrLen];

		st = new StringTokenizer(br.readLine());
		dnaArr = st.nextToken().toCharArray();

		st = new StringTokenizer(br.readLine());
		dnaMinimunCondition = new HashMap<>();
		dnaMinimunCondition.put('A', Integer.parseInt(st.nextToken()));
		dnaMinimunCondition.put('C', Integer.parseInt(st.nextToken()));
		dnaMinimunCondition.put('G', Integer.parseInt(st.nextToken()));
		dnaMinimunCondition.put('T', Integer.parseInt(st.nextToken()));
		
		generateDNAPW(dnaArr, 0, 0, subStrLen);
		System.out.println(result);

	}

	private static void generateDNAPW(char[] dnaArr, int selectedCount, int elementIndex, int subStrLen) {
		// 카운팅 조건
//		if (subStrLen <= selectedCount && checkMinumumCondition(isSelected, selectedCount)) {
//			// 조건 확인 후 카운팅
//			result++;
//		}
		
		// 종료 조건
		if (elementIndex == dnaArr.length) {
			return;
		}

		// startIndex랑 dnaArr길이 차이로 발생하는 에러
		// 해당 요소(dnaChar[i])를 포함하는 경우
		isSelected[elementIndex] = true;
		generateDNAPW(dnaArr, selectedCount + 1,elementIndex + 1, subStrLen);

		// 해당 요소(dnaChar[i])를 포함하지 않는 경우
		isSelected[elementIndex] = false;
		generateDNAPW(dnaArr, selectedCount, elementIndex + 1, subStrLen);
		
		return;
	}

	private static String checkMinumumCondition(boolean[] isSelected, int selectedCount) {
		boolean result = true;

		int[] countArr = new int[4];
		// 부분 집합의 각 알파벳 객수 알아내기
		for (int i = 0; i < isSelected.length; i++) {
			if(isSelected[i] == true) {	
				switch (dnaArr[i]) {
				case A:
					countArr[0]++;
					break;
				case C:
					countArr[1]++;
					break;
				case G:
					countArr[2]++;
					break;
				case T:
					countArr[3]++;
					break;
				}
			}
		}
		
		String subsetString = "";
		for (int i = 0; i < countArr.length; i++) {
			subsetString += countArr[i] + "";
		}
		
		if(checkedSubset.contains(subsetString)) {
			return "";
		} else {
			checkedSubset.add(subsetString);
		}
		
		System.out.println(subsetString);
		System.out.println(Arrays.toString(isSelected));
		System.out.println("A  C  G  T");
		System.out.println(Arrays.toString(countArr));
		
		for (Map.Entry<Character, Integer> entry : dnaMinimunCondition.entrySet()) {
			char key = entry.getKey();		
			System.out.println(entry.getKey() + ": " + entry.getValue());

			switch (key) {
			case A:
				if (countArr[0] < entry.getValue()) {
//					return false;
					return null;
				}
				break;
			case C:
				if (countArr[1] < entry.getValue()) {
//					return false;
					return null;

				} 
				break;
			case G:
				if (countArr[2] < entry.getValue()) {
//					return false;
					return null;

				}
				break;
			case T:
				if (countArr[3] < entry.getValue()) {
//					return false;
					return null;
				}
				break;
			}			
		}
		return subsetString;
	}
}
