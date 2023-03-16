package baekjoon.silver.Num10867;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        boolean[] check = new boolean[2001];
        for (int i = 0; i < N; i++) {
            check[Integer.parseInt(st.nextToken()) + 1000] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < check.length; i++) {
            if (check[i]) {
                sb.append(i - 1000).append(" ");
            }
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
