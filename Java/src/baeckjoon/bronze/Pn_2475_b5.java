package baeckjoon.bronze;

import java.io.*;

public class Pn_2475_b5 {
    static int[] input = new int[5];
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/baeckjoon/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;

        String[] inputArray = br.readLine().split(" ");
        for(int i = 0; i < inputArray.length; i++){
            int inputNum = Integer.parseInt(inputArray[i]);
            result += inputNum * inputNum;
        }
        result = result % 10;

        System.out.println(result);
    }
}
