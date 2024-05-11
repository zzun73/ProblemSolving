package baekjoon.silver.Num30404;

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

        int last;
        int answer = 1;
        st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        last = x;
        for (int i = 1; i < N; i++) {
            x = Integer.parseInt(st.nextToken());

            if (last + K < x) {
                answer++;
                last = x;
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}