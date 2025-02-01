package baekjoon.silver.Num22233;

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

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> memo = new HashSet<>();
        Set<String> blog = new HashSet<>();

        for (int i = 0; i < N; i++) {
            memo.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), ",");

            while (st.hasMoreTokens()) {
                String cur = st.nextToken();
                if (memo.contains(cur)) {
                    memo.remove(cur);
                    blog.remove(cur);
                }

            }
            sb.append(memo.size()).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}