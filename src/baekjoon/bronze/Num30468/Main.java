package baekjoon.bronze.Num30468;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int sum, N, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        sum = answer = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            sum += Integer.parseInt(st.nextToken());
        }

        N = Integer.parseInt(st.nextToken());
        while (sum / 4 < N) {
            sum++;
            answer++;
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}