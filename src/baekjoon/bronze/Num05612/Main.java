package baekjoon.bronze.Num05612;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int answer = M;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            M += A;
            M -= B;
            answer = Math.max(answer, M);
            if (M < 0) {
                answer = 0;
                break;
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}