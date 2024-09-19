package baekjoon.bronze.Num29752;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int answer = 0, cur = 0;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        while (N-- > 0) {
            int val = Integer.parseInt(st.nextToken());

            if (val == 0) {
                answer = Math.max(cur, answer);
                cur = 0;
                continue;
            }
            cur += 1;
        }
        answer = Math.max(cur, answer);

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}