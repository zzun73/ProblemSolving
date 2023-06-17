package baekjoon.bronze.Num10886;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] cnt = new int[2];
        for (int i = 0; i < N; i++) {
            cnt[Integer.parseInt(br.readLine())]++;
        }
        bw.write(cnt[0] > cnt[1] ? "Junhee is not cute!" : "Junhee is cute!");
        br.close();
        bw.flush();
        bw.close();
    }
}
