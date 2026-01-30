package baekjoon.silver.Num23253;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            int K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            int prev = 200_001;

            for (int j = 0; j < K; j++) {
                int cur = Integer.parseInt(st.nextToken());
                if (prev < cur) {
                    bw.write("No");
                    bw.close();
                    return;
                }
                prev = cur;
            }
        }

        bw.write("Yes");
        br.close();
        bw.close();
    }
}