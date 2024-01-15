package baeckjoon.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Pn2164_s4 {
	
	static ArrayDeque<Integer> cardQueue = new ArrayDeque();
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/baeckjoon/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cardNum = Integer.parseInt(br.readLine());
		
		// 입력 설정
		for (int i = 1; i <= cardNum; i++) {			
			cardQueue.offer(i);
		}
		
		// 카드 버리기 
		while(cardQueue.size() != 1) {
			System.out.println(cardQueue);
			cardQueue.poll();
			int lastNum = cardQueue.poll();
			cardQueue.offer(lastNum);
		}
		
		System.out.println(cardQueue.poll());
	}
}
