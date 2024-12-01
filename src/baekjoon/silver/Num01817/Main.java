package baekjoon.silver.Num01817;

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

        int answer = N > 0 ? 1 : 0;
        int weight = 0;
        if (N > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                int cur = Integer.parseInt(st.nextToken());
                weight += cur;
                if (weight > M) {
                    answer++;
                    weight = cur;
                }
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}