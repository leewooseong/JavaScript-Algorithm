package com.ssfay.live01.dist;

import java.util.Scanner;

/**
 * @author THKim
 */
/*
10
텐션업
 */
public class IO1_ScannerTest {

	public static void main(String[] args) {
		// 표준 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 기? : ");
		System.out.println("==> SSAFY : "+sc.nextInt());
		
		System.out.print("우리 기수를 나타내는 한마디 ? : ");
		System.out.print("==> 한마디 :"+sc.next()+"!");
		
//		System.out.print("==> 한마디 :"+sc.nextLine()+"!");
//		System.out.print("==> 한마디 :"+sc.nextLine()+"!");
		
		sc.close();
	}
}
