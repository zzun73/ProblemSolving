package baekjoon.bronze.Num10865;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] count = new int[N];

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            count[Integer.parseInt(st.nextToken()) - 1]++;
            count[Integer.parseInt(st.nextToken()) - 1]++;
        }

        for (int val : count) {
            sb.append(val).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}