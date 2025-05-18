package baekjoon.bronze.Num02702;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int helper(int a, int b) {
        if (a % b == 0) {
            return b;
        }

        return helper(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = helper(a, b);
            sb.append(a * b / k).append(" ").append(k).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}