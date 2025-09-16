package baekjoon.bronze.Num09907;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int[] arr = {2, 7, 6, 5, 4, 3, 2};
        int sum = 0;

        for (int i = 0; i < 7; i++) {
            int d = str.charAt(i) - '0';
            sum += d * arr[i];
        }
        char[] map = {'J', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'Z'};

        bw.write(String.valueOf(map[sum % 11]));

        br.close();
        bw.close();
    }
}