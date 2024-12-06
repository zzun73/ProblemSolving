package baekjoon.silver.Num14384;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            char[] input = br.readLine().toCharArray();
            int answer = 0;
            for (int i = 0; i < input.length - 1; i++) {
                if (input[i] != input[i + 1]) {
                    answer++;
                }
            }

            if (input[input.length - 1] == '-') {
                answer++;
            }
            sb.append("Case #").append(t).append(": ").append(answer).append('\n');
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}