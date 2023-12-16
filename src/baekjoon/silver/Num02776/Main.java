package baekjoon.silver.Num02776;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();

        while (T-- > 0) {
            set.clear();
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                set.add(Integer.parseInt(st.nextToken()));
            }

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < M; i++) {
                sb.append(set.contains(Integer.parseInt(st.nextToken())) ? 1 : 0).append("\n");
            }
        }
        sb.setLength(sb.length() - 1);
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}