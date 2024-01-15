package com.ssfay.live01.dist;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 
 * @author THKim
 *
 */
public class IO4_BufferedReaderScannerTest {

	static String path = ".\\src\\com\\ssafy\\live01\\dist\\input.txt";
	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream(path));
		Scanner sc = new Scanner(System.in);

		long start = System.nanoTime();
		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			int N = sc.nextInt();
			int sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sum += sc.nextInt();
				}
			}
			System.out.println("#" + tc + " " + sum);
		}
		long end = System.nanoTime();
		// 자바에서 숫자 쓸 때 _를 써도 유효한 숫자로 인식하기 때문에 이렇게 처리할 수 있다.
		System.out.println((end - start) / 1_000_000_000.0 + "s");
	} 
	
//	public static void main(String[] args) throws IOException {
//
//		System.setIn(new FileInputStream(path));
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		
//		long start = System.nanoTime();
//		int TC = Integer.parseInt(in.readLine());
//		
//		for (int tc = 1; tc <= TC; tc++) {
//			int N = Integer.parseInt(in.readLine());
//			int sum = 0;
//			for (int i = 0; i < N; i++) {
//				StringTokenizer st = new StringTokenizer(in.readLine()," ");
//				for (int j = 0; j < N; j++) {
//					sum += Integer.parseInt(st.nextToken());
//				}
//			}
//			System.out.println("#"+tc+" "+sum);
//		}
//		long end = System.nanoTime();
//		System.out.println((end-start)/1_000_000_000.0 +"s");
//	} 
	
}
