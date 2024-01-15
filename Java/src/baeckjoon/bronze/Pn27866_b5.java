package baeckjoon.bronze;

import java.io.*;

public class Pn27866_b5 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/baeckjoon/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] text = br.readLine().toCharArray();
        int index = Integer.parseInt(br.readLine()) - 1;

        System.out.println(text[index]);
    }
}
