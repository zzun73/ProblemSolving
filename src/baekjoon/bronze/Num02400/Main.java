package baekjoon.bronze.Num02400;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String[] arr = {"D", "C", "B", "A", "E"};
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int sum = 0;
            while (st.hasMoreTokens()) {
                sum += Integer.parseInt(st.nextToken());
            }
            sb.append(arr[sum]).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}