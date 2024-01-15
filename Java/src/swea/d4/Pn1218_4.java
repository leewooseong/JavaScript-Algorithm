package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

// 괄호 짝짓기
public class Pn1218_4 {
	static Map<String, String> bracketMap = new HashMap<String, String>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/swea/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		bracketMap.put("(", ")");
		bracketMap.put("<", ">");
		bracketMap.put("[", "]");
		bracketMap.put("{", "}");

		List<String> leftArr = new ArrayList<String>(Arrays.asList("(", "<", "[", "{"));

		Stack<String> bracketStack = new Stack<>();

		int T = 10;

		for (int testCase = 1; testCase <= T; testCase++) {
			int result = 1;

			int stackLen = Integer.parseInt(br.readLine());
			char[] bracketArr = br.readLine().toCharArray();

			for (int i = 0; i < stackLen; i++) {
				String currentBracket = String.format("%s", bracketArr[i]);

				// 왼쪽 브라켓일 경우
				if (leftArr.contains(currentBracket)) {
					bracketStack.push(currentBracket);
				}
				// 오른쪽 브라켓일 경우
				else {
					String leftBracket;
					String rightBracket = currentBracket;

					// 비어있지 않다면 peek, 비어있으면 0 출력
					if (!bracketStack.isEmpty()) {
						leftBracket = bracketStack.peek();
					} else {
						result = 0;
						break;
					}

					// 페어가 맞는지 확인
					if (!bracketMap.get(leftBracket).equals(rightBracket)) {
						result = 0;
						break;
					} else {
						bracketStack.pop();
					}
				}
			}

			System.out.println("#" + testCase + " " + result);

			bracketStack.clear();
		}
	}
}
