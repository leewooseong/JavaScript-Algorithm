package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Pn1225 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/swea/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int arrSize = 8;
		ArrayDeque<Integer> input = new ArrayDeque<>();
		
		for (int testCase = 1; testCase <= 10; testCase++) {
			int testNum =Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < arrSize; i++) {
				input.offer(Integer.parseInt(st.nextToken()));
			}
			
			int discountNum = 5;
			while(input.peekLast() != 0) {
				discountNum = (discountNum % 5) + 1;
				int inputNum = input.pollFirst() - discountNum;
				
				if(inputNum <= 0) {
					inputNum = 0;
					input.offerLast(inputNum);
				} else {				
					input.offerLast(inputNum);
				}
			}
			
			Iterator<Integer> iter = input.iterator();

			StringBuilder sb = new StringBuilder();
			sb.append("#").append(testCase).append(" ");
			while(iter.hasNext()) {
				sb.append(iter.next()).append(" ");				
			}
			System.out.println(sb);
			
			input.clear();
		}
	}
}
