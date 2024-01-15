package baeckjoon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Pn1961 {
//	static String input = "/Users/leewooseong/eclipse-workspace/algorithm/src/input.txt";
	static String input = "C:\\ssafy10\\workspace\\02_java\\algorithm\\src\\input.txt"; 

	public static void main(String[] args) throws FileNotFoundException {
	
		System.setIn(new FileInputStream("src/baeckjoon/input.txt"));
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		
		// Test case Input 
		int T = sc.nextInt();  
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int arrSize = sc.nextInt();
			int [][] inputArr = new int[arrSize][arrSize];
			int [][] spinnedArr = new int[arrSize][arrSize];
			// set Input Array
			for (int i = 0; i < arrSize; i++) {
				for (int j = 0; j < arrSize; j++) {					
					inputArr[i][j] = sc.nextInt();
				}
			}
//			System.out.println(Arrays.deepToString(spinnedArr));
			
			System.out.println("#"+test_case);
			
			for (int i = 0; i < arrSize; i++) {
				for (int j = 0; j < arrSize; j++) {					
					System.out.print(inputArr[arrSize - 1 - j][i]);
				}
				System.out.print(" ");
				for (int j = 0; j < arrSize; j++) {					
					System.out.print(inputArr[arrSize -1 - i][arrSize - 1 - j]);
				}
				System.out.print(" ");
				for (int j = 0; j < arrSize; j++) {					
					System.out.print(inputArr[j][arrSize - 1 - i]);
				}
				System.out.println();
			}
		}
	}
}