package baekjoon.bronze.Num10874;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            boolean isPerfect = true;

            for (int j = 1; j <= 10; j++) {
                int ans = Integer.parseInt(st.nextToken());
                int expected = ((j - 1) % 5) + 1;
                if (isPerfect && ans != expected) {
                    isPerfect = false;
                }
            }

            if (isPerfect) {
                sb.append(i).append("\n");
            }
        }


        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}