package baekjoon.bronze.Num27110;

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
        for (int i = 0; i < 3; i++) {
            answer += Math.min(N, Integer.parseInt(st.nextToken()));
        }

        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
