package baekjoon.bronze.Num28074;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] check = new int[5];
        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            switch (ch) {
                case 'M':
                    check[0] = 1;
                    break;
                case 'O':
                    check[1] = 1;
                    break;
                case 'B':
                    check[2] = 1;
                    break;
                case 'I':
                    check[3] = 1;
                    break;
                case 'S':
                    check[4] = 1;
                    break;
            }
        }
        int sum = 0;
        for (int val : check) {
            sum += val;
        }
        bw.write(sum == 5 ? "YES" : "NO");

        br.close();
        bw.flush();
        bw.close();
    }
}
