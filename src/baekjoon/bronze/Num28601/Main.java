package baekjoon.bronze.Num28601;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken()) - N + i;
            if (answer < cur) {
                answer = cur;
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}