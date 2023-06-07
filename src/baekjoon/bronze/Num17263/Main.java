package baekjoon.bronze.Num17263;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int answer = 0;
        for (int i = 0; i < N; i++) {
            int X = Integer.parseInt(st.nextToken());
            answer = Math.max(X, answer);
        }
        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
