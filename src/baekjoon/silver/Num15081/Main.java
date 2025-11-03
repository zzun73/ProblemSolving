package baekjoon.silver.Num15081;

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

        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int M = Integer.parseInt(st.nextToken());
            for (int i = 0; i < M; i++) {
                String cur = st.nextToken();
                if (!set.contains(cur)) {
                    set.add(cur);
                    sb.append(cur).append(" ");
                    break;
                }
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}