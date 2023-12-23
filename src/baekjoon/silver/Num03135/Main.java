package baekjoon.silver.Num03135;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());

        int diff = Math.abs(A - B);
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(br.readLine());
            diff = Math.min(diff, Math.abs(cur - B) + 1);
        }
        bw.write(String.valueOf(diff));

        br.close();
        bw.flush();
        bw.close();
    }
}