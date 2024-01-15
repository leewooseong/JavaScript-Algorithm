package baeckjoon.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pn2563_s5 {

	static final int W_PAPER_SIZE = 100; 
	static final int C_PAPER_SIZE = 10; 
	
	static int colorPaperNum;
	static boolean[][] whitePaper = new boolean[100][100];
	static int[][] colorPaperInfo;
	static int colorPaperArea = 0;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/baeckjoon/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		
		colorPaperNum = Integer.parseInt(br.readLine());
		colorPaperInfo = new int[colorPaperNum][2];
		
		for (int i = 0; i < colorPaperNum; i++) {
			st = new StringTokenizer(br.readLine());
			colorPaperInfo[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};		
		}
		
		for (int i = 0; i < colorPaperNum; i++) {
			attachColorPaper(colorPaperInfo[i]);
		}
		
		System.out.println(colorPaperArea);
		
	}

	private static void attachColorPaper(int[] pInfo) {
		for (int i = pInfo[0]; i < pInfo[0] + C_PAPER_SIZE; i++) {
			for (int j = pInfo[1]; j < pInfo[1] + C_PAPER_SIZE; j++) {
				if(!whitePaper[i][j]) {
					whitePaper[i][j] = true;
					colorPaperArea++;
				}
			}
		}
	}
}
