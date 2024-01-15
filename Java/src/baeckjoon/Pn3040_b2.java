package baeckjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pn3040_b2 {

	static final int DWARF_NUM = 9;
	static int[] hatInfoArr = new int[DWARF_NUM];
	static boolean[] isSelected = new boolean[DWARF_NUM];
	static int[] sevenDwarfArr = new int [7];
	static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/baeckjoon/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < DWARF_NUM; i++) {
			hatInfoArr[i] = Integer.parseInt(br.readLine());
		}

		findSevenDwarf(0, 0);
	}
	
	// 조합
	private static void findSevenDwarf(int startIndex, int selectedCount) {
		// 종료 조건
		if(selectedCount == 7) {
			int sum = 0;
			for (int i = 0; i < sevenDwarfArr.length; i++) {
				sum += sevenDwarfArr[i];
			}
			
			if(sum == 100) {				
				sb = new StringBuilder();
				for (int i = 0; i < sevenDwarfArr.length; i++) {
					sb.append(sevenDwarfArr[i]).append("\n");
				}
				System.out.println(sb);
			}
			
			return;
		}
		
		// 7명 뽑는 로직
		for (int i = startIndex; i < hatInfoArr.length; i++) {
			sevenDwarfArr[selectedCount] = hatInfoArr[i];
			findSevenDwarf(i + 1, selectedCount + 1);
		}
		
	}
}
