package baekjoon.bronze.Num20361;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, X, K, A, B, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        answer = X;

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            if (A == answer) {
                answer = B;
            } else if (answer == B) {
                answer = A;
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}
