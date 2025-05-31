package baekjoon.silver.Num12596;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            Set<Integer> set = new HashSet<>();
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                int X = Integer.parseInt(st.nextToken());
                if (set.contains(X)) {
                    set.remove(X);
                } else {
                    set.add(X);
                }
            }
            sb.append("Case #").append(t).append(": ");
            for (int x : set) {
                sb.append(x);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}