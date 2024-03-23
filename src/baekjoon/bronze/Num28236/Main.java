package baekjoon.bronze.Num28236;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int distance = Integer.MAX_VALUE;
        int answer = 0;
        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int f = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int cur = f - 1 + m - d;
            if (cur < distance) {
                distance = cur;
                answer = i;
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}
