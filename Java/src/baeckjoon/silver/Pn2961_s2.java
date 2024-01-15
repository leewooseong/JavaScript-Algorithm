package baeckjoon.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 도영이의 맛잇는 요리
public class Pn2961_s2 {
	
	static int ingredientNum;
	static int usingIngredientNum;
	static int[][] ingredientInfoArr;
	static int result = -1;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/baeckjoon/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int ingredientNum = Integer.parseInt(st.nextToken());
		
		ingredientInfoArr = new int[ingredientNum][2];
		
		for (int i = 0; i < ingredientNum ; i++) {
			st = new StringTokenizer(br.readLine());
			ingredientInfoArr[i][0] = Integer.parseInt(st.nextToken());
			ingredientInfoArr[i][1] = Integer.parseInt(st.nextToken());
		} 
		
		for (int i = 1; i <= ingredientNum; i++) {
			System.out.println(i + " case" );
			usingIngredientNum = i;
			combination(ingredientInfoArr, 0, 0, new int[i][2]);
		}
		
		System.out.println("결과 : " + result);
		
	}
	
	private static void combination(int[][] ingredientInfoArr, int startIndex, int selectedNum, int[][] selectedIngredients) {
		// 종료 조건
		// 재료 수 만큼 
		if(selectedNum == usingIngredientNum) {
			calculateDifference(selectedIngredients);
			return;
		}
		
		for (int i = startIndex; i < ingredientInfoArr.length ; i++) {
			selectedIngredients[selectedNum] = ingredientInfoArr[i];
			combination(ingredientInfoArr, i + 1, selectedNum + 1, selectedIngredients);
		}
		
		return;
	}
	
	private static void calculateDifference(int[][] selectedIngredients) {
		int diffrence;
		int sourTaste = 1;
		int bitterTaste = 0;
		for (int i = 0; i < selectedIngredients.length; i++) {
			sourTaste *= selectedIngredients[i][0];
			bitterTaste += selectedIngredients[i][1];
		}
		
		diffrence = Math.abs(sourTaste - bitterTaste);
		
		System.out.println(Arrays.deepToString(selectedIngredients));
		System.out.println(diffrence);
		
		if (result == -1) {
			result = diffrence;
		}
		result = result > diffrence ? diffrence : result ;
	}
}
