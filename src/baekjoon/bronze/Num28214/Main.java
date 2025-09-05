package baekjoon.bronze.Num28214;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int answer = 0;

        for (int i = 0; i < N; i++) {
            int zero = 0;
            for (int j = 0; j < K; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 0) {
                    zero++;
                }
            }

            if (zero < P) {
                answer++;
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}